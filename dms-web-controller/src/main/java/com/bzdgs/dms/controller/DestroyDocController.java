package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.DestroyDoc;
import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.query.DestroyDocQuery;
import com.bzdgs.dms.service.IDestroyDocService;
import com.bzdgs.dms.service.IDocinfoService;
import com.bzdgs.dms.util.AjaxResult;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class DestroyDocController {
    @Autowired
    private IDestroyDocService destroyDocService;
    @Autowired
    private IDocinfoService docinfoService;
    @PostMapping("/destroyDoc/page")
    private PageList<DestroyDoc> list(@RequestBody DestroyDocQuery destroyDocQuery){
        return destroyDocService.page(destroyDocQuery);
    }
    //    @DeleteMapping("/destroyDoc/{id}")
//    public AjaxResult delete(@PathVariable("id") Long id){
//        try {
//            destroyDocService.removeById(id);
//            return AjaxResult.me().setMsg("删除成功！");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return AjaxResult.me().setSuccess(false).setMsg("删除失败！");
//    }
    @PostMapping("/destroyDoc")
    @Transactional
    public AjaxResult save(@RequestBody DestroyDoc destroyDoc){
        try {
            if (destroyDoc.getId()!=null){
                destroyDocService.updateById(destroyDoc);
            }else {
                destroyDoc.setDestroyDate(new Date());
                destroyDocService.insert(destroyDoc);
                Docinfo docinfo = docinfoService.selectById(destroyDoc.getDocInfo_id());
                docinfo.setStatus(-2);
                docinfoService.update(docinfo);
            }
            return AjaxResult.me().setMsg("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.me().setSuccess(false).setMsg("保存失败！");
    }
}
