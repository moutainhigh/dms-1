package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.Doc_Borrow_Return;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.Doc_Borrow_ReturnMapper;
import com.bzdgs.dms.service.IDoc_Borrow_ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 16:14 2019/12/6
 * @Version : v1.0
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class Doc_Borrow_ReturnServiceImpl extends BaseServiceImpl<Doc_Borrow_Return> implements IDoc_Borrow_ReturnService {

    @Autowired
    private Doc_Borrow_ReturnMapper docBorrowReturnMapper;

    @Override
    protected BaseMapper<Doc_Borrow_Return> getMapper() {
        return this.docBorrowReturnMapper;
    }

    @Override
    public List<Long> selectIdByDocid(String ids) {
        String[] split = ids.split(",");
        List<Long> list = new ArrayList<>();
        for (String s : split) {
            Long id = Long.valueOf(s);
            Long dbrId = docBorrowReturnMapper.selectDBRId(id);
            list.add(dbrId);
        }
        return list;
    }

    @Override
    public void updateMid(List<Doc_Borrow_Return> list) {
        docBorrowReturnMapper.updateMid(list);
    }

    @Override
    public List<Long> selectDocId(Long borrowId) {
        return docBorrowReturnMapper.selectDocId(borrowId);
    }
}
