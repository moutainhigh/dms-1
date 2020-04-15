package com.bzdgs.dms.controller;

import com.bzdgs.dms.domain.*;
import com.bzdgs.dms.query.BorrowQuery;
import com.bzdgs.dms.service.IBorrowService;
import com.bzdgs.dms.service.IBorrowUserService;
import com.bzdgs.dms.service.IDoc_Borrow_ReturnService;
import com.bzdgs.dms.service.IReturnService;
import com.bzdgs.dms.util.AjaxResult;
import com.bzdgs.dms.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 10:09 2019/12/4
 * @Version : v1.0
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private IBorrowService borrowService;
    @Autowired
    private IBorrowUserService borrowUserService;
    @Autowired
    private IReturnService returnService;
    @Autowired
    private IDoc_Borrow_ReturnService dbrService;


    /**
     *  根据 借阅人姓名查询 -- 有 就调用数据  没有 就直接把传过来的数据保存 ( 有可能多次借阅)
     *  有-- 身份证号 / 证件类型 / 联系方式 ==> 自动补充
     *  传入的 文件id == > 查询 获取文件名展示
     * @param borrowAdd
     * @return
     */
    @PostMapping("/addBorrow")
    public AjaxResult addBorrow(@RequestBody BorrowAdd borrowAdd){
        String[] idArr = borrowAdd.getIds().split(","); // 获取到所有的档案的id
        try {
            Doc_Borrow_Return dbr = new Doc_Borrow_Return();
            // 保存 借阅表信息  只保存一条信息
            Borrow borrow = new Borrow(borrowAdd.getUserName(),borrowAdd.getUser().getId(), borrowAdd.getDecs());
            borrow.setSn(borrowAdd.getSn());
            borrowService.insert(borrow);

            // 保存 借阅人
            Long borrowId = borrow.getId();
            BorrowUser borrowUser1 = new BorrowUser(borrowAdd.getUserName(),borrowId,borrowAdd.getTel(),borrowAdd.getIDNumber(),borrowAdd.getDicdetail_id());
            borrowUserService.insert(borrowUser1);

            // 保存中间表信息
            for (String str : idArr) {
                Long docinfoId = Long.valueOf(str);
                dbr.setDocId(docinfoId);
                dbr.setBorrowId(borrow.getId());
                dbrService.insert(dbr);
            }
            return AjaxResult.me().setMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("保存失败");
        }
    }

    @GetMapping("/selectAll")
    public PageList<Borrow> selectAll(){
        List<Borrow> borrows = borrowService.selectAll();
        return new PageList<>(borrows.size(),borrows);
    }


    @PostMapping("/pageBorrow")
    public PageList<Borrow> page(@RequestBody BorrowQuery borrowQuery){
        return borrowService.page(borrowQuery);
    }

    /**
     * 前端只能传入  借阅表的id  --  再去查询
     * @param br
     * @return
     */
    @PostMapping("/returnExcel")
    public AjaxResult returnExcel(@RequestBody Borrow_Return br){
        try {
            String[] docIds = br.getDocIds().split(",");
            // 数据库档案id个数
            List<Long> docIdFromDB = dbrService.selectDocId(br.getId());
            // 删除借阅表中的信息  传入档案id的个数 = 借阅表id查出来的个数
            if(docIdFromDB.size() == docIds.length){
                borrowService.deleteById(br.getId());
            }

            // 新增  归还表
            Return returnExcel = new Return();
            returnExcel.setDecs(br.getDecs());
            returnExcel.setSn(br.getSn());
            returnExcel.setOperationId(br.getOperationId());
            returnService.insert(returnExcel);

            List<Long> dbrIds = dbrService.selectIdByDocid(br.getDocIds());
            // 修改中间表的信息
            List<Doc_Borrow_Return> ids = new ArrayList<>();

            // 设置dbr 档案id
            for(int i=0,b=0;i<docIds.length;){
                Doc_Borrow_Return dbr = new Doc_Borrow_Return();
                dbr.setBorrowId(br.getId()); // 借阅表 id
                dbr.setReturnId(returnExcel.getId()); // 归还表 id
                dbr.setDocId(Long.valueOf(docIds[i++]));
                dbr.setId(dbrIds.get(b++));
                ids.add(dbr);
            }
            dbrService.updateMid(ids);

            return AjaxResult.me().setMsg("归还成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("归还失败,请重试");
        }
    }





}
