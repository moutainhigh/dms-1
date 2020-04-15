package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.query.DocinfoQuery;
import com.bzdgs.dms.service.IDocinfoService;
import com.bzdgs.dms.util.AjaxResult;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 21:21 2019/12/14
 * @Version : v1.0
 */
@RestController
@RequestMapping("/lucene")
public class LuceneController {

    @Autowired
    private IDocinfoService docinfoService;


    @GetMapping("/update")
    public AjaxResult update(){
        try {
            docinfoService.updateIndex();
            return AjaxResult.me().setMsg("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("抱歉，更新失败，请重试");
        }
    }

    @PostMapping("/searchIndex")
    public PageList<Docinfo> search(@RequestBody DocinfoQuery docinfoQuery){
          return  docinfoService.searchIndex(docinfoQuery);

    }



}
