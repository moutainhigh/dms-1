package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.DicDetail;
import com.bzdgs.dms.service.IDicDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 15:07 2019/12/4
 * @Version : v1.0
 */
@RestController
public class DicDetailController {
    @Autowired
    private IDicDetailService dicDetailService;

    @PostMapping("/dicdetail/IDType")
    public List<DicDetail> selectIDType(){
        return dicDetailService.selectAll();
    }

    @GetMapping("/dicdetail/dept")
    public List<DicDetail> selectDeptById(){
        return dicDetailService.selectDeptById();
    }

    @GetMapping("/dicdetail/unit")
    public List<DicDetail> selectUnitById(){
        return dicDetailService.selectUnitById();
    }

    @GetMapping("/dicdetail/fault")
    public List<DicDetail> getFaults(){
        return dicDetailService.getFaults();
    }




}
