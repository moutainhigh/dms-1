package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.FaultDoc;
import com.bzdgs.dms.query.FaultDocQuery;

import java.util.List;

public interface FaultDocMapper extends BaseMapper<FaultDoc> {
    long count(FaultDocQuery faultDocQuery);

    List<FaultDoc> selectByQuery(FaultDocQuery faultDocQuery);
}
