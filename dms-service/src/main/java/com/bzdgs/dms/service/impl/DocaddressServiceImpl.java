package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.Docaddress;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.DocaddressMapper;
import com.bzdgs.dms.service.IDocaddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Liuqi
 * @Description: TODO
 * @Date: Create in 22:59 2019/12/5
 * @Version : v1.0
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class DocaddressServiceImpl extends BaseServiceImpl<Docaddress> implements IDocaddressService {

    @Autowired
    private DocaddressMapper docaddressMapper;

    @Override
    protected BaseMapper<Docaddress> getMapper() {
        return docaddressMapper;
    }
}
