package com.bzdgs.dms.mapper;


import com.bzdgs.dms.domain.Menu;
import com.bzdgs.dms.query.MenuQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper extends BaseMapper<Menu>{

        List<Menu> findByUser(Long id);

    List<Menu> getMenuByUserId(Long id);

    Long couont();

    List<Menu> listByQuery(MenuQuery menuQuery);
}

