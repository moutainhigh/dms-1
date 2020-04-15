package com.bzdgs.dms.domain;

//import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.*;

/**
 * @Author: Liuqi
 * @Description: 档案类型
 * @Date: Create in 19:48 2019/12/5
 * @Version : v1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Doctype  {

    private Long id;

    private String name;
    private String sn;
    private String desc;
}
