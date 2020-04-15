package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Permission;
import com.bzdgs.dms.query.PermissionQuery;
import com.bzdgs.dms.service.IPermissionService;
import com.bzdgs.dms.util.AjaxResult;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: BeLost_
 * @Description: TODO
 * @Date: Create in 3:17 2019/12/6
 * @Version : v1.0
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @PostMapping("/page")
    public PageList<Permission> page(@RequestBody PermissionQuery query){
        return permissionService.page(query);
    }

    @GetMapping("/list")
    public List<Permission> selectAll(){
        return permissionService.selectAll();
    }

    @PostMapping("/save")
    public AjaxResult save(@RequestBody Permission permission){
        try {
            if (permission.getId()!=null) {
                permissionService.update(permission);
            }else {
                permissionService.insert(permission);
            }
            return AjaxResult.me().setMsg("保存成功！！！！！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("保存失败！！！"+e.getMessage());
        }
    }

    @PostMapping("/delete")
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            permissionService.deleteById(id);
            return AjaxResult.me().setMsg("删除成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("删除失败！！！！");
        }
    }
}
