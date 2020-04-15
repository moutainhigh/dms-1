package com.bzdgs.dms.service;


import com.bzdgs.dms.domain.Doc_Borrow_Return;

import java.util.List;

public interface IDoc_Borrow_ReturnService extends IBaseService<Doc_Borrow_Return> {

    List<Long> selectIdByDocid(String ids);

    void updateMid(List<Doc_Borrow_Return> list);

    List<Long> selectDocId(Long borrowId);
}
