package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author Wcy
 * 部门管理实体类
 */
@Getter
@Setter
@ToString
public class Department {

    private Long id;
    //部门编号
    private String sn;
    //部门名称
    private String name;
    //联系电话
    private String phoneNum;
    //传真
    private String fax;
    //部门路径
    private String departmentPath;
    //上级部门？
    private Long parent_id;
    private Department parent;
    //部门主管
    private Long manager_id;
    private User manager;
    //备注
    private String comment;
    //状态
    private int state;

}
