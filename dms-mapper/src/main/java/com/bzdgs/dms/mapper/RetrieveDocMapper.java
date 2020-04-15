package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.RetrieveDoc;
import com.bzdgs.dms.query.RetrieveDocQuery;

import java.util.List;

public interface RetrieveDocMapper extends BaseMapper<RetrieveDoc> {
    long count(RetrieveDocQuery retrieveDocQuery);

    List<RetrieveDoc> selectByQuery(RetrieveDocQuery retrieveDocQuery);
}
