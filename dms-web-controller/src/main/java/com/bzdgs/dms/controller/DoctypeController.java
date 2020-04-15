package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Doctype;
import com.bzdgs.dms.service.IDoctypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 档案类型DoctypeController
 * @author 刘琪
 * @since
 */

@RestController
@RequestMapping("/doctype")
public class DoctypeController {

    @Autowired
    private IDoctypeService doctypeService;

    @GetMapping("/list")
    public List<Doctype> selectIDType(){
        return doctypeService.selectAll();
    }

}
