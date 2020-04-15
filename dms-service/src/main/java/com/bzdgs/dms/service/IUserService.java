package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.User;
import com.bzdgs.dms.query.UserQuery;
import com.bzdgs.dms.util.PageList;

public interface IUserService extends IBaseService<User> {

    User getByUsername(String username);

    PageList<User> page(UserQuery query);
}
