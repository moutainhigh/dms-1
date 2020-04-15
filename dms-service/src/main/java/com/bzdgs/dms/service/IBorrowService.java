package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.Borrow;
import com.bzdgs.dms.query.BorrowQuery;
import com.bzdgs.dms.util.PageList;

/**
 * @Description desc
 * @Author lq
 * @Date new Date()
 * @Version v1.0
 **/

public interface IBorrowService extends IBaseService<Borrow> {

    PageList<Borrow> page(BorrowQuery borrowQuery);

    void deleteByIds(String ids);

}
