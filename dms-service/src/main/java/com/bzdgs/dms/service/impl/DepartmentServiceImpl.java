package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.Department;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.DepartmentMapper;
import com.bzdgs.dms.service.IDepartmentService;
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
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    protected BaseMapper<Department> getMapper() {
        return this.departmentMapper;
    }
}
