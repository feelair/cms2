package com.turingoal.cms.modules.ext.repository;

import java.util.List;
import com.turingoal.cms.modules.ext.domain.GuestbookType;
import com.turingoal.cms.modules.ext.domain.form.GuestbookTypeForm;
import com.turingoal.cms.modules.ext.domain.query.GuestbookTypeQuery;

/**
 * 留言板类型Dao
 */
public interface GuestbookTypeDao {

    /**
     * 查询 留言板类型
     */
    List<GuestbookType> find(final GuestbookTypeQuery query);

    /**
     * 通过id得到一个 留言板类型
     */
    GuestbookType get(final String id);

    /**
     * 新增 留言板类型
     */
    void add(final GuestbookTypeForm form);

    /**
     * 修改 留言板类型
     */
    int update(final GuestbookTypeForm form);

    /**
     * 根据id删除一个 留言板类型
     */
    int delete(final String id);
}