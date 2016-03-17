package com.turingoal.cms.modules.base.domain.query;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.turingoal.common.bean.BaseQueryBean;

/**
 * SpecialTypeQuery 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SpecialTypeQuery extends BaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id; // 专题类别
    private String typeName; // 名称
    private Date createDataTime; // 创建日期
    private Integer viewsCount; // 浏览总数
    private String metaKeywords; // 关键字
    private String metaDescription; // 描述
    private Integer sortOrder; // 排序
}