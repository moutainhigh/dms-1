package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.domain.RetrieveDoc;
import com.bzdgs.dms.query.RetrieveDocQuery;
import com.bzdgs.dms.service.IDocinfoService;
import com.bzdgs.dms.service.IRetrieveDocService;
import com.bzdgs.dms.util.AjaxResult;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RetrieveDocController {
    @Autowired
    private IRetrieveDocService retrieveDocService;
    @Autowired
    private IDocinfoService docinfoService;
    @PostMapping("/retrieveDoc/page")
    private PageList<RetrieveDoc> page(@RequestBody RetrieveDocQuery retrieveDocQuery){
        return retrieveDocService.page(retrieveDocQuery);
    }
    @PostMapping("/retrieveDoc")
    public AjaxResult save(@RequestBody RetrieveDoc retrieveDoc){
        try {
            if (retrieveDoc.getId()!=null){
                retrieveDocService.update(retrieveDoc);
            }else {
                retrieveDoc.setRetrieveDate(new Date());
                retrieveDocService.insert(retrieveDoc);
                Docinfo docinfo = docinfoService.selectById(retrieveDoc.getDocInfo_id());
                docinfo.setStatus(-6);
                docinfoService.update(docinfo);
            }
            return AjaxResult.me().setMsg("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.me().setSuccess(false).setMsg("保存失败！");
    }
}
