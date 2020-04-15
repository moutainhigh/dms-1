package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.FaultDoc;
import com.bzdgs.dms.query.FaultDocQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FaultDocMapper extends BaseMapper<FaultDoc> {
    long count(FaultDocQuery faultDocQuery);

    List<FaultDoc> selectByQuery(FaultDocQuery faultDocQuery);
}
