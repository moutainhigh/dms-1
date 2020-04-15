package com.bzdgs.dms.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description desc
 * @Author lq
 * @Date new Date()
 * @Version v1.0
 **/

@Getter
@Setter
@ToString
public class Employee {

    private Long id;

    private String  username;

    private String password;

    private String email;

    private String headImage;

    private Integer age;

    private Long department_id;

    private Department department;
}
