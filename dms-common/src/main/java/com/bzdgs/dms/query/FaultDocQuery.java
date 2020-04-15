package com.bzdgs.dms.query;


import java.util.Date;

public class FaultDocQuery extends BaseQuery {
    private Date startDate;
    private Date endDate;
    private Long dicDetail_id;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getDicDetail_id() {
        return dicDetail_id;
    }

    public void setDicDetail_id(Long dicDetail_id) {
        this.dicDetail_id = dicDetail_id;
    }
}
