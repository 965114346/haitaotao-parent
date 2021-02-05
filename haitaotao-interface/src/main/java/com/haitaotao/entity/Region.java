package com.haitaotao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 行政区域表
 *
 * @author yangyang
 * @date 2021-1-5 16:36:12
 */
@Data
@Accessors(chain = true)
public class Region implements Serializable {

    /**
     * 
     */
    private Long id;

    /**
     * 行政区域父ID，例如区县的pid指向市，市的pid指向省，省的pid则是0
     */
    private Long parentId;

    /**
     * 行政区域名称
     */
    private String name;

    /**
     * 行政区域类型，如如1则是省， 如果是2则是市，如果是3则是区县
     */
    private Integer type;

    /**
     * 行政区域编码
     */
    private Long code;

    //-----------------------------拓展属性

    private boolean hasChildren;
}