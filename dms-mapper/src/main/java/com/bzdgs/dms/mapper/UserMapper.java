package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.User;
import com.bzdgs.dms.query.UserQuery;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User getByUsername(String username);

    long count(UserQuery query);

    List<User> selectByQuery(UserQuery query);

    void updatePassword(User user);
}
