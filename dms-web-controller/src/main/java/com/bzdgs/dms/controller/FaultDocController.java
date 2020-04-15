package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.domain.FaultDoc;
import com.bzdgs.dms.query.FaultDocQuery;
import com.bzdgs.dms.service.IDocinfoService;
import com.bzdgs.dms.service.IFaultDocService;
import com.bzdgs.dms.util.AjaxResult;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class FaultDocController {
    @Autowired
    private IFaultDocService faultDocService;
    @Autowired
    private IDocinfoService docinfoService;
    @PostMapping("/faultDoc/page")
    private PageList<FaultDoc> page(@RequestBody FaultDocQuery faultDocQuery){
        return faultDocService.page(faultDocQuery);
    }
    @PostMapping("/faultDoc")
    public AjaxResult save(@RequestBody FaultDoc faultDoc){
        try {
            if (faultDoc.getId()!=null){
                faultDocService.update(faultDoc);
            }else {
                faultDoc.setFaultDate(new Date());
                faultDocService.insert(faultDoc);
                Docinfo docinfo = docinfoService.selectById(faultDoc.getDocInfo_id());
                if (faultDoc.getDicDetail_id()==25){
                    docinfo.setStatus(-3);
                }else {
                    docinfo.setStatus(-4);
                }
                docinfoService.update(docinfo);
            }
            return AjaxResult.me().setMsg("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.me().setSuccess(false).setMsg("保存失败！");
    }
}
