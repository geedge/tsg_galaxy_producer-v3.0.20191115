package cn.ac.iie.utils;

import cn.ac.iie.common.RealtimeCountConfig;
import cn.ac.iie.producer.TSGProducer;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Random;

public class GetLogFieldDataUtil {
    private static final Logger logger = Logger.getLogger(TSGProducer.class);

    public static String makeAppLabel() {
        Random random = new Random();
        String[] appProtoDatas = {"http1", "http2"};
        String appProtoData = appProtoDatas[random.nextInt(appProtoDatas.length)];
        return appProtoData;
    }
    /**
     * 根据配置文件内容获取policy_id
     * @param pzPolicyId
     * @return
     */
    public static int getPolicyId(String pzPolicyId) {
        Random random = new Random();
        if (pzPolicyId.contains(",")){
            String[] policyIds = pzPolicyId.split(",");
            int policyIdOne = Integer.parseInt(policyIds[random.nextInt(policyIds.length)]);
            return policyIdOne;
        }else {
            int policyId = Integer.parseInt(pzPolicyId);
            return policyId;
        }
    }

    //随机生成ip
    public static String makeIPv4Random() {
        Random random = new Random();
        int v4_1 = new Random().nextInt(255) + 1;
        int v4_2 = new Random().nextInt(255);
        int v4_3 = new Random().nextInt(255);
        int v4_4 = new Random().nextInt(255);
        return v4_1 + "." + v4_2 + "." + v4_3 + "." + v4_4;
    }

    public static String makeIPv6Data() {
        Random random = new Random();
        String[] IPv6Datas =RealtimeCountConfig.IPV6_DATAS.split(",");
        String IPv6Data = IPv6Datas[random.nextInt(IPv6Datas.length)].trim();
        return IPv6Data;
    }

    public static String makeIPv4Data() {
        Random random = new Random();
        String[] IPv4Datas = RealtimeCountConfig.IPV4_DATAS.split(",");
        String IPv4Data = IPv4Datas[random.nextInt(IPv4Datas.length)].trim();
        return IPv4Data;
    }

    //随机制造client_ip
    public static String makeIPv4RandomClient() {
        Random random = new Random();
//        int v4_1 = new Random().nextInt(255) + 1;
//        int v4_2 = new Random().nextInt(255);
//        int v4_3 = new Random().nextInt(255);
//        int v4_4 = new Random().nextInt(255);
        int v4_1 = new Random().nextInt(60) + 70;
        int v4_2 = new Random().nextInt(60) + 80;
        int v4_3 = new Random().nextInt(60) + 50;
        int v4_4 = new Random().nextInt(60) + 150;
        return v4_1 + "." + v4_2 + "." + v4_3 + "." + v4_4;
    }

    //随机制造Server_ip
    public static String makeIPv4RandomServer() {
        int v4_1 = 122;
        int v4_2 = 101;
        int v4_3 = new Random().nextInt(255);
        int v4_4 = new Random().nextInt(255);
        return v4_1 + "." + v4_2 + "." + v4_3 + "." + v4_4;
    }

    public static String makeUrlData() {
        Random random = new Random();
        String[] urlDatas = RealtimeCountConfig.URL_DATAS.split(",");
        String urlData = urlDatas[random.nextInt(urlDatas.length)].trim() + new Random().nextInt(200000) + 1;
        return urlData;
    }

    public static String makeHost(String url) {
        if (url.contains("http")) {
            String[] splitHttp = url.split("//");
            String[] splitWwwWtihCom = splitHttp[1].split("/");
            return splitWwwWtihCom[0] + new Random().nextInt(10000) + 1;
        } else {
            if(url.contains(":")){
                String[] splitNoHttp = url.split("/");
                String[] splitNoPort = splitNoHttp[0].split(":");
                return splitNoPort[0] + new Random().nextInt(10000) + 1;
            }else {
                String[] splitNoHttp = url.split("/");
                return splitNoHttp[0] + new Random().nextInt(10000) + 1;
            }
        }
    }

    public static String makeDomain(String url) {
        if (url.contains("http")) {
            String[] hostArr = url.split("//")[1].split("/")[0].split("\\.");
            return hostArr[hostArr.length-2]+"."+hostArr[hostArr.length-1] + new Random().nextInt(5000000) + 1;
        } else {
            if(url.contains(":")){
                String[] hostArr = url.split("/")[0].split(":")[0].split("\\.");
                if(hostArr.length<=2){
                    return hostArr[0]+"."+hostArr[1] + new Random().nextInt(5000000) + 1;
                }else{
                    return hostArr[hostArr.length-2]+"."+hostArr[hostArr.length-1] + new Random().nextInt(5000000) + 1;
                }
            }else {
                String[] hostArr = url.split("/")[0].split("\\.");
                if(hostArr.length<=2){
                    return hostArr[0]+"."+hostArr[1] + new Random().nextInt(5000000) + 1;
                }else{
                    return hostArr[hostArr.length-2]+"."+hostArr[hostArr.length-1] + new Random().nextInt(5000000) + 1;
                }
            }
        }
    }

    public static String makeMail(){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");
        int length = new Random().nextInt(11 - 3 + 1)+3;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = new Random().nextInt(base.length());
            sb.append(base.charAt(number));
        }
        sb.append(email_suffix[(new Random().nextInt(email_suffix.length))]);
        return sb.toString();
    }

    public static String makeRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static String makeVoipCallAccount() {
        String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
        int index=(int)(Math.random()*(telFirst.length-1-0+1)+0);
        String first=telFirst[index];
        String second=String.valueOf((int)(Math.random()*(888-1+1)+1)+10000).substring(1);
        String third=String.valueOf((int)(Math.random()*(9100-1+1)+1)+10000).substring(1);
        return first+second+third;
    }

    public static String makeVoipCallNumber() {
        String[] telFirst="133,153,180,189,139,181".split(",");
        int index=(int)(Math.random()*(telFirst.length-1-0+1)+0);
        String first=telFirst[index];
        String second=String.valueOf((int)(Math.random()*(888-1+1)+1)+10000).substring(1);
        String third=String.valueOf((int)(Math.random()*(9100-1+1)+1)+10000).substring(1);
        return first+second+third;
    }

    public static String makeDnsRr(){
        JSONObject jsonObj = new JSONObject();
        int count = new Random().nextInt(10);
        for (int i=0;i<=count;i++){
            jsonObj.put(GetLogFieldDataUtil.makeRandomString(new Random().nextInt(5)+5), GetLogFieldDataUtil.makeRandomString(new Random().nextInt(10)+10));
        }
        return jsonObj.toJSONString();
    }

    public static String makeContent(int length) {
        String content = "";
        for (int i = 1; i <= length; i++) {
            String str = "";
            int hs, ls;
            Random random = new Random();
            hs = (176 + Math.abs(random.nextInt(39)));
            ls = (161 + Math.abs(random.nextInt(93)));
            byte[] b = new byte[2];
            b[0] = (new Integer(hs).byteValue());
            b[1] = (new Integer(ls).byteValue());
            try {
                str = new String(b, "GBk"); //转成中文
                content += str;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return content;
    }
}
