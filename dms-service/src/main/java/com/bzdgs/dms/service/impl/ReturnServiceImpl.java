package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.Return;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.ReturnMapper;
import com.bzdgs.dms.service.IReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 21:20 2019/12/5
 * @Version : v1.0
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class ReturnServiceImpl extends BaseServiceImpl<Return> implements IReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    protected BaseMapper<Return> getMapper() {
        return this.returnMapper;
    }
}
