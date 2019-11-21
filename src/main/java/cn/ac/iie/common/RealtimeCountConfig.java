package cn.ac.iie.common;

import cn.ac.iie.utils.RealtimeCountConfigurations;

import java.io.Serializable;

public class RealtimeCountConfig implements Serializable {
    private static final long serialVersionUID = 1641809911536544588L;

    public static final String BOOTSTRAP_SERVERS = RealtimeCountConfigurations.getStringProperty(0, "bootstrap.servers");
    public static final String CUSTOM_COMPRESSION_TYPE = RealtimeCountConfigurations.getStringProperty(0, "custom.compression.type");

    public static final String KAFKA_RRL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.rrl.topic");
    public static final String KAFKA_SEL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.sel.topic");
    public static final String KAFKA_PEL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.pel.topic");
    public static final String KAFKA_CRL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.crl.topic");

    public static final Integer SPEED_NUM = RealtimeCountConfigurations.getIntProperty(0, "speed.num");
    public static final Integer SLEEP_NUM = RealtimeCountConfigurations.getIntProperty(0, "sleep.num");
    public static final Integer INSERT_NUM = RealtimeCountConfigurations.getIntProperty(0, "insert.num");
    public static final String AUTO_OFFSET_RESET = RealtimeCountConfigurations.getStringProperty(0, "auto.offset.reset");

    public static final String COMMON_POLICY_ID = RealtimeCountConfigurations.getStringProperty(0, "common.policy.id");
    public static final String IPV4_DATAS= RealtimeCountConfigurations.getStringProperty(0, "IPV4Datas");
    public static final String IPV6_DATAS= RealtimeCountConfigurations.getStringProperty(0, "IPV6Datas");
    public static final String URL_DATAS= RealtimeCountConfigurations.getStringProperty(0, "urlDatas");
}
