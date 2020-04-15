package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.service.IBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @Description BaseServiceImpl
 * @Author liuqi
 * @Date
 * @Version v1.0
 **/
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    //所有的service类重写这个方法，就可以通过mapper获取到值
    protected abstract BaseMapper<T> getMapper();

    @Override
    public void insert(T t) {
        getMapper().insert(t);

    }

    @Override
    public void deleteById(Serializable id) {
        getMapper().deleteById(id);

    }

    @Override
    public void update(T t) {
        getMapper().update(t);

    }

    @Override
    public T selectById(Serializable id) {
        return getMapper().selectById(id);
    }

    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public void deleteBatch(String ids) {
        getMapper().deleteBatch(ids);
    }
}
