package com.haitaotao.api.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Producer;
import com.google.common.cache.Cache;
import com.haitaotao.api.admin.annotations.CurrentAdmin;
import com.haitaotao.api.admin.dto.AdminLoginDTO;
import com.haitaotao.api.admin.util.UUIDUtil;
import com.haitaotao.api.admin.vo.KaptchaVO;
import com.haitaotao.api.admin.vo.LoginVO;
import com.haitaotao.api.admin.vo.UserInfoVO;
import com.haitaotao.common.util.ResponseUtil;
import com.haitaotao.entity.Admin;
import com.haitaotao.service.IPermissionService;
import com.haitaotao.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author yangyang
 * @date 2021/1/11 14:43
 */
@Slf4j
@Api(value = "登录模块")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private Cache<String, String> stringCache;

    @Autowired
    private Producer producer;

    @DubboReference
    private IRoleService roleService;

    @DubboReference
    private IPermissionService permissionService;

    @ApiOperation(value = "获取验证码", httpMethod = "GET")
    @GetMapping("/kaptcha")
    public Object kaptcha(String kaptchaKey) {
        if (StringUtils.isBlank(kaptchaKey)) {
            kaptchaKey = UUIDUtil.randomUUID();
        }
        String kaptcha = doKaptcha(kaptchaKey);
        if (StringUtils.isNotBlank(kaptcha)) {
            return ResponseUtil.ok(new KaptchaVO(kaptchaKey, kaptcha));
        }
        return ResponseUtil.error();
    }

    @ApiOperation(value = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public Object login(@Valid @RequestBody AdminLoginDTO adminLoginDTO) {
        String kaptcha = stringCache.getIfPresent(adminLoginDTO.getCodeKey());
        if (StringUtils.isBlank(kaptcha)) {
            return ResponseUtil.error("验证码已失效，请刷新");
        }
        if (!StringUtils.equalsIgnoreCase(kaptcha, adminLoginDTO.getCode())) {
            return ResponseUtil.error("验证码不正确");
        }

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(adminLoginDTO.getUsername(), adminLoginDTO.getPassword()));
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return ResponseUtil.error("用户帐号或密码不正确");
        } catch (DisabledAccountException e) {
            return ResponseUtil.error("用户帐号已锁定不可用");
        } catch (AuthenticationException e) {
            return ResponseUtil.error("登录失败");
        }

        Admin admin = (Admin) subject.getPrincipal();
        return ResponseUtil.ok(new LoginVO(admin.getToken()));
    }

    @ApiOperation(value = "获取用户信息", httpMethod = "GET")
    @GetMapping("/getUserInfo")
    public Object roleAndPermission(@CurrentAdmin Admin admin) {
        List<Integer> roleIds = JSONObject.parseArray(admin.getRoleIds(), Integer.class);

        Set<String> roles = roleService.listNameByIds(roleIds);
        Set<String> permissions = permissionService.listNameByRoleIds(roleIds);

        return ResponseUtil.ok(new UserInfoVO(admin.getUsername(), admin.getAvatar(), roles, permissions));
    }

    /**
     * 生成验证码
     * @param kaptchaKey
     * @return
     */
    private String doKaptcha(String kaptchaKey) {
        String text = producer.createText();
        log.info("kaptcha: {}", text);
        BufferedImage image = producer.createImage(text);
        stringCache.put(kaptchaKey, text);

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", outputStream);
            BASE64Encoder encoder = new BASE64Encoder();
            String base64 = encoder.encode(outputStream.toByteArray());
            return "data:image/jpeg;base64,".concat(base64.replaceAll("\r\n", ""));
        } catch (IOException e) {
            return null;
        }
    }
}
