package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Department;
import com.bzdgs.dms.service.IDepartmentService;
import com.bzdgs.dms.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Wcy
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    //查询所有部门
    @PostMapping("/list")
    public List<Department> list(){
      return  departmentService.selectAll();
    }


    //删除部门
    @DeleteMapping("/delete")
    public AjaxResult delete(Long id){
        try {
            departmentService.deleteById(id);
            return AjaxResult.me().setMsg("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("删除失败！"+e.getMessage());
        }
    }


    //修改部门
    @PostMapping("/update")
    public AjaxResult update(@RequestBody Department department){
        try {

            if(department.getId()!=null){
                departmentService.update(department);
            }
            return AjaxResult.me().setMsg("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("修改失败！"+e.getMessage());
        }
    }


    //添加部门
    @PostMapping("/insert")
    public AjaxResult insert(@RequestBody Department department){
        try {
            if(department.getId()==null){
                departmentService.insert(department);
            }
            return AjaxResult.me().setMsg("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("添加失败！"+e.getMessage());
        }
    }



}
