package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.RetrieveDoc;
import com.bzdgs.dms.query.RetrieveDocQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RetrieveDocMapper extends BaseMapper<RetrieveDoc> {
    long count(RetrieveDocQuery retrieveDocQuery);

    List<RetrieveDoc> selectByQuery(RetrieveDocQuery retrieveDocQuery);
}
