package com.bzdgs.dms.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: hoony96
 * @Description: TODO
 * @Date: Create in 20:42 2019/12/14
 * @Version : v1.0
 */
public enum  LuceneUtil {

    INSTANCE;

    public String getIndexParent(){
        Properties properties = new Properties();
        InputStream resourceAsStream = LuceneUtil.class.getClassLoader().getResourceAsStream("lucene.properties");
        try {
            properties.load(resourceAsStream);
            String filePath = properties.getProperty("index.parent");
            // 创建对应的文件  用来装 全文检索的文件
            File file = new File(filePath);
            if(!file.exists()){
                file.mkdirs();
            }
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
