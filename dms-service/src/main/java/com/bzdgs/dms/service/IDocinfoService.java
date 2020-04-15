package com.bzdgs.dms.service;

import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.query.DocinfoQuery;
import com.bzdgs.dms.util.PageList;

import java.util.List;

/**
 * @Description 档案信息Service
 * @author 刘琪
 */
public interface IDocinfoService extends IBaseService<Docinfo> {
    List<Docinfo> list();
    List<Docinfo> docs();
    List<Docinfo> missed();
    PageList<Docinfo> page(DocinfoQuery docinfoQuery);
    List<Docinfo> selectAllByQuery(DocinfoQuery docinfoQuery);

    PageList<Docinfo> selectByDocsn(DocinfoQuery docinfoQuery);
    PageList<Docinfo> selectForExpired(DocinfoQuery docinfoQuery);

    void updateIndex();

    PageList<Docinfo> searchIndex(DocinfoQuery docinfoQuery);
}
