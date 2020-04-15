package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.Permission;
import com.bzdgs.dms.query.PermissionQuery;
import com.bzdgs.dms.util.PageList;

public interface IPermissionService extends IBaseService<Permission> {
    PageList<Permission> page(PermissionQuery query);
}
