package cn.ac.iie.producer;

import cn.ac.iie.bean.tsg_log.CONNECTION_RECORD_LOG;
import cn.ac.iie.bean.tsg_log.PROXY_EVENT_LOG;
import cn.ac.iie.bean.tsg_log.RADIUS_RECORD_LOG;
import cn.ac.iie.bean.tsg_log.SECURITY_EVENT_LOG;
import cn.ac.iie.common.RealtimeCountConfig;
import cn.ac.iie.utils.GetLogData;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

import java.util.Properties;

public class TSGProducer {
    private static final Logger logger = Logger.getLogger(TSGProducer.class);
    public static void main(String[] args) {
        Properties props = new Properties();
        //kafka地址
        props.put("bootstrap.servers", RealtimeCountConfig.BOOTSTRAP_SERVERS);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 67108864);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

//        props.put("batch.size",102400);//批量提交字节
//        props.put("request.timeout.ms", 15000);
//        props.put("producer.type", "sync");
//        props.put("batch.num.messages", 50000);
//        props.put("acks", "0");
//        props.put("compression.type", RealtimeCountConfig.CUSTOM_COMPRESSION_TYPE);//测试压缩用20190710

        //创建KafkaProducer
        KafkaProducer<String, Object> kafkaProducer = new KafkaProducer<String, Object>(props);

        Long commonId=0l;
        int messageid=0;
        Long bbb = 0L;
        while (true) {
            commonId++;
            messageid++;
            try {
                RADIUS_RECORD_LOG radius_record_log = GetLogData.getRadiusRecordLog(commonId);
                PROXY_EVENT_LOG proxy_event_log = GetLogData.getProxyEventLog(commonId);
                SECURITY_EVENT_LOG security_event_log = GetLogData.getSecurityEventLog(messageid,commonId);
                CONNECTION_RECORD_LOG connection_record_log = GetLogData.getConnectionRecordLog(messageid,commonId);

                if (!(RealtimeCountConfig.KAFKA_RRL_TOPIC.equals("no"))) {
                    kafkaProducer.send(new ProducerRecord<String, Object>(RealtimeCountConfig.KAFKA_RRL_TOPIC, JSONObject.toJSONString(radius_record_log)));
                }
                if (!(RealtimeCountConfig.KAFKA_SEL_TOPIC.equals("no"))) {
                    kafkaProducer.send(new ProducerRecord<String, Object>(RealtimeCountConfig.KAFKA_SEL_TOPIC, JSONObject.toJSONString(security_event_log)));
                }
                if (!(RealtimeCountConfig.KAFKA_PEL_TOPIC.equals("no"))) {
                    kafkaProducer.send(new ProducerRecord<String, Object>(RealtimeCountConfig.KAFKA_PEL_TOPIC, JSONObject.toJSONString(proxy_event_log)));
                }
                if (!(RealtimeCountConfig.KAFKA_CRL_TOPIC.equals("no"))) {
                    kafkaProducer.send(new ProducerRecord<String, Object>(RealtimeCountConfig.KAFKA_CRL_TOPIC, JSONObject.toJSONString(connection_record_log)));
                }

                bbb++;
                //控制速度
                if (bbb % RealtimeCountConfig.SPEED_NUM == 0) {
                    Thread.sleep(RealtimeCountConfig.SLEEP_NUM);
                }
                //控制生产条数
//                if(bbb == 10000000){
//                    break;
//                }
            } catch (Exception e) {
                logger.error("TSGProducer is error----->" + e + "<-----");
            }
        }
    }
}
