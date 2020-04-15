package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.DestroyDoc;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.DestroyDocMapper;
import com.bzdgs.dms.query.DestroyDocQuery;
import com.bzdgs.dms.service.IDestroyDocService;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class DestroyDocServiceImpl extends BaseServiceImpl<DestroyDoc> implements IDestroyDocService {
    @Autowired
    private DestroyDocMapper destroyDocMapper;
    @Override
    protected BaseMapper<DestroyDoc> getMapper() {
        return destroyDocMapper;
    }

    @Override
    public void updateById(DestroyDoc destroyDoc) {
        destroyDocMapper.update(destroyDoc);
    }

    @Override
    public void removeById(Long id) {
        destroyDocMapper.deleteById(id);
    }

    @Override
    public PageList<DestroyDoc> page(DestroyDocQuery destroyDocQuery) {
        long total = destroyDocMapper.count(destroyDocQuery);
        List<DestroyDoc> rows = destroyDocMapper.selectByQuery(destroyDocQuery);
        return new PageList<>(total,rows);
    }
}
