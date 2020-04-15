package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: BeLost_
 * @Description: TODO
 * @Date: Create in 16:22 2019/12/5
 * @Version : v1.0
 */
@Getter
@Setter
public class Menu {
    private Long id;

    private String name;

    private String url;

    private String icon;

    private String component;

    private List<Menu> children = new ArrayList<>();
}
