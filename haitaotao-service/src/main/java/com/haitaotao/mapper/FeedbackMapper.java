package com.haitaotao.mapper;

import com.haitaotao.entity.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 意见反馈表
 *
 * @author yangyang
 * @date 2021-1-5 17:14:27
 */
public interface FeedbackMapper {

    /**
     * 查询用户意见反馈列表
     * @param username 用户名
     * @param id 反馈id
     * @return 用户意见反馈列表
     */
    List<Feedback> listByCondition(@Param("username") String username, @Param("id") Long id);
}