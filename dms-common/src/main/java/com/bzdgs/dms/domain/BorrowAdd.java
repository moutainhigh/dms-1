package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 21:27 2019/12/3
 * @Version : v1.0
 */
@Getter
@Setter
public class BorrowAdd {


    //借阅人姓名
    private String userName;
    // 操作人
    private Long operationId;
    //备注
    private String decs;
    //状态
    private Integer status;

    //借阅人联系方式
    private String tel;
    //证件号码
    private String IDNumber;
    //证件类型
    private Long dicdetail_id;

    //  登录用户
    private User user;

    // 档案id
    private String ids;

    // 借阅编号
    private String sn;

}
