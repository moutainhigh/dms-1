package com.bzdgs.dms.lucene;

import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.query.DocinfoQuery;
import com.bzdgs.dms.util.PageList;


import java.util.List;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 20:17 2019/12/14
 * @Version : v1.0
 */
public interface IDocinfoIndexHelper {

    void updateIndex(List<Docinfo> docs);


    PageList<Docinfo> searchIndex(DocinfoQuery query);


}
