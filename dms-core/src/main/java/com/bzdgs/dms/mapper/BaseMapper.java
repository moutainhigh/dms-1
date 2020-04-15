package com.bzdgs.dms.mapper;

import java.io.Serializable;
import java.util.List;

/**
 *@Description BaseMapper
 * @Author liuqi
 * @param <T>
 */
public interface BaseMapper<T> {
    /**
     * 添加
     * @param t
     */
    void insert(T t);

    /**
     *
     * 通过id删除一个
     * * @param t
     */
    void deleteById(Serializable id);

    void updateById(Serializable id);

    /**
     * 通过id删除一个
     * * @param t
     */
    void update(T t);

    /**
     * 通过id查询一个
     * * @param t
     */
    T selectById(Serializable id);

    /**
     * 查询
     * * @param t
     */
    List<T> selectAll();

    void deleteBatch(String ids);
}
