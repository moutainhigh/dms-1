package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.Employee;
import com.bzdgs.dms.query.EmployeeQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    List<Employee> findAll();

    long count(EmployeeQuery employeeQuery);

    List<Employee> selectByQuery(EmployeeQuery employeeQuery);


    void removeById(Long id);

    void updateById(Employee employee);
    void insert(Employee employee);
}
