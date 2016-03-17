package com.turingoal.cms.modules.ext.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 调查问卷选项 
 */
@Data
public class QuestionOption implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id; // 调查问卷选项
    private String itemId; // itemId
    private String title; // 标题
    private String inputField; // 是否输入框
    private Integer selectCount; // 得票数
    private Integer sortOrder; // 排序
}