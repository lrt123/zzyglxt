package com.zyyglxt.permissionsController;

import com.zyyglxt.dataobject.ResourcesRoleRefDO;
import com.zyyglxt.dataobject.RoleDO;
import com.zyyglxt.dataobject.RoleDOKey;
import com.zyyglxt.permissionsService.ResourcesRoleRefService;
import com.zyyglxt.permissionsService.ResourcesService;
import com.zyyglxt.permissionsService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wanglx
 * @Date 2020/10/29 0029 11:32
 * @Version 1.0
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    ResourcesRoleRefService resRoleRefService;
    @Autowired
    ResourcesService resService;

    /**
     * 添加角色
     * @param roleDO
     * @return 添加结果信息
     */
    @RequestMapping(value = "/insertrole", method = RequestMethod.POST)
    public void insertRoleSelective(@RequestBody RoleDO roleDO){
        //添加角色
        roleService.insertSelective(roleDO);
        //分配resources
        ResourcesRoleRefDO resourcesRoleRefDO = new ResourcesRoleRefDO();
        resourcesRoleRefDO.setRoleCode(roleDO.getItemcode());
        /*resService.selectByPrimaryKey()
        resourcesRoleRefDO.setResourceCode();*/
        resRoleRefService.insertSelective(resourcesRoleRefDO);
    }

    /**
     * 更新角色信息
     * @param roleDO
     * @return
     */
    @RequestMapping(value = "/updaterole", method = RequestMethod.PUT)
    public void updateRoleSelective(RoleDO roleDO){
        roleService.updateByPrimaryKeySelective(roleDO);

    }

    /**
     * 删除角色
     * @param key
     * @return
     */
    @RequestMapping(value = "/deleterole", method = RequestMethod.DELETE)
    public void deleteRoleByPrimaryKey(RoleDOKey key){
        roleService.deleteByPrimaryKey(key);
    }

    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping(value = "/allroles", method = RequestMethod.GET)
    public List<RoleDO> selectAllRoles(){
        List<RoleDO> roles = roleService.selectAllRole();
        return roles;
    }
}