package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 问题更新DTO
 * @author yangyang
 * @date 2021/4/9 16:50
 */
@Data
public class IssueUpdateDTO {

    @NotNull
    private Long id;

    /**
     * 问题标题
     */
    private String question;

    /**
     * 问题答案
     */
    private String answer;
}
