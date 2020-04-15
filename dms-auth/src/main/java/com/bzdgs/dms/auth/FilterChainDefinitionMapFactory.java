package com.bzdgs.dms.auth;

import java.util.LinkedHashMap;
import java.util.Map;


public class FilterChainDefinitionMapFactory {
    public Map<String,String> getMap(){
        LinkedHashMap<String,String> map=new LinkedHashMap<String, String>();
        map.put("/login","anon");
        map.put("/**", "myAuthc");
        return map;
    }
}
