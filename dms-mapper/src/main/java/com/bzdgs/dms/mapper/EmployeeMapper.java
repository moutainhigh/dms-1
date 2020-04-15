package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.Employee;
import com.bzdgs.dms.query.EmployeeQuery;

import java.util.List;

/**
 * @Description desc
 * @Author lq
 * @Date new Date()
 * @Version v1.0
 **/

public interface EmployeeMapper extends BaseMapper<Employee> {

    List<Employee> findAll();

    long count(EmployeeQuery employeeQuery);

    List<Employee> selectByQuery(EmployeeQuery employeeQuery);


    void removeById(Long id);

    void updateById(Employee employee);
    void insert(Employee employee);
}
