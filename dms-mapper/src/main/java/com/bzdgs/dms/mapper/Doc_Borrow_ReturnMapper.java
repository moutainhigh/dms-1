package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.Doc_Borrow_Return;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface Doc_Borrow_ReturnMapper extends BaseMapper<Doc_Borrow_Return> {

    void updateMid(List<Doc_Borrow_Return> list);

    Long selectDBRId(Long docId);

    List<Long> selectDocId(Long borrowId);
}
