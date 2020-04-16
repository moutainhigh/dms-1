package com.bzdgs.dms.mapper;


import com.bzdgs.dms.domain.Permission;
import com.bzdgs.dms.query.PermissionQuery;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

     Long count(PermissionQuery query);

     List<Permission> selectByQuery(PermissionQuery query);

     List<Permission> findPermissionsByEmployeeId(Serializable id);
}
