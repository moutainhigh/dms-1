package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.BorrowUser;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.BorrowUserMapper;
import com.bzdgs.dms.service.IBorrowUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 9:37 2019/12/4
 * @Version : v1.0
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class BorrowUserServiceImpl extends BaseServiceImpl<BorrowUser> implements IBorrowUserService {

    @Autowired
    private BorrowUserMapper borrowUserMapper;

    @Override
    protected BaseMapper<BorrowUser> getMapper() {
        return this.borrowUserMapper;
    }

    @Override
    public BorrowUser selectByName(String userName) {
        return borrowUserMapper.selectByName(userName);
    }
}
