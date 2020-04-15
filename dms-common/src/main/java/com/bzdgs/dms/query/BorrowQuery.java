package com.bzdgs.dms.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 18:43 2019/12/5
 * @Version : v1.0
 */
@Setter
@Getter
@ToString
public class BorrowQuery extends BaseQuery {
    private String userName;

    private String sn;

    private String timeRange;

    private String expiredTime;

    private Long bid;

}
