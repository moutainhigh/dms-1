package com.bzdgs.dms.domain;

import lombok.*;

import java.util.Date;

/**
 * 文档销毁
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DestroyDoc {
    private Long id;
    //文档编号
    private Long docInfo_id;
    //操作用户
    private Long user_id;
    //销毁日期
    private Date destroyDate;
    //销毁原因
    private Long dicDetail_id;
    //备注
    private String des;

    private Docinfo docInfo;

    private DicDetail dicDetail;

    private User user;
}

