package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.Permission;
import com.bzdgs.dms.query.PermissionQuery;
import com.bzdgs.dms.util.PageList;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface IPermissionService extends IBaseService<Permission> {
    PageList<Permission> page(PermissionQuery query);

    Set<String> findPermissionsByEmployeeId(Serializable id);
}
