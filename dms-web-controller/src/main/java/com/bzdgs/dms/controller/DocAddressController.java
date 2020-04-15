package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Docaddress;
import com.bzdgs.dms.service.IDocaddressService;
import com.bzdgs.dms.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 档案类型DoctypeController
 * @author 刘琪
 * @since
 */

@RestController
@RequestMapping("/docaddress")
public class DocAddressController {

    @Autowired
    private IDocaddressService docaddressService;

    @GetMapping("/list")
    public List<Docaddress> selectIDType(){
        return docaddressService.selectAll();
    }


    @DeleteMapping("/delete")
    public AjaxResult delete(Long id){
        try {
            docaddressService.deleteById(id);
            return AjaxResult.me().setMsg("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("删除失败！"+e.getMessage());
        }
    }




    @PostMapping("/update")
    public AjaxResult update(@RequestBody Docaddress docaddress){
        try {
            if(docaddress.getId()!=null){
                docaddressService.update(docaddress);
            }
            return AjaxResult.me().setMsg("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("修改失败！"+e.getMessage());
        }
    }




    @PostMapping("/insert")
    public AjaxResult insert(@RequestBody Docaddress docaddress){
        try {
            if(docaddress.getId()==null){
                docaddressService.insert(docaddress);
            }
            return AjaxResult.me().setMsg("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("添加失败！"+e.getMessage());
        }
    }



}
