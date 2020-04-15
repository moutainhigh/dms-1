package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.BorrowUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorrowUserMapper extends BaseMapper<BorrowUser> {

    BorrowUser selectByName(String userName);

}
