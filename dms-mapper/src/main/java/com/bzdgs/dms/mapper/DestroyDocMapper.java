package com.bzdgs.dms.mapper;


import com.bzdgs.dms.domain.DestroyDoc;
import com.bzdgs.dms.query.DestroyDocQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DestroyDocMapper extends BaseMapper<DestroyDoc> {
    List<DestroyDoc> selectByQuery(DestroyDocQuery destroyDocQuery);

    long count(DestroyDocQuery destroyDocQuery);
}
