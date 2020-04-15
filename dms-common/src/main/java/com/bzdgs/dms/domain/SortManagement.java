package com.bzdgs.dms.domain;

import lombok.Data;

/**
 * @Author Wcy
 * 分类管理实体类
 */
@Data
public class SortManagement {
    //类型编号
    private Long id;
    //类型标识
    private String typeId;
    //类型名称
    private String typeName;
    //备注
    private String comment;
    //状态
    private int state;

}
