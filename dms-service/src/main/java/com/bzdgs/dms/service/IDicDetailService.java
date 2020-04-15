package com.bzdgs.dms.service;


import com.bzdgs.dms.domain.DicDetail;

import java.util.List;

public interface IDicDetailService extends IBaseService<DicDetail>{
    List<DicDetail> selectDeptById();

    List<DicDetail> selectUnitById();

    List<DicDetail> getFaults();
}
