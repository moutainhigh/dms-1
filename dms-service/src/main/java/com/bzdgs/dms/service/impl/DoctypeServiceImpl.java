package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.Doctype;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.DoctypeMapper;
import com.bzdgs.dms.service.IDoctypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Liuqi
 * @Description: TODO
 * @Date: Create in 19:52 2019/12/5
 * @Version : v1.0
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class DoctypeServiceImpl extends BaseServiceImpl<Doctype> implements IDoctypeService {

    @Autowired
    private DoctypeMapper doctypeMapper;

    @Override
    protected BaseMapper<Doctype> getMapper() {
        return doctypeMapper;
    }
}
