package com.bzdgs.dms.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: BeLost_
 * @Description: 传给前台的分页对象
 * @Date: Create in 3:08 2019/12/6
 * @Version : v1.0
 */
public class UiPage {
        //装咱们当前页的数据
        private List rows = new ArrayList();
        //总条数
        private Long total;

    public UiPage(List<Menu> byLoginUser) {

    }

        /*ublic UiPage(Page page) {
            this.rows = page.getContent();
            this.total = page.getTotalElements();
        }
        */
}
