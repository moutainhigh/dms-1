package com.bzdgs.dms.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: Liuqi
 * @Description: TODO
 * @Date: Create in 16:17 2019/12/7
 * @Version : v1.0
 */
@Getter
@Setter
@ToString
public class DocinfoQuery extends BaseQuery {

    //档案类型
    private Long doctypeId;

    //状态
    private Integer status;

    //日期
    private Date beginTime;

    private Date endTime;

    private Date timeRange;

    private Date expiredTime;

}
