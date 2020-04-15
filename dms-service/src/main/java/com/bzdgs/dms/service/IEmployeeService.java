package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.Employee;
import com.bzdgs.dms.query.EmployeeQuery;
import com.bzdgs.dms.util.PageList;

import java.util.List;

/**
 * @Description desc
 * @Author lq
 * @Date new Date()
 * @Version v1.0
 **/

public interface IEmployeeService extends IBaseService<Employee> {

    List<Employee> findAll();

    PageList<Employee> page(EmployeeQuery employeeQuery);

    void removeById(Long id);

    void updateById(Employee employee);

    void insert(Employee employee);
}
