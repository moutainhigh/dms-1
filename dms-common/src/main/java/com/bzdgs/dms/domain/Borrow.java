package com.bzdgs.dms.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 20:37 2019/12/3
 * @Version : v1.0
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Borrow {
    private Long id;
    //借阅人姓名
    private String userName;
    // 操作人
    private Long operationId;
    //借阅时间
    private Date borrowTime = new Date();
    //归还时间
    private Date returnTime;
    //备注
    private String decs;
    //状态
    private Integer status=0;

    // 借阅编号
    private String sn;
    // 档案编号
    private List<Docinfo> docs = new ArrayList<>();

    // 判断 归还与否
    private Long returnId;

    public Borrow(String userName, Long operationId, String decs) {
        this.userName = userName;
        this.operationId = operationId;
        this.decs = decs;
        Long num = 1L;
        // 设置 归还日期为 借阅日期后的一个月
       Calendar cal = Calendar.getInstance();
        cal.setTime(this.borrowTime);
        cal.add(Calendar.MONTH,1);
        this.returnTime = cal.getTime();

    }
}
