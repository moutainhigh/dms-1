package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * (TReturn)实体类
 *
 * @author Hoony96
 * @since 2019-12-03 20:45:59
 */
@Getter
@Setter
@NoArgsConstructor
public class Return{
    private Long id;

    // 编号
    private String sn;

    //备注
    private String decs;
    // 操作人
    private Long operationId;
//    private User user;
    //归还时间
    private Date returnTime2 = new Date();



}
