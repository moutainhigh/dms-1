package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: hoony96
 * @Description: 借阅归还查询实体类
 * @Date: Create in 19:43 2019/12/8
 * @Version : v1.0
 */
@Getter
@Setter
@ToString
public class Search {

    //  所有的档案信息
    private List<Docinfo> docs = new ArrayList<>();


//    // 借阅人
//    private String userName;
//    // 借阅状态
//    private Integer status;
//    // 借阅时间
//    private Date borrowTime;
//    // 归还时间
//    private Date returnTime;
    private List<Borrow> borrows = new ArrayList<>();

}
