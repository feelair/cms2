package com.turingoal.cms.core.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.core.domain.Resource;
import com.turingoal.cms.core.domain.form.ResourceForm;

/**
 * ResourceDao
 */
public interface ResourceDao {

    /**
     * 获取所有启用的菜单
     */
    List<Resource> findAllMenusEnabled();

    /**
     * 获取启用的一级菜单
     */
    List<Resource> findFirstLevelMenusEnabled();

    /**
     * 根据父菜单获取启用的子菜单
     */
    List<Resource> findChildrenMenusEnabled(final String parentId);

    /**
     * 根据用户id获取资源id
     */
    List<String> findIdsEnabledByUserId(final String userId);

    /**
     * 查询所有的Permission
     */
    List<String> findPermissions();

    /**
     * 查询所有可用的Permission
     */
    List<String> findPermissionsEnabled();

    /**
     * 查询所有可用的Permission
     */
    List<String> findPermissionsByUser(String userId);

    /**
     * 查询全部 Resource
     */
    List<Resource> find();

    /**
     * 查询全部 Resource
     */
    List<Resource> getResourceTree(final String roleId);

    /**
     * 查询全部启用的 Resource
     */
    List<Resource> findEnabled();

    /**
     * 根据id获取资源信息
     */
    Resource get(final String id);

    /**
     * 新增 Resource
     */
    void add(final ResourceForm form);

    /**
     * 修改 Resource
     */
    int update(final ResourceForm form);

    /**
     * 根据id删除一个 Resource
     */
    int delete(final String id);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);

    /**
     * 检测数据是否可编辑
     */
    int checkEditable(final String id);
}