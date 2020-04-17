package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.Docaddress;
import com.bzdgs.dms.query.DocAddressQuery;

import java.util.List;

public interface IDocaddressService extends IBaseService<Docaddress> {
    List<Docaddress> selectAllByQuery(DocAddressQuery addressQuery);
}
