package com.zyyglxt.permissionsService;

import com.zyyglxt.dataobject.ResourcesRoleRefDO;
import com.zyyglxt.dataobject.ResourcesRoleRefDOKey;

/**
 * @Author wanglx
 * @Date 2020/10/29 0029 14:58
 * @Version 1.0
 */
public interface ResourcesRoleRefService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_role_ref
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    int deleteByPrimaryKey(ResourcesRoleRefDOKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_role_ref
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    int insertSelective(ResourcesRoleRefDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_role_ref
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    ResourcesRoleRefDO selectByPrimaryKey(ResourcesRoleRefDOKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_role_ref
     *
     * @mbg.generated Wed Oct 28 16:25:52 CST 2020
     */
    int updateByPrimaryKeySelective(ResourcesRoleRefDO record);

    /**
     * selectByResCode 查询角色权限关系
     * @param itemcode
     * @return
     */
    ResourcesRoleRefDO selectByResCode(String itemcode);
}
