package com.bzdgs.dms.auth;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author YCWB0118
 */
public class FilterChainDefinitionMapFactory {
    public Map<String,String> getMap(){
        LinkedHashMap<String,String> map=new LinkedHashMap<String, String>();
        map.put("/login","anon");
        map.put("/**", "authc");
        return map;
    }
}
