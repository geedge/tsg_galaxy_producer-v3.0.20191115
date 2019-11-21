package cn.ac.iie.utils;

import cn.ac.iie.bean.CommonLog;
import cn.ac.iie.bean.tsg_log.CONNECTION_RECORD_LOG;
import cn.ac.iie.bean.tsg_log.PROXY_EVENT_LOG;
import cn.ac.iie.bean.tsg_log.RADIUS_RECORD_LOG;
import cn.ac.iie.bean.tsg_log.SECURITY_EVENT_LOG;
import cn.ac.iie.common.RealtimeCountConfig;

import java.util.Random;

public class GetLogData {
    //协议类型
    private static String[] commonL4Protocols = {"IPv4_TCP","IPv4_UDP","IPv6_TCP","IPv6_UDP","VLAN","MAC",
            "GRE","MPLS","L2TP","IPv4","IPv6","PPTP","OpenVPN"};
    //协议类型
    private static String[] commonSchemaTypes ={"HTTP","MAIL","DNS","SSL","FTP","BGP","VOIP"};
    //动作  0：无动作 1：检测 2：拦截 4：丢弃 16：阻断 48：操控（重定向、限速、替换、Hijack、Inject） 128：白名单
    private static int[]  commonActions = {0,1,2,4,16,48,128};
    private static String isps[] = {"CMCC","China Telecom","China Unicom"};
    //原始二层封装格式   0:以太网   8:PPP  12:Cisco HDLC
    private static int[] common_encapsulations = {0,8,12};
    //常用server port
    private static int[] serverPorts={20,21,22,80,53,443,8080,23,25,110,3128,8081,9098,1080,443,69,9080,9090,3389,1521,2100,1433,1434,3306};
    //http协议属性
    private static String[] httpVersion = {"http1","http2"};
    private static String[] httpContentType={"text/html","text/xml","image/gif","application/x-jpg","text/plain","application/pdf","application/x-javascript","image/jpeg"};
    private static String[] cookies={"BIDUPSID=BD88B6AFA354C9974BA5DC656D1DCAFA; PSTM=1565062095; BD_UPN=12314753; MCITY=-131%3A; BDUSS=Eh5S2xZMllWaVVYLWFhMDFvUUg3Y3JGSkIzWk5PZml5RmdIYX55WmVVbH5MWmhkRVFBQUFBJCQAAAAAAAAAAAEAAAA-KHd4wuTEu-zh5M4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH-gcF1~oHBdV; BAIDUID=1563418C6EA616597E5578248A246C87:FG=1; BDSFRCVID=HuIOJeC6291gSorwGuZUMuC8OHbSMIRTH6aoVZ_9r344OArTY7JbEG0Pjx8g0KubVI2-ogKK0mOTHv0F_2uxOjjg8UtVJeC6EG0Ptf8g0M5; H_BDCLCKID_SF=tJke_C_MfC-3fP36qR6B2--fMmT22-us3T4L2hcH0bT_jJnchUC55nLI3tOu-xtOBKTihIn_Lfb1MRnoDh6ZyxPJbho8-U5p-e50Wq5TtUJreCnTDMRh-xCIjajyKMnitIj9-pnKtpQrh459XP68bTkA5bjZKxtq3mkjbPbDfn028DKuD6K-j5c3jHDs-bbfHD5J3bjbbTrjDCvvefR5y4LdLp7xJ-TbamOfLK3xLl4VJ4K42qQrDq4iXUnO-44eWJLHVI-5JDPWMIvuht8_hDCyMl6b5JtXKKOLVh620l7keq8CD6Jr24DI0qtqtRb0B6TmVp7dM4jzqK52y5jHhUFOet8ttj5TJanjWpbD3bcpsIJMyh_WbT8U5f5jhtoCaKviaKJEBMb1fCJDBT5h2M4qMxtOLR3pWDTm_q5TtUJMeCnTDMFhe6j0DGujt5_jfK6b36rtKRTffjrnhPF3Q4tzXP6-35KHaIrU-Do8bKLhfpQE5f-WXnJB-U7H2h37JD6yXxn5yqQoOpTKhljK0xLRWtoxJpO7BRbMopvaKtcGEC3vbURvD-ug3-7qJU5dtjTO2bc_5KnlfMQ_bf--QfbQ0hOhqP-jBRIEoD0hJI_aMItrKPnt5KCehxv02tQba5vXsJrHbIvljInOy4oThfvB3lJyQfTfJD7hKp6a0KnceqvoD-Jc3MkjhhjRbpT2Ba6hBhA-XMQkeq8CQft20b0EeMtjBbQa3HnTbJ7jWhk2ep72y5jvQlRX5q79atTMfNTJ-qcH0KQpsIJM5-DWbT8IjHCDt5FftnFDVCvJanTjjTrph-rB5t6H-UnLqMvtWmOZ0l8KtDIaeUOvKRJn5qIAXqomqUR7KH7uaxomWIQHDUQLBTrKDT33XPQHLpFfWDr4KKJx2tPWeIJo5t54yjjDhUJiB5OLBan7LDJIXKohJh7FM4tW3J0ZyxomtfQxtNRJ0DnjtpChbRO4-TFMe5oBDx5; H_PS_PSSID=1462_21088_18559_29904_29568_29699_29220_22159; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; delPer=0; BD_CK_SAM=1; PSINO=2; ZD_ENTRY=empty; BD_HOME=1; pgv_pvi=3102172160; pgv_si=s565442560; session_name=www.baidu.com; BDRCVFR[dG2JNJb_ajR]=mk3SLVN4HKm; BDRCVFR[-pGxjrCMryR]=mk3SLVN4HKm; BDRCVFR[tox4WRQ4-Km]=mk3SLVN4HKm; session_id=1573034181083; COOKIE_SESSION=9_0_8_8_39_45_0_4_8_6_0_2_0_0_0_0_1573034181_0_1573038053%7C9%23700684_12_1571733999%7C7; H_PS_645EC=4ea7PargYL1P8htf5ZDY74Nv%2B6ZgkHCUSEqOkjgTWTCUe%2FqyTtjpww1EyZ0",
            "__jdu=1630551275; shshshfpa=814b298a-3d8c-3f76-63d0-71137908b859-1568880807; shshshfpb=n4JY%2F9ujr8EMn0FQa4zsQaA%3D%3D; unpl=V2_ZzNtbRYERkd2W0dWK05UDGIEEVsSVxMRJQ5EBH5OXgxgABJeclRCFX0URlVnGl0UZwQZX0VcQRBFCEdkeR1ZAmYBEV1yZ3MWdThGVUsZWwdmBxZdQVFHJUUPRl1LKRdQO21UHABnQxVyDENWcxtVBFcCIl1KV0AQcw5GUHspF2tmThJaQFZHEXULQFBLGGwG; __jdv=76161171|direct|-|none|-|1573029676399; areaId=1; o2State={%22webp%22:true%2C%22lastvisit%22:1573029677912}; __jdc=122270672; __jda=122270672.1630551275.1566544188.1573029676.1573036049.5; 3AB9D23F7A4B3C9B=U7KYCE5CEGK6VG3LYP4IIPJB55WGVY3GD3XCAZY4SE4TA43IYEB2CQV6BL4OGMKWN72W4ZZ3IUKVZ7DY3LCL5HEQAI; shshshfp=4954f08681eeb6cdbee4832c94a2b4e7; shshshsID=cbfb6beb3b1f178b832eb6221e96fc9d_1_1573036154888; __jdb=122270672.6.1630551275|5.1573036049; ipLoc-djd=1-72-2799-0",
            "BIDUPSID=BD88B6AFA354C9974BA5DC656D1DCAFA; PSTM=1565062095; BD_UPN=12314753; MCITY=-131%3A; BDUSS=Eh5S2xZMllWaVVYLWFhMDFvUUg3Y3JGSkIzWk5PZml5RmdIYX55WmVVbH5MWmhkRVFBQUFBJCQAAAAAAAAAAAEAAAA-KHd4wuTEu-zh5M4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH-gcF1~oHBdV; BAIDUID=1563418C6EA616597E5578248A246C87:FG=1; BDSFRCVID=HuIOJeC6291gSorwGuZUMuC8OHbSMIRTH6aoVZ_9r344OArTY7JbEG0Pjx8g0KubVI2-ogKK0mOTHv0F_2uxOjjg8UtVJeC6EG0Ptf8g0M5; H_BDCLCKID_SF=tJke_C_MfC-3fP36qR6B2--fMmT22-us3T4L2hcH0bT_jJnchUC55nLI3tOu-xtOBKTihIn_Lfb1MRnoDh6ZyxPJbho8-U5p-e50Wq5TtUJreCnTDMRh-xCIjajyKMnitIj9-pnKtpQrh459XP68bTkA5bjZKxtq3mkjbPbDfn028DKuD6K-j5c3jHDs-bbfHD5J3bjbbTrjDCvvefR5y4LdLp7xJ-TbamOfLK3xLl4VJ4K42qQrDq4iXUnO-44eWJLHVI-5JDPWMIvuht8_hDCyMl6b5JtXKKOLVh620l7keq8CD6Jr24DI0qtqtRb0B6TmVp7dM4jzqK52y5jHhUFOet8ttj5TJanjWpbD3bcpsIJMyh_WbT8U5f5jhtoCaKviaKJEBMb1fCJDBT5h2M4qMxtOLR3pWDTm_q5TtUJMeCnTDMFhe6j0DGujt5_jfK6b36rtKRTffjrnhPF3Q4tzXP6-35KHaIrU-Do8bKLhfpQE5f-WXnJB-U7H2h37JD6yXxn5yqQoOpTKhljK0xLRWtoxJpO7BRbMopvaKtcGEC3vbURvD-ug3-7qJU5dtjTO2bc_5KnlfMQ_bf--QfbQ0hOhqP-jBRIEoD0hJI_aMItrKPnt5KCehxv02tQba5vXsJrHbIvljInOy4oThfvB3lJyQfTfJD7hKp6a0KnceqvoD-Jc3MkjhhjRbpT2Ba6hBhA-XMQkeq8CQft20b0EeMtjBbQa3HnTbJ7jWhk2ep72y5jvQlRX5q79atTMfNTJ-qcH0KQpsIJM5-DWbT8IjHCDt5FftnFDVCvJanTjjTrph-rB5t6H-UnLqMvtWmOZ0l8KtDIaeUOvKRJn5qIAXqomqUR7KH7uaxomWIQHDUQLBTrKDT33XPQHLpFfWDr4KKJx2tPWeIJo5t54yjjDhUJiB5OLBan7LDJIXKohJh7FM4tW3J0ZyxomtfQxtNRJ0DnjtpChbRO4-TFMe5oBDx5; H_PS_PSSID=1462_21088_18559_29904_29568_29699_29220_22159; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; delPer=0; BD_CK_SAM=1; PSINO=2; ZD_ENTRY=empty; BD_HOME=1; pgv_pvi=3102172160; pgv_si=s565442560; session_name=www.baidu.com; BDRCVFR[dG2JNJb_ajR]=mk3SLVN4HKm; BDRCVFR[-pGxjrCMryR]=mk3SLVN4HKm; BDRCVFR[tox4WRQ4-Km]=mk3SLVN4HKm; COOKIE_SESSION=54_0_8_8_38_44_0_4_8_6_2_2_88343_0_6_0_1573034181_0_1573034175%7C9%23700684_12_1571733999%7C7; session_id=1573034181083; H_PS_645EC=659aDFnCu5FT8ndJl92Iu2lbcb4KEndp4Aa0JsT%2BXPNcLObYYzchyEF%2FSys",
            "BIDUPSID=BD88B6AFA354C9974BA5DC656D1DCAFA; PSTM=1565062095; BD_UPN=12314753; MCITY=-131%3A; BDUSS=Eh5S2xZMllWaVVYLWFhMDFvUUg3Y3JGSkIzWk5PZml5RmdIYX55WmVVbH5MWmhkRVFBQUFBJCQAAAAAAAAAAAEAAAA-KHd4wuTEu-zh5M4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH-gcF1~oHBdV; BAIDUID=1563418C6EA616597E5578248A246C87:FG=1; BDSFRCVID=HuIOJeC6291gSorwGuZUMuC8OHbSMIRTH6aoVZ_9r344OArTY7JbEG0Pjx8g0KubVI2-ogKK0mOTHv0F_2uxOjjg8UtVJeC6EG0Ptf8g0M5; H_BDCLCKID_SF=tJke_C_MfC-3fP36qR6B2--fMmT22-us3T4L2hcH0bT_jJnchUC55nLI3tOu-xtOBKTihIn_Lfb1MRnoDh6ZyxPJbho8-U5p-e50Wq5TtUJreCnTDMRh-xCIjajyKMnitIj9-pnKtpQrh459XP68bTkA5bjZKxtq3mkjbPbDfn028DKuD6K-j5c3jHDs-bbfHD5J3bjbbTrjDCvvefR5y4LdLp7xJ-TbamOfLK3xLl4VJ4K42qQrDq4iXUnO-44eWJLHVI-5JDPWMIvuht8_hDCyMl6b5JtXKKOLVh620l7keq8CD6Jr24DI0qtqtRb0B6TmVp7dM4jzqK52y5jHhUFOet8ttj5TJanjWpbD3bcpsIJMyh_WbT8U5f5jhtoCaKviaKJEBMb1fCJDBT5h2M4qMxtOLR3pWDTm_q5TtUJMeCnTDMFhe6j0DGujt5_jfK6b36rtKRTffjrnhPF3Q4tzXP6-35KHaIrU-Do8bKLhfpQE5f-WXnJB-U7H2h37JD6yXxn5yqQoOpTKhljK0xLRWtoxJpO7BRbMopvaKtcGEC3vbURvD-ug3-7qJU5dtjTO2bc_5KnlfMQ_bf--QfbQ0hOhqP-jBRIEoD0hJI_aMItrKPnt5KCehxv02tQba5vXsJrHbIvljInOy4oThfvB3lJyQfTfJD7hKp6a0KnceqvoD-Jc3MkjhhjRbpT2Ba6hBhA-XMQkeq8CQft20b0EeMtjBbQa3HnTbJ7jWhk2ep72y5jvQlRX5q79atTMfNTJ-qcH0KQpsIJM5-DWbT8IjHCDt5FftnFDVCvJanTjjTrph-rB5t6H-UnLqMvtWmOZ0l8KtDIaeUOvKRJn5qIAXqomqUR7KH7uaxomWIQHDUQLBTrKDT33XPQHLpFfWDr4KKJx2tPWeIJo5t54yjjDhUJiB5OLBan7LDJIXKohJh7FM4tW3J0ZyxomtfQxtNRJ0DnjtpChbRO4-TFMe5oBDx5; H_PS_PSSID=1462_21088_18559_29904_29568_29699_29220_22159; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; pgv_pvi=3837043712; pgv_si=s3271133184; BDSVRTM=0; ZD_ENTRY=baidu"
            ,"BAIDU_SSP_lcr=https://www.baidu.com/link?url=W8vjkcYqUvzPkb4tmze6jzWZZeICvTPlcfMuFKpY0JE98rdIxhOjForhLDTVmkuy9jppGvev_OY_vuEUb9KBiK&wd=&eqid=ad773ef600542a6f000000035dc37425; _javaeye_cookie_id_=1565317219441374; _ga=GA1.2.1795365517.1565317221; _javaeye3_session_=BAh7BjoPc2Vzc2lvbl9pZCIlODI1NzNlMzZkMjBhNzRjYzFmYWJiODk5OGM2NWUyY2E%3D--506fe15f912363452e1d0fba427b6bd2b8572acb; dc_tos=q0ksnp; _gid=GA1.2.1456666687.1573090837; _gat_gtag_UA_127895514_6=1; Hm_lvt_e19a8b00cf63f716d774540875007664=1570503756,1570672140,1570772420,1573090838; Hm_lpvt_e19a8b00cf63f716d774540875007664=1573090838"};
    //邮件协议类型
    private static String[] mailProtocolTypes ={"SMTP","POP3","IMAP4"};
    private static String[] mailSubject={"关于TSG项目的需求分析","关于TSG项目的修改方案","关于TSG项目的增加功能提议","关于TSG项目的部署方案","关于TSG项目的优化方案","TSG项目总结","关于TSG项目的问题解决方案","关于TSG项目的完善"};
    //SSL版本信息
    private static String [] sslVersions = {"V1","V2","V3"};
    //ssl版本
    private static String [] sslSideVersions = {"SSLv3","TLSv1","TLSv1.1","TLSv1.2","TLSv1.3","unknown"};
    //自治系统号
    private static String[] bgpAsNums ={"100","200"};
    //报文类型
    private static int[] RadiusPacketTypes ={1,2,3,4,5,11};
    //请求类型数组 0：标准查询 1：反向查询 2：DNS状态请求 5：DNS域更新请求
    private static int[] dnsOpcodes={0,1,2,5};
    //传输协议
    private static String[] streamingMediaProtocols={"RTP","RTCP","SRTP","SRTCP","RTSP","SDP","RTMP/RTMPS","HLS","MMS"};

    public static SECURITY_EVENT_LOG getSecurityEventLog(int messageId, Long commonLogId){
        //基础属性
        SECURITY_EVENT_LOG security_EVENT_log = (SECURITY_EVENT_LOG)getCommonData(new SECURITY_EVENT_LOG(), commonLogId);
        //http协议属性
        security_EVENT_log = (SECURITY_EVENT_LOG) getHttpData(security_EVENT_log);
        //mail协议属性
        security_EVENT_log = (SECURITY_EVENT_LOG) getMailData(security_EVENT_log);
        //DNS协议属性
        security_EVENT_log =(SECURITY_EVENT_LOG) getDnsData(security_EVENT_log,messageId);
        //SSL协议属性
        security_EVENT_log = (SECURITY_EVENT_LOG) getSslData(security_EVENT_log);
        //FTP协议属性
        security_EVENT_log = (SECURITY_EVENT_LOG) getFtpData(security_EVENT_log);
        //BGP协议属性
        security_EVENT_log = (SECURITY_EVENT_LOG) getBgpData(security_EVENT_log);
        //VOIP协议属性
        security_EVENT_log = (SECURITY_EVENT_LOG) getVoipData(security_EVENT_log);
        //STREAMING_MEDIA协议属性
        security_EVENT_log = (SECURITY_EVENT_LOG) getStreamingMediaData(security_EVENT_log);
        return security_EVENT_log;
    }
    public static CONNECTION_RECORD_LOG getConnectionRecordLog(int messageId, Long commonLogId){
        //基础属性
        CONNECTION_RECORD_LOG connection_record_log = (CONNECTION_RECORD_LOG)getCommonData(new CONNECTION_RECORD_LOG(), commonLogId);
        //http协议属性
        connection_record_log = (CONNECTION_RECORD_LOG) getHttpData(connection_record_log);
        //mail协议属性
        connection_record_log = (CONNECTION_RECORD_LOG) getMailData(connection_record_log);
        //DNS协议属性
        connection_record_log =(CONNECTION_RECORD_LOG) getDnsData(connection_record_log,messageId);
        //SSL协议属性
        connection_record_log = (CONNECTION_RECORD_LOG) getSslData(connection_record_log);
        //FTP协议属性
        connection_record_log = (CONNECTION_RECORD_LOG) getFtpData(connection_record_log);
        //BGP协议属性
        connection_record_log = (CONNECTION_RECORD_LOG) getBgpData(connection_record_log);
        //VOIP协议属性
        connection_record_log = (CONNECTION_RECORD_LOG) getVoipData(connection_record_log);
        //STREAMING_MEDIA协议属性
        connection_record_log = (CONNECTION_RECORD_LOG) getStreamingMediaData(connection_record_log);
        return connection_record_log;
    }
    public static PROXY_EVENT_LOG getProxyEventLog(Long commonLogId){
        PROXY_EVENT_LOG proxy_EVENT_log = (PROXY_EVENT_LOG)getCommonData(new PROXY_EVENT_LOG(), commonLogId);
        proxy_EVENT_log = (PROXY_EVENT_LOG) getHttpData(proxy_EVENT_log);
        return proxy_EVENT_log;
    }
    public static RADIUS_RECORD_LOG getRadiusRecordLog(Long commonLogId){
        RADIUS_RECORD_LOG _radius_record_log = (RADIUS_RECORD_LOG)getCommonData(new RADIUS_RECORD_LOG(), commonLogId);
        _radius_record_log = (RADIUS_RECORD_LOG)getRadiusData(_radius_record_log);
        return _radius_record_log;
    }


    public static CommonLog getStreamingMediaData(CommonLog commonLog){
        //节目访问地址
        commonLog.setStreaming_media_url(GetLogFieldDataUtil.makeUrlData());
        //传输协议
        commonLog.setStreaming_media_protocol(streamingMediaProtocols[new Random().nextInt(streamingMediaProtocols.length)]);
        return commonLog;
    }
    public static CommonLog getDnsData(CommonLog commonLog, int messageId){
        //消息ID标示
        commonLog.setDns_message_id(messageId);
        //查询/响应标志  0：查询，1：响应
        commonLog.setDns_qr(new Random().nextInt(2));
        //请求类型
        commonLog.setDns_opcode(dnsOpcodes[new Random().nextInt(dnsOpcodes.length)]);
        //标示响应该消息的域名服务器是该域中的权威域名服务器
        commonLog.setDns_aa(new Random().nextInt(2));
        //是否因为长度超过UDP数据包的标准长度512字节
        commonLog.setDns_tc(new Random().nextInt(2));
        //是否递归查询
        commonLog.setDns_rd(new Random().nextInt(2));
        //DNS域名服务器是否支持递归查询
        commonLog.setDns_ra(new Random().nextInt(2));
        //响应消息的类型
        commonLog.setDns_rcode(new Random().nextInt(10));
        //问题记录数
        commonLog.setDns_qdcount(new Random().nextInt(100));
        //回答记录数
        commonLog.setDns_ancount(new Random().nextInt(100));
        //授权记录数
        commonLog.setDns_nscount(new Random().nextInt(100));
        //附加记录数
        commonLog.setDns_arcount(new Random().nextInt(100));
        //查询内容
        commonLog.setDns_qname(GetLogFieldDataUtil.makeDomain(GetLogFieldDataUtil.makeUrlData()));
        //查询类型
        commonLog.setDns_qtype(new Random().nextInt(10));
        //查询类
        commonLog.setDns_qclass(new Random().nextInt(10));
        //真实名称记录
        commonLog.setDns_cname(GetLogFieldDataUtil.makeRandomString(50)+10);
        //是否域名系统安全扩展  1：dns；2：dnssec
        commonLog.setDns_sub(new Random().nextInt(3));
        //应答资源记录集合  json
        commonLog.setDns_rr(GetLogFieldDataUtil.makeDnsRr());
        return commonLog;
    }
    public static CommonLog getFtpData(CommonLog commonLog){
        //FTP链接
        commonLog.setFtp_url("ftp://test:test@"+ GetLogFieldDataUtil.makeIPv4RandomClient()+"/soft/list.txt");
        //FTP内容
        commonLog.setFtp_content("");
        return commonLog;
    }
    public static CommonLog getVoipData(CommonLog commonLog){
        //主叫VOIP账号
        commonLog.setVoip_calling_account(GetLogFieldDataUtil.makeVoipCallAccount());
        //被叫VOIP账号
        commonLog.setVoip_called_account(GetLogFieldDataUtil.makeVoipCallAccount());
        //VOIP主叫电信号码
        commonLog.setVoip_calling_number(GetLogFieldDataUtil.makeVoipCallNumber());
        //VOIP被叫电信号码
        commonLog.setVoip_called_number(GetLogFieldDataUtil.makeVoipCallNumber());
        return commonLog;
    }
    public static CommonLog getHttpData(CommonLog commonLog){
        //访问url
        commonLog.setHttp_url(GetLogFieldDataUtil.makeUrlData());
        //主机地址
        commonLog.setHttp_host(GetLogFieldDataUtil.makeHost(commonLog.getHttp_url()));
        //域名  补全
        //commonLog.setHttp_domain(GetLogFieldDataUtil.makeHost(proxy_policy_log.getHttp_url()));
        //请求行
        commonLog.setHttp_request_line("");
        //应答行
        commonLog.setHttp_response_line("");
        //原始请求头
        commonLog.setHttp_request_header("");
        //原始应答头
        commonLog.setHttp_response_header("");
        //原始请求体
        commonLog.setHttp_request_body("");
        //原始应答体
        commonLog.setHttp_response_body("");
        //请求体转储文件KEY
        commonLog.setHttp_request_body_key("");
        //应答体转储文件KEY
        commonLog.setHttp_response_body_key("");
        //HTTP代理标识
        commonLog.setHttp_proxy_flag(new Random().nextInt(10));
        //HTTP会话序列号
        commonLog.setHttp_sequence(new Random().nextInt(10));
        //现场片段快照
        commonLog.setHttp_snapshot("");
        //Cookie值
        commonLog.setHttp_cookie(cookies[new Random().nextInt(cookies.length)]);
        //Referer值
        commonLog.setHttp_referer("");
        //用户代理
        commonLog.setHttp_user_agent("");
        //HTTP内容长度
        commonLog.setHttp_content_length(String.valueOf(new Random().nextInt(39000)+10000));
        //HTTP内容类型
        commonLog.setHttp_content_type(httpContentType[new Random().nextInt(httpContentType.length)]);
        //Set-Cookie值
        commonLog.setHttp_set_cookie("");
        //应用协议类型
        commonLog.setHttp_version(httpVersion[new Random().nextInt(httpVersion.length)]);
        return commonLog;
    }
    public static CommonLog getSslData(CommonLog commonLog){
        //SSL版本信息
        commonLog.setSsl_version(sslVersions[new Random().nextInt(sslVersions.length)]);
        //服务器名称指示
        commonLog.setSsl_sni(GetLogFieldDataUtil.makeDomain(GetLogFieldDataUtil.makeUrlData()));
        //SSL多域名(SAN)
        commonLog.setSsl_san("");
        //SSL通用名称
        commonLog.setSsl_cn("");
        //pinning状态  0-not pinning，1-pinning，2-maybe pinning
        commonLog.setSsl_pinningst(new Random().nextInt(3));
        //拦截状态  0-passthrough, 1-intercept, 2-shutdown
        commonLog.setSsl_intercept_state(new Random().nextInt(3));
        //服务器侧ssl建立延迟
        commonLog.setSsl_server_side_latency(new Random().nextInt(10000)+100);
        //客户端侧ssl建立延迟
        commonLog.setSsl_client_side_latency(new Random().nextInt(10000)+100);
        //服务器侧ssl版本
        commonLog.setSsl_server_side_version(sslSideVersions[new Random().nextInt(sslSideVersions.length)]);
        //客户端侧ssl版本
        commonLog.setSsl_client_side_version(sslSideVersions[new Random().nextInt(sslSideVersions.length)]);
        //证书校验结果 0-校验不通过，1-校验通过
        commonLog.setSsl_cert_verify(new Random().nextInt(2));
        //ssl错误信息
        commonLog.setSsl_error("");
        //握手延迟
        commonLog.setSsl_con_latency_ms(new Random().nextInt(50));
        return commonLog;
    }
    public static CommonLog getMailData(CommonLog commonLog){
        //邮件协议类型
        commonLog.setMail_protocol_type(mailProtocolTypes[new Random().nextInt(mailProtocolTypes.length)]);
        //发件人邮箱
        commonLog.setMail_sender(GetLogFieldDataUtil.makeMail());
        //收件人邮箱
        commonLog.setMail_receiver(GetLogFieldDataUtil.makeMail());
        //邮件主题
        commonLog.setMail_subject(mailSubject[new Random().nextInt(mailSubject.length)]);
        //邮件正文
        commonLog.setMail_content("");
        //邮件附件名
        commonLog.setMail_attachment_name("");
        //邮件附件内容
        commonLog.setMail_attachment_content("");
        //邮件EML文件
        commonLog.setMail_eml_file("");
        //现场片段快照
        commonLog.setMail_snapshot("");
        return commonLog;
    }
    public static CommonLog getBgpData(CommonLog commonLog){
        //消息类型 1:open(打开消息) 2:keepalive(存活消息) 3:update(更新消息) 4:notification(报错消息)
        commonLog.setBgp_type(new Random().nextInt(4)+1);
        //自治系统号
        commonLog.setBgp_as_num(bgpAsNums[new Random().nextInt(bgpAsNums.length)]);
        //路由信息
        commonLog.setBgp_route("192.168."+(new Random().nextInt(253)+1)+".0"+"/24");
        return commonLog;
    }
    public static CommonLog getRadiusData(CommonLog commonLog){
        //报文类型
        commonLog.setRadius_packet_type(new Random().nextInt(RadiusPacketTypes.length));
        //ISN接入的IP
        commonLog.setRadius_nas_ip(GetLogFieldDataUtil.makeIPv4Data());
        //服务器下发的用户地址
        commonLog.setRadius_framed_ip(GetLogFieldDataUtil.makeIPv4Data());
        //用户名
        commonLog.setRadius_account(GetLogFieldDataUtil.makeRandomString(5));
        //用户提供服务的剩余时间
        commonLog.setRadius_session_timeout(new Random().nextInt(120000)+180000);
        //用户持续空闲的最大时间
        commonLog.setRadius_idle_timeout(new Random().nextInt(1800000)+600000);
        //计费请求报文类型
        commonLog.setRadius_acct_status_type(new Random().nextInt(5)+1);
        //用户连接中断的原因
        commonLog.setRadius_acct_terminate_cause(new Random().nextInt(5)+1);
        return commonLog;
    }
    public static CommonLog getCommonData(CommonLog commonLog, Long commonLogId){
        //日志id   补全
        //commonLog.setCommon_log_id(commonLogId);
        //业务类型
        commonLog.setCommon_service(new Random().nextInt(11) + 1);
        //接收时间   补全
//        commonLog.setCommon_recv_time((int) (System.currentTimeMillis() / 1000));//测试
        //传输方向   0或1
        commonLog.setCommon_direction(new Random().nextInt(2));
        //协议类型
        commonLog.setCommon_l4_protocol(commonL4Protocols[new Random().nextInt(commonL4Protocols.length)]);
        if (commonLog.getCommon_l4_protocol().equals("IPv6_TCP")
                || commonLog.getCommon_l4_protocol().equals("IPv6_UDP")
                || commonLog.getCommon_l4_protocol().equals("IPv6")) {
            commonLog.setCommon_address_type(6);
            commonLog.setCommon_client_ip(GetLogFieldDataUtil.makeIPv6Data());
            commonLog.setCommon_server_ip(GetLogFieldDataUtil.makeIPv6Data());
            if (commonLog.getCommon_server_ip().equals(commonLog.getCommon_client_ip())) {
                String[] IPv6Datas = RealtimeCountConfig.IPV6_DATAS.split(",");
                for (String iPv6Data : IPv6Datas) {
                    if (!commonLog.getCommon_server_ip().equals(iPv6Data.trim())) {
                        commonLog.setCommon_client_ip(iPv6Data.trim());
                    }
                }
            }
        }else {
            commonLog.setCommon_address_type(4);
            commonLog.setCommon_client_ip(GetLogFieldDataUtil.makeIPv4Data());
            commonLog.setCommon_server_ip(GetLogFieldDataUtil.makeIPv4Data());
//            commonLog.setCommon_client_ip(GetLogFieldDataUtil.makeIPv4RandomServer());//用于测试
//            commonLog.setCommon_server_ip(GetLogFieldDataUtil.makeIPv4RandomClient());//用于测试
            if (commonLog.getCommon_server_ip().equals(commonLog.getCommon_client_ip())) {
                String[] IPv4Datas = RealtimeCountConfig.IPV4_DATAS.split(",");
                for (String iPv4Data : IPv4Datas) {
                    if (!commonLog.getCommon_server_ip().equals(iPv4Data.trim())) {
                        commonLog.setCommon_client_ip(iPv4Data.trim());
                    }
                }
            }
        }
        //协议类型
        commonLog.setCommon_schema_type(commonSchemaTypes[new Random().nextInt(commonSchemaTypes.length)]);
        //策略id
        commonLog.setCommon_policy_id(new Random().nextInt(10)+1);//测试
        //标签
        commonLog.setCommon_user_tags(GetLogFieldDataUtil.makeRandomString(100));
        //动作
        commonLog.setCommon_action(commonActions[new Random().nextInt(commonActions.length)]);
        //用户自定义域
        commonLog.setCommon_user_region(GetLogFieldDataUtil.makeRandomString(100));

        commonLog.setCommon_client_port(new Random().nextInt(65534) + 1);
        commonLog.setCommon_server_port(serverPorts[new Random().nextInt(serverPorts.length)]);
        if (commonLog.getCommon_server_port() == commonLog.getCommon_client_port()) {
            commonLog.setCommon_client_port(new Random().nextInt(65534) + 1);
            if (commonLog.getCommon_server_port() == commonLog.getCommon_client_port()) {
                commonLog.setCommon_client_port(new Random().nextInt(65534) + 1);
                if (commonLog.getCommon_client_port() == commonLog.getCommon_client_port()) {
                    commonLog.setCommon_client_port(new Random().nextInt(65534) + 1);
                }
            }
        }
        //出入口编号
        commonLog.setCommon_entrance_id(new Random().nextInt(20) + 1);
        //设备编号
        commonLog.setCommon_device_id(String.valueOf(new Random().nextInt(5000000)+1));//本字段为默认1,,填入随机百万的数值用于压力测试
        //设备链路
        commonLog.setCommon_link_id(1);
        //运营商
        commonLog.setCommon_isp(isps[new Random().nextInt(isps.length)]);
        //原始二层封装格式
        commonLog.setCommon_encapsulation(common_encapsulations[new Random().nextInt(common_encapsulations.length)]);
        //处理机IP
        commonLog.setCommon_sled_ip(192+"."+168+"."+10+"."+(new Random().nextInt(253)+1));
        //客户端地址定位信息   补全
        //commonLog.setCommon_client_location();
        //客户端ASN   补全
        //commonLog.setCommon_client_asn();
        //客户端用户名   补全
        //commonLog.setCommon_subscriber_id();
        //服务端地址定位信息   补全
        //commonLog.setCommon_server_location();
        //服务端ASN   补全
        //commonLog.setCommon_server_asn();
        //特征标签
        commonLog.setCommon_app_label("");
        //app id   补全
        //commonLog.setCommon_app_id(new Random().nextInt(20)+1);
        //应用层协议   补全
        //commonLog.setCommon_protocol_id(new Random().nextInt(6) + 1);
        commonLog.setCommon_c2s_pkt_num(new Random().nextInt(30));
        if (commonLog.getCommon_c2s_pkt_num() == 0) {
            commonLog.setCommon_s2c_pkt_num(new Random().nextInt(30) + 1);
            commonLog.setCommon_c2s_byte_num(0);
            commonLog.setCommon_s2c_byte_num(new Random().nextInt(10000) + 100);
        } else {
            commonLog.setCommon_s2c_pkt_num(new Random().nextInt(30));
            commonLog.setCommon_c2s_byte_num((new Random().nextInt(10000) + 100));
            if (commonLog.getCommon_s2c_pkt_num() == 0) {
                commonLog.setCommon_s2c_byte_num(0);
            } else {
                commonLog.setCommon_s2c_byte_num(new Random().nextInt(10000) + 100);
            }
        }
        //会话创建时间
        commonLog.setCommon_start_time(((int) (System.currentTimeMillis() / 1000)) - (new Random().nextInt(60) + 5));
        //会话结束时间
        commonLog.setCommon_end_time((int) (System.currentTimeMillis() / 1000));
        //通信时长
        commonLog.setCommon_con_duration_ms(new Random().nextInt(180000) + 10000);
        //流类型  1:c2s   2:s2c   3:double
        commonLog.setCommon_stream_dir(new Random().nextInt(3) + 1);
        //嵌套地址列表  可空
        commonLog.setCommon_address_list("");
        //是否有重复流量  0:没有 1:有
        commonLog.setCommon_has_dup_traffic(new Random().nextInt(1)+1);
        //异常流的种类
        commonLog.setCommon_stream_error("");
        //流的追踪ID
        commonLog.setCommon_stream_trace_id(new Random().nextLong());
        return commonLog;
    }
}
