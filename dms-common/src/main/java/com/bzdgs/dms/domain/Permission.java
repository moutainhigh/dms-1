package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: BeLost_
 * @Description: TODO
 * @Date: Create in 2:54 2019/12/6
 * @Version : v1.0
 */
@Setter
@Getter
public class Permission {

    //权限编号
    private Long id;
    //权限名称
    private String name;
    //资源路径编号
    private String url;
    //权限备注
    private String descs;
    //权限标识
    private String sn;
    //对应菜单
    private Long menu_id;
    //权限状态
    private Integer status;

    public Long getKey(){return this.id;}
    public String getLabel(){return this.name;}

}
