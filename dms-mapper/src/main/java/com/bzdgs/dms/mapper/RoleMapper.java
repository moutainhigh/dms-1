package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.Permission;
import com.bzdgs.dms.domain.Role;
import com.bzdgs.dms.query.RoleQuery;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    Long count1(RoleQuery roleQuery);

    List<Role> selectByQuery(RoleQuery roleQuery);

    List<Permission> permissionsList(String id);
}
