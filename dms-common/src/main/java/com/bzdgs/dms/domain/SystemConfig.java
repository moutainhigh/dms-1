package com.bzdgs.dms.domain;

import lombok.Data;

/**
 * @Author Wcy
 * 系统配置实体类
 */
@Data
public class SystemConfig {

    //编号
    private Long id;
    //系统名称
    private String systemName;
    //公司名称
    private String companyName;
    //公司电话
    private String companyTel;
    //公司传真
    private String companyFax;
    //公司地址
    private String companyAddress;
    //公司网址
    private String companyURL;

}
