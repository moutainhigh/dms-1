package com.bzdgs.dms.mapper;


import com.bzdgs.dms.domain.DestroyDoc;
import com.bzdgs.dms.query.DestroyDocQuery;

import java.util.List;

public interface DestroyDocMapper extends BaseMapper<DestroyDoc> {
    List<DestroyDoc> selectByQuery(DestroyDocQuery destroyDocQuery);

    long count(DestroyDocQuery destroyDocQuery);
}
