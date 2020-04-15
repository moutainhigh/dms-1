package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: Liuqi
 * @Description: TODO
 * @Date: Create in 22:56 2019/12/5
 * @Version : v1.0
 * 存档点实体类
 */
@Getter
@Setter
@ToString
public class Docaddress {
    //存档点编号
    private Long id;
    //存档点地址
    private String address;
    //存档点名称
    private String name;
    //备注
    private String decs;
    //联系人
    private String contact;
    //联系电话
    private String tel;
    //传真
    private String fax;
    //状态
    private int state;

}
