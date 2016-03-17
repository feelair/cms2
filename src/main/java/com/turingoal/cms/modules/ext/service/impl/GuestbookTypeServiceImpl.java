package com.turingoal.cms.modules.ext.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.turingoal.cms.modules.ext.domain.GuestbookType;
import com.turingoal.cms.modules.ext.domain.form.GuestbookTypeForm;
import com.turingoal.cms.modules.ext.domain.query.GuestbookTypeQuery;
import com.turingoal.cms.modules.ext.repository.GuestbookDao;
import com.turingoal.cms.modules.ext.repository.GuestbookTypeDao;
import com.turingoal.cms.modules.ext.service.GuestbookTypeService;
import com.turingoal.common.annotation.MethodLog;

/**
 * 留言类型Service
 */
@Service
public class GuestbookTypeServiceImpl implements GuestbookTypeService {
    @Autowired
    private GuestbookTypeDao guestbookTypeDao;
    @Autowired
    private GuestbookDao guestbookDao;

    /**
     * 查询全部 留言类型
     */
    @MethodLog(name = "查询全部留言类型", description = "根据条件查询全部的留言类型，不分页")
    public Page<GuestbookType> findAll(final GuestbookTypeQuery query) {
        PageHelper.startPage(query.getPage().intValue(), query.getLimit().intValue());
        Page<GuestbookType> result = (Page<GuestbookType>) guestbookTypeDao.find(query);
        return result;
    }

    /**
     * 通过id得到一个 留言类型
     */
    @MethodLog(name = "通过id得到留言类型", description = "通过id得到一个留言类型")
    public GuestbookType get(final String id) {
        return guestbookTypeDao.get(id);
    }

    /**
     * 新增 留言类型
     */
    @MethodLog(name = "新增留言类型", description = "新增一个留言类型，返回id")
    public void add(final GuestbookTypeForm form) {
        guestbookTypeDao.add(form);
    }

    /**
     * 修改 留言类型
     */
    @MethodLog(name = "修改留言类型", description = "修改一个留言类型")
    public int update(final GuestbookTypeForm form) {
        return guestbookTypeDao.update(form);
    }

    /**
     * 根据id删除一个 留言类型
     */
    @MethodLog(name = "删除留言类型", description = "根据id删除一个留言类型")
    public int delete(final String id) {
        guestbookDao.deleteByTypeId(id);
        return guestbookTypeDao.delete(id);
    }
}