package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.Borrow;
import com.bzdgs.dms.query.BorrowQuery;
import com.bzdgs.dms.util.PageList;

public interface ISearchService {
    PageList<Borrow> searchAll(BorrowQuery borrowQuery);

    PageList<Borrow> searchForTime(BorrowQuery borrowQuery);

    PageList<Borrow> selectForExpired(BorrowQuery borrowQuery);
}
