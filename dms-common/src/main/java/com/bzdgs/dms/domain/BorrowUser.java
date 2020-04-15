package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * (TBorrowuser)实体类
 *
 * @author Hoony96
 * @since 2019-12-03 20:43:45
 */

@Setter
@Getter
@NoArgsConstructor
public class BorrowUser{
    private Long id;
    // 借阅人姓名
    private String userName;
    //借阅表名
    private Long borrow_id;
    //借阅人联系方式
    private String tel;
    //证件号码
    private String idNumber;
    //证件类型
    private Long dicdetail_id;

    public BorrowUser(String userName, Long borrow_id, String tel, String idNumber, Long dicdetail_id) {
        this.userName = userName;
        this.borrow_id = borrow_id;
        this.tel = tel;
        this.idNumber = idNumber;
        this.dicdetail_id = dicdetail_id;
    }

}
