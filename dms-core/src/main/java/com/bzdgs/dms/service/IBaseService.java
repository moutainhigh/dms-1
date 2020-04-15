package com.bzdgs.dms.service;

import java.io.Serializable;
import java.util.List;

/**
 * @Description IBaseService
 * @Author liuqi
 * @Date
 * @Version v1.0
 **/
public interface IBaseService<T> {

    void insert(T t);
    void deleteById(Serializable id);
    void update(T t);
    T selectById(Serializable id);
    List<T> selectAll();
    void deleteBatch(String ids);
}
