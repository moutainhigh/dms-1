package com.bzdgs.dms.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description BaseQuery
 * @Author liuqi
 * @Date
 * @Version v1.0
 **/

@Getter
@Setter
public class BaseQuery {
    //当前页
    private Integer pageNum = 1;
    //当前页条目数
    private Integer pageSize = 10;
    //关键字
    private String keyword;

    public int getStart(){
        return (pageNum-1)*pageSize;
    }

}
