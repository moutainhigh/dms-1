package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: BeLost_
 * @Description: TODO
 * @Date: Create in 4:25 2019/12/6
 * @Version : v1.0
 */
@Getter
@Setter
public class Role {

    private Long id;
    //角色用户名
    private String sn;
    //角色名称
    private String name;

    private Long permission_id;
    private List<Permission> permissions=new ArrayList<>();

}
