package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.DicDetail;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.DicDetailMapper;
import com.bzdgs.dms.service.IDicDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 15:09 2019/12/4
 * @Version : v1.0
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class DicDetailServiceImpl extends BaseServiceImpl<DicDetail> implements IDicDetailService {

    @Autowired
    private DicDetailMapper dicDetailMapper;

    @Override
    protected BaseMapper<DicDetail> getMapper() {
        return this.dicDetailMapper;
    }

    @Override
    public List<DicDetail> selectDeptById() {
        return dicDetailMapper.selectDeptById();
    }

    @Override
    public List<DicDetail> selectUnitById() {
        return dicDetailMapper.selectUnitById();
    }

    @Override
    public List<DicDetail> getFaults() {
        return dicDetailMapper.getFaults();
    }
}
