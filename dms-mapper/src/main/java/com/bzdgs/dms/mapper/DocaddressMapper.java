package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.Docaddress;
import com.bzdgs.dms.query.DocAddressQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Liuqi
 * @Description: TODO
 * @Date: Create in 23:01 2019/12/5
 * @Version : v1.0
 */
@Mapper
public interface DocaddressMapper extends BaseMapper<Docaddress> {

    List<Docaddress> selectAllByQuery(DocAddressQuery addressQuery);
}
