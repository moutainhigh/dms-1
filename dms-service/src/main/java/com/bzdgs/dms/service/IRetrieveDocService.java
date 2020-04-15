package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.RetrieveDoc;
import com.bzdgs.dms.query.RetrieveDocQuery;
import com.bzdgs.dms.util.PageList;

public interface IRetrieveDocService extends IBaseService<RetrieveDoc> {
    PageList<RetrieveDoc> page(RetrieveDocQuery retrieveDocQuery);
}
