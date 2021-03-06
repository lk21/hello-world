package com.lk.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;


import org.slf4j.LoggerFactory;

public class PropsUtil {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);
    /*
     * 加载属性文件
     */
    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream iStream = null;
        try {
            iStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(iStream == null) {
                throw new FileNotFoundException(fileName + "file is not found");
            }
            props = new Properties();
            props.load(iStream);
        } catch (IOException e) {
            LOGGER.error("load properties file failure", e);
        } finally {
            if(iStream != null) {
                try {
                    iStream.close();
                } catch(IOException e) {
                    LOGGER.error("close input stream failure",e);
                }
            }
        }
        return props;
    }
    
    /*
     * 获取字符型属性（默认值位空字符串）
     */
    public static String getString(Properties properties, String key) {
        return getString(properties, key, "");
    }
    
    /*
     * 获取字符型属性（可指定默认值）
     */
    public static String getString(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if(properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }
    
    public static int getInt(Properties properties, String key) {
        return getInt(properties, key, 0);
    }
    
    /*
     * 获取数值型属性（可制定默认值）
     */
    public static int getInt(Properties properties, String key, int defaultValue) {
        int value = defaultValue;
        if(properties.containsKey(key)) {
            value = CastUtil.castInt(properties.getProperty(key));
        }
        return value;
    }
    /*
     * 获取布尔型属性（默认值false）
     */
    public static Boolean getBoolean(Properties properties, String key) {
        return getBoolean(properties, key, false);
    }
    /*
     * 获取布尔型属性（可制定默认值）
     */
    public static Boolean getBoolean(Properties properties, String key, Boolean defaultValue) {
        Boolean value = defaultValue;
        if(properties.containsKey(key)) {
            value = CastUtil.castBoolean(properties.getProperty(key));
        }
        return value;
    }

}
