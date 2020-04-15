package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.BorrowUser;

/**
 * @Description desc
 * @Author lq
 * @Date new Date()
 * @Version v1.0
 **/

public interface IBorrowUserService extends IBaseService<BorrowUser> {

    BorrowUser selectByName(String userName);

}
