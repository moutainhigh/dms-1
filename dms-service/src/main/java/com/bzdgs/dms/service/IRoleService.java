package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.Role;
import com.bzdgs.dms.query.RoleQuery;
import com.bzdgs.dms.util.PageList;

public interface IRoleService extends IBaseService<Role> {
    PageList<Role> page(RoleQuery query);
}
