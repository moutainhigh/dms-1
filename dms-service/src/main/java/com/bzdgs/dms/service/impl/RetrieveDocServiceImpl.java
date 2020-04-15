package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.RetrieveDoc;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.RetrieveDocMapper;
import com.bzdgs.dms.query.RetrieveDocQuery;
import com.bzdgs.dms.service.IRetrieveDocService;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class RetrieveDocServiceImpl extends BaseServiceImpl<RetrieveDoc> implements IRetrieveDocService {
    @Autowired
    private RetrieveDocMapper retrieveDocMapper;
    @Override
    protected BaseMapper<RetrieveDoc> getMapper() {
        return retrieveDocMapper;
    }

    @Override
    public PageList<RetrieveDoc> page(RetrieveDocQuery retrieveDocQuery) {
        long total = retrieveDocMapper.count(retrieveDocQuery);
        List<RetrieveDoc> rows = retrieveDocMapper.selectByQuery(retrieveDocQuery);
        return new PageList<>(total,rows);
    }
}
