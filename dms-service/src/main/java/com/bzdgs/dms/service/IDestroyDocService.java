package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.DestroyDoc;
import com.bzdgs.dms.query.DestroyDocQuery;
import com.bzdgs.dms.util.PageList;

public interface IDestroyDocService extends IBaseService<DestroyDoc> {
    void updateById(DestroyDoc destroyDoc);

    void removeById(Long id);

    PageList<DestroyDoc> page(DestroyDocQuery destroyDocQuery);
}
