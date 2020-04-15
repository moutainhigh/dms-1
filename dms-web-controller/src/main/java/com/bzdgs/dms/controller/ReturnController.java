package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.Return;
import com.bzdgs.dms.service.IReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 21:16 2019/12/5
 * @Version : v1.0
 */
@RestController
@RequestMapping("/return")
public class ReturnController {

    @Autowired
    private IReturnService returnService;

    @PostMapping("/save")
    public void saveReturn(@RequestBody Return returnExcel){
        try {
            returnService.insert(returnExcel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
