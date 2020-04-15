package com.bzdgs.dms.mapper;


import com.bzdgs.dms.domain.DicDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DicDetailMapper extends BaseMapper<DicDetail>{
    List<DicDetail> selectDeptById();

    List<DicDetail> selectUnitById();

    List<DicDetail> getFaults();
}
