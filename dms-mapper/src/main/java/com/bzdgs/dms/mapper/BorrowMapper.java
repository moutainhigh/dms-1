package com.bzdgs.dms.mapper;

import com.bzdgs.dms.domain.Borrow;
import com.bzdgs.dms.domain.Docinfo;
import com.bzdgs.dms.query.BorrowQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BorrowMapper extends BaseMapper<Borrow> {

    /**
     *  借阅查询的  sql语句
     * @param borrowQuery
     * @return
     */
    List<Borrow> selectPage(BorrowQuery borrowQuery);
    Long selectCount(BorrowQuery borrowQuery);

    /**
     * 借阅归还查询 的 sql语句
     * @param borrowQuery
     * @return
     */
    List<Borrow> selectForSearch(BorrowQuery borrowQuery);
    Long selectSearchCount(BorrowQuery borrowQuery);

    /**
     * 到期查询的  sql语句
     * @param borrowQuery
     * @return
     */
    List<Borrow> selectForExpired(BorrowQuery borrowQuery);
    Long selectForExpiredCount(BorrowQuery borrowQuery);

    /**
     * 根据sn查询 借阅id
     * @param sn
     * @return
     */
    Long selectBid(String sn);

    Docinfo selectDoc(String id);
}
