package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 问题创建DTO
 * @author yangyang
 * @date 2021/4/9 16:50
 */
@Data
public class IssueCreateDTO {

    /**
     * 问题标题
     */
    @NotBlank
    private String question;

    /**
     * 问题答案
     */
    @NotBlank
    private String answer;
}
