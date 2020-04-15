package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.Permission;
import com.bzdgs.dms.domain.Role;
import com.bzdgs.dms.query.RoleQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    Long count1(RoleQuery roleQuery);

    List<Role> selectByQuery(RoleQuery roleQuery);

    List<Permission> permissionsList(String id);
}
