package com.bzdgs.dms.controller;

import com.bzdgs.dms.service.IBorrowUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 15:05 2019/12/4
 * @Version : v1.0
 */
@RestController
public class BorrowUserController {
    @Autowired
    private IBorrowUserService borrowUserService;




}
