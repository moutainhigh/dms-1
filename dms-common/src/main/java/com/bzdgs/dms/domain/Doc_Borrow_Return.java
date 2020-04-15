package com.bzdgs.dms.domain;

import lombok.*;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 15:53 2019/12/6
 * @Version : v1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Doc_Borrow_Return {

    private Long id;
    private Long docId;
    private Long borrowId;
    private Long returnId;



}
