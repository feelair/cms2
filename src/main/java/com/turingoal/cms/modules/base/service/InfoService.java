package com.turingoal.cms.modules.base.service;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.form.InfoForm;
import com.turingoal.cms.modules.base.domain.form.InfoSpecialForm;
import com.turingoal.cms.modules.base.domain.query.InfoQuery;

/**
 * InfoService
 */
public interface InfoService {

    /**
     * 分页查询 Info
     */
    Page<Info> findByPage(final InfoQuery query);

    /**
     * 分页查询未选择 Info
     */
    Page<Info> findUnInfo(final InfoQuery query);

    /**
     * 分页查询已选择 Info
     */
    Page<Info> findInfo(final InfoQuery query);

    /**
     * 通过id得到一个 Info
     */
    Info get(final String id);

    /**
     * 新增 Info
     */
    void add(final InfoForm form, final Map<String, String> cusMap);

    /**
     * 修改 Info
     */
    int update(final InfoForm form, final Map<String, String> cusMap);

    /**
     * 根据id删除一个 Info
     */
    int delete(final String id);

    /**
     * 审核通过
     */
    int updatePassInfo(final String id);

    /**
     * 退稿/退回/审核通过
     */
    int updateBackInfo(final String id);

    /**
     * 根据id获取上一篇文章信息
     */
    Info prevOne(String id);

    /**
     * 根据id获取下一篇文章信息
     */
    Info nextOne(String id);

    /**
     * 根据多个id查询info
     */
    List<Info> findByIds(List<String> ids);

    /**
     * 新增 文章、专题关系
     */
    void addRelation(final InfoForm form);

    /**
     * 删除 文章、专题关系
     */
    int deleteRelation(final String id);

    /**
     * 修改 文章、专题排序
     */
    int updateOrder(final InfoSpecialForm form);

    /**
     * 更新浏览次数
     */
    void updateViewsCount(String id);

    /**
     * 获取所有
     */
    List<Info> findAll(InfoQuery infoQuery);
}