package com.bzdgs.dms.mapper;


import com.bzdgs.dms.domain.DicDetail;

import java.util.List;

public interface DicDetailMapper extends BaseMapper<DicDetail>{
    List<DicDetail> selectDeptById();

    List<DicDetail> selectUnitById();

    List<DicDetail> getFaults();
}
