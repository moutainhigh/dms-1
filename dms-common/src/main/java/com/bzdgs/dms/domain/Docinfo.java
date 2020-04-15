package com.bzdgs.dms.domain;

/*import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;*/
import lombok.*;

import java.util.Date;

/**
 * @Description 档案信息实体类
 * @author 刘琪
 * @since 2019-12-04 09:22:33
 */
//ExcelTarget("docinfo")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Docinfo {

    //ID
    private Long id;

    //档案编号
    //@Excel(name = "档案编号")
    private String docSn;

    //档案类型,关联档案类型信息中的类型编号
    private Long docType_id;
    //@ExcelEntity
    private Doctype doctype;
    private String doctypeName;

    //档案存档点,关联存档点信息中的存档点编号
    private Long docAddress_id;
    private Docaddress docaddress;


    //档案标题
    //@Excel(name = "档案标题")
    private String docTitle;

    //建档用户,关联用户表中的用户编号
    private Long createUser_id;

    //建档日期
    //@Excel(name = "建档日期",format = "yyyy-MM-dd")
    private Date createDate = new Date();

    //修改用户
    private Long editUser_id;

    //修改日期
    private Date editDate;

    //借阅状态——数据字典（可借/不可借）
    private Integer borrowStatus_id;

    //过期时间
    private Date outDate;

    //过期是否提前通知,0不通知 1通知
    private Integer notice;

    //提前通知的天数
    private Integer noticeDay;

    //档案内容
    private String docContent;

    //内容简介
    private String contentIntro;

    //是否常用,0不常用 1常用
    private Integer isUsed;

    //文件编号
    private String docnum;

    //来文部门 ——数据字典
    private Long sendDept_id;

    //发文单位 ——数据字典
    private Long sendUnit_id;

    //发文人
    private String sendUser;

    //批准时间
    private Date piDate;

    //鉴定时间
    private Date jianDate;

    //产品批号
    private String productSn;

    //原料批号
    private String mateSn;

    //数量
    private Integer proNum;

    //页数
    private Integer pageCount;

    //专利号
    private String patentNum;

    //年检负责人
    private Long inspectUser_id;

    //状态，0代表在使用，-1代表已删除，-2已销毁，-3损坏，-4丢失,-5已过期
    //@Excel(name="状态",replace = {"在使用_0","已删除_-1","已销毁_-2","损坏_-3","丢失_-4","已过期_-5"})
    private Integer status;

    //图片路径和图片名称
    private String pic;

}
