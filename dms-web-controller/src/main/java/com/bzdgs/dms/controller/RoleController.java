package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Role;
import com.bzdgs.dms.query.RoleQuery;
import com.bzdgs.dms.service.IRoleService;
import com.bzdgs.dms.util.AjaxResult;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: BeLost_
 * @Description: TODO
 * @Date: Create in 3:50 2019/12/6
 * @Version : v1.0
 */
@RestController
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/role/page")
    public PageList<Role> page(@RequestBody RoleQuery query){
        return roleService.page(query);
    }

    @DeleteMapping("/role/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            roleService.deleteById(id);
            return AjaxResult.me().setMsg("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("删除失败!"+e.getMessage());
        }
    }

    @PostMapping("/role")
    public AjaxResult save(@RequestBody Role role){
        try {
            if(role.getId()!=null){
                //修改
                roleService.update(role);
            }else{
                //添加
                roleService.insert(role);
            }
            return AjaxResult.me().setMsg("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("保存失败!"+e.getMessage());
        }
    }

}

