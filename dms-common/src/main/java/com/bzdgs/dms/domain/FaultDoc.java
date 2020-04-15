package com.bzdgs.dms.domain;

import lombok.*;

import java.util.Date;

/**
 * 文档丢失损坏
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FaultDoc {
    private Long id;
    //文档编号
    private Long docInfo_id;
    //事故类型
    private Long dicDetail_id;
    //操作用户
    private Long user_id;
    //事故日期
    private Date faultDate;
    //备注
    private String des;

    private Docinfo docInfo;

    private User user;

    private DicDetail dicDetail;
}
