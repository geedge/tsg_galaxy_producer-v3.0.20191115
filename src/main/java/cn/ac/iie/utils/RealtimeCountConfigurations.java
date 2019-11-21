package cn.ac.iie.utils;

import java.util.Properties;

public class RealtimeCountConfigurations {
    private static Properties propCommon = new Properties();

    public static String getStringProperty(Integer type, String key) {
        if(type == 0){
            return propCommon.getProperty(key);
        } else {
            return null;
        }
    }

    public static Integer getIntProperty(Integer type, String key) {
        if(type == 0){
            return Integer.parseInt(propCommon.getProperty(key));
        } else {
            return null;
        }
    }

    public static Long getLongProperty(Integer type, String key) {
        if(type == 0){
            return Long.parseLong(propCommon.getProperty(key));
        } else {
            return null;
        }
    }

    public static Boolean getBooleanProperty(Integer type, String key) {
        if(type == 0){
            return propCommon.getProperty(key).toLowerCase().trim().equals("true");
        } else {
            return null;
        }
    }

    static {
        try {
            propCommon.load(RealtimeCountConfigurations.class.getClassLoader().getResourceAsStream("realtime_count_config.properties"));
            System.out.println("realtime_count_config.properties加载成功");
        } catch (Exception e) {
            propCommon = null;
            System.err.println("配置加载失败");
        }
    }
}
