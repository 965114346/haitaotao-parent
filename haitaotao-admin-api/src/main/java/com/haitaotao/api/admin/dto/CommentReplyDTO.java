package com.haitaotao.api.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 评论回复
 * @author yangyang
 * @date 2021/4/26 14:53
 */
@Data
public class CommentReplyDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String adminContent;
}
