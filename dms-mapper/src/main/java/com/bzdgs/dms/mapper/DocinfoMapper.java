package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.query.DocinfoQuery;

import java.util.List;

public interface DocinfoMapper extends BaseMapper<Docinfo> {
    /**
     * 查询事故档案
     * @return
     */
    List<Docinfo> list();

    /**
     * 查询丢失的档案
     * @return
     */
    List<Docinfo> missed();

    /**
     * 查询正常档案
     * @return
     */
    List<Docinfo> docs();

    long count(DocinfoQuery docinfoQuery);

    List<Docinfo> selectByQuery(DocinfoQuery docinfoQuery);

    List<Docinfo> selectAllByQuery(DocinfoQuery docinfoQuery);

    List<Docinfo> selectByDocsn(DocinfoQuery docinfoQuery);

    List<Docinfo> selectForExpired(DocinfoQuery docinfoQuery);

    List<Docinfo> selectForLucene();
}
