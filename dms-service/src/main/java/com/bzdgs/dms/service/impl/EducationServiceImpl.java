package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.Education;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.EducationMapper;
import com.bzdgs.dms.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 9:35 2019/12/4
 * @Version : v1.0
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class EducationServiceImpl extends BaseServiceImpl<Education> implements IEducationService {

    @Autowired
    private EducationMapper educationMapper;

    @Override
    protected BaseMapper<Education> getMapper() {
        return this.educationMapper;
    }
}
