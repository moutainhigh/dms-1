package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.BorrowUser;

public interface BorrowUserMapper extends BaseMapper<BorrowUser> {

    BorrowUser selectByName(String userName);

}
