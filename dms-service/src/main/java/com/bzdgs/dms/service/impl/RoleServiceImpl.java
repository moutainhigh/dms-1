package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.Role;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.RoleMapper;
import com.bzdgs.dms.query.RoleQuery;
import com.bzdgs.dms.service.IRoleService;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: BeLost_
 * @Description: TODO
 * @Date: Create in 4:29 2019/12/6
 * @Version : v1.0
 */
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
//    @Autowired
//    private PermissionMapper permissionMapper;
    @Override
    protected BaseMapper<Role> getMapper() {
        return roleMapper;
    }

    @Override
    public PageList<Role> page(RoleQuery roleQuery) {

        //查总数
        Long total=roleMapper.count1(roleQuery);
        //查分页
        List<Role> rows =roleMapper.selectByQuery(roleQuery);
        return new PageList<>(total,rows);
    }

//    /**
//     * 重写 新增方法
//     * @param role
//     */
//    @Override
//    @Transactional
//    public void add(Role role) {
//        //添加 角色表，返回 角色 id 将 tenant_id 也要添加进去
//        roleMapper.insert(role);
//        //添加角色权限中间表
//        String[] permissionIds=role.getPermissionIds().split(",");
//        Long[] permissions=new Long[permissionIds.length];
//        for (int i = 0; i < permissionIds.length; i++) {
//            permissions[i]=Long.valueOf(permissionIds[i]);
//        }
//        permissionMapper.addBatch(role.getId(),permissions);
//    }
//
//    /**
//     * 重写修改方法 采用 先删在 添加
//     * @param role
//     */
//    @Override
//    @Transactional
//    public void updateById(Role role) {
//        roleMapper.updateById(role);
//        String[] permissionIds=role.getPermissionIds().split(",");
//        Long[] permissions=new Long[permissionIds.length];
//        for (int i = 0; i < permissionIds.length; i++) {
//            permissions[i]=Long.valueOf(permissionIds[i]);
//        }
//        //删除
//        permissionMapper.deleteByRoleId(role.getId());
//        //增加
//        permissionMapper.addBatch(role.getId(),permissions);
//    }
}
