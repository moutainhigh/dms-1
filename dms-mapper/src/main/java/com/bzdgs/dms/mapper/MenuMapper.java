package com.bzdgs.dms.mapper;


import com.bzdgs.dms.domain.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu>{

        List<Menu> findByUser(Long id);

    List<Menu> getMenuByUserId(Long id);
}

