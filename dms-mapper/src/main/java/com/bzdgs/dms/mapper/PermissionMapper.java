package com.bzdgs.dms.mapper;


import com.bzdgs.dms.domain.Permission;
import com.bzdgs.dms.query.PermissionQuery;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

     Long count(PermissionQuery query);

     List<Permission> selectByQuery(PermissionQuery query);
}
