package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.SystemConfig;
import com.bzdgs.dms.service.ISystemConfigService;
import com.bzdgs.dms.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Wcy
 */
@RestController
@RequestMapping("/systemConfig")
public class SystemConfigController {

    @Autowired
    private ISystemConfigService systemConfigService;

    //查询所有部门
    @PostMapping("/list")
    public List<SystemConfig> list(){
      return  systemConfigService.selectAll();
    }


    //删除部门
    @DeleteMapping("/delete")
    public AjaxResult delete(Long id){
        try {
            systemConfigService.deleteById(id);
            return AjaxResult.me().setMsg("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("删除失败！"+e.getMessage());
        }
    }


    //修改部门
    @PostMapping("/update")
    public AjaxResult update(@RequestBody SystemConfig SystemConfig){
        try {

            if(SystemConfig.getId()!=null){
                systemConfigService.update(SystemConfig);
            }
            return AjaxResult.me().setMsg("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("修改失败！"+e.getMessage());
        }
    }


    //添加部门
    @PostMapping("/insert")
    public AjaxResult insert(@RequestBody SystemConfig SystemConfig){
        try {
            if(SystemConfig.getId()==null){
                systemConfigService.insert(SystemConfig);
            }
            return AjaxResult.me().setMsg("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("添加失败！"+e.getMessage());
        }
    }



}
