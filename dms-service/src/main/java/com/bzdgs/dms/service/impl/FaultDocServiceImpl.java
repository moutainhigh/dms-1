package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.FaultDoc;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.FaultDocMapper;
import com.bzdgs.dms.query.FaultDocQuery;
import com.bzdgs.dms.service.IFaultDocService;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class FaultDocServiceImpl extends BaseServiceImpl<FaultDoc> implements IFaultDocService {
    @Autowired
    private FaultDocMapper faultDocMapper;
    @Override
    protected BaseMapper<FaultDoc> getMapper() {
        return faultDocMapper;
    }

    @Override
    public PageList<FaultDoc> page(FaultDocQuery faultDocQuery) {
        long total = faultDocMapper.count(faultDocQuery);
        List<FaultDoc> rows = faultDocMapper.selectByQuery(faultDocQuery);
        return new PageList<>(total,rows);
    }
}
