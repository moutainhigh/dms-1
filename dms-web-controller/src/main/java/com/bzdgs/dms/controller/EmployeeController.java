package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Employee;
import com.bzdgs.dms.query.EmployeeQuery;
import com.bzdgs.dms.service.IEmployeeService;
import com.bzdgs.dms.util.AjaxResult;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description desc
 * @Author lq
 * @Date new Date()
 * @Version v1.0
 **/

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/employee/page")
    public PageList<Employee> list(@RequestBody EmployeeQuery employeeQuery){
        return employeeService.page(employeeQuery);
    }

    @DeleteMapping("/employee/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){

        try {
            employeeService.removeById(id);
            return AjaxResult.me().setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.me().setSuccess(false).setMsg("删除失败");

    }

    @PostMapping("/employee")
    public AjaxResult save(@RequestBody Employee employee){
        try {
            if(employee.getId()!=null){
                employeeService.updateById(employee);
            }else{
                employee.setPassword("123");
                employeeService.insert(employee);
            }
            return AjaxResult.me().setMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.me().setSuccess(false).setMsg("保存失败");

    }
}
