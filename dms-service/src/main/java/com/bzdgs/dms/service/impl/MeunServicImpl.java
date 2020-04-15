package com.bzdgs.dms.service.impl;

import com.bzdgs.dms.domain.Menu;
import com.bzdgs.dms.mapper.BaseMapper;
import com.bzdgs.dms.mapper.MenuMapper;
import com.bzdgs.dms.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: BeLost_
 * @Description: TODO
 * @Date: Create in 9:27 2019/12/5
 * @Version : v1.0
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class MeunServicImpl extends BaseServiceImpl<Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    protected BaseMapper<Menu> getMapper() {
        return menuMapper;
    }

    @Override
    public List<Menu> findByLoginUser() {
        return null;
    }

    @Override
    public List<Menu> getMenuByUserId(Long id) {
        return menuMapper.getMenuByUserId(id);
    }
}
