package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 9:52 2019/12/6
 * @Version : v1.0
 */
@Getter
@Setter
public class Borrow_Return {
    // 借阅表的 id
    private Long id;

    // 归还的备注
    private String decs;
    private Long operationId; // 操作人
    private String sn; // 归还编号

    // 档案的ids   通过多选框选择 传入id
    private String docIds;
}
