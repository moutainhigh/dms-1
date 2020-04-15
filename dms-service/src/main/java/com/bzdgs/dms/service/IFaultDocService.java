package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.FaultDoc;
import com.bzdgs.dms.query.FaultDocQuery;
import com.bzdgs.dms.util.PageList;

import java.util.List;

public interface IFaultDocService extends IBaseService<FaultDoc> {
    PageList<FaultDoc> page(FaultDocQuery faultDocQuery);

}
