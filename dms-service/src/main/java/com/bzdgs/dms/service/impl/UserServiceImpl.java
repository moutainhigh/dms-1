package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.User;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.UserMapper;
import com.bzdgs.dms.query.UserQuery;
import com.bzdgs.dms.service.IUserService;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description desc
 * @Author lq
 * @Date new Date()
 * @Version v1.0
 **/

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public PageList<User> page(UserQuery query) {
        long total = userMapper.count(query);

        List<User> rows = userMapper.selectByQuery(query); //封装PageList返回

        return new PageList<>(total,rows);
    }
}
