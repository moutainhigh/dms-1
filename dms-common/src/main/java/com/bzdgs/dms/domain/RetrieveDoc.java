package com.bzdgs.dms.domain;

import lombok.*;

import java.util.Date;

/**
 * 文档找回
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RetrieveDoc {
    private Long id;
    //文档编号
    private Long docInfo_id;
    //操作用户
    private Long user_id;
    //找回日期
    private Date retrieveDate;
    //备注
    private String des;

    private Docinfo docInfo;

    private User user;
}
