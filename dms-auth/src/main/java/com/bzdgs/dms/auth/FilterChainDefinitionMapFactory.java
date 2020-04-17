package com.bzdgs.dms.auth;

import com.bzdgs.dms.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author YCWB0118
 */
public class FilterChainDefinitionMapFactory {
    @Autowired
    private IPermissionService permissionService;
    public Map<String,String> getMap(){
        LinkedHashMap<String,String> map=new LinkedHashMap<String, String>();
        map.put("/login","anon");
        map.put("/**", "myAuth");
        return map;
    }
}
