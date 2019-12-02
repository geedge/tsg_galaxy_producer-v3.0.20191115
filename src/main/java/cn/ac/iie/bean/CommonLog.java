package cn.ac.iie.bean;

public class CommonLog {
    //private Long common_log_id;
    private int common_service;
    //private int common_recv_time;
    private int common_direction;
    private String common_l4_protocol;
    private int common_address_type;
    private String common_schema_type;
    private int common_policy_id;
    private String common_user_tags;
    private int common_action;
    private String common_sub_action;
    private String common_user_region;
    private String common_client_ip;
    private int common_client_port;
    private int common_entrance_id;
    private String common_device_id;
    private int common_link_id;
    private String common_isp;
    private int common_encapsulation;
    private String common_sled_ip;
//    private String common_client_location;
//    private String common_client_asn;
//    private String common_subscriber_id;
    private String common_server_ip;
    private int common_server_port;
//    private String common_server_location;
//    private String common_server_asn;
    private String common_app_label;
    //private int common_app_id;
    //private int common_protocol_id;
    private int common_c2s_pkt_num;
    private int common_s2c_pkt_num;
    private int common_c2s_byte_num;
    private int common_s2c_byte_num;
    private int common_start_time;
    private int common_end_time;
    private int common_con_duration_ms;
    private int common_stream_dir;
    private String common_address_list;
    private int common_has_dup_traffic;
    private String common_stream_error;
    private long common_stream_trace_id;

    private String http_url;
    private String http_host;
//    private String http_domain;
    private String http_request_line;
    private String http_response_line;
    private String http_request_header;
    private String http_response_header;
    private String http_request_body;
    private String http_response_body;
    private String http_request_body_key;
    private String http_response_body_key;
    private int http_proxy_flag;
    private int http_sequence;
    private String http_snapshot;
    private String http_cookie;
    private String http_referer;
    private String http_user_agent;
    private String http_content_length;
    private String http_content_type;
    private String http_set_cookie;
    private String http_version;

    private String mail_protocol_type;
    private String mail_sender;
    private String mail_receiver;
    private String mail_subject;
    private String mail_content;
    private String mail_attachment_name;
    private String mail_attachment_content;
    private String mail_eml_file;
    private String mail_snapshot;

    private int dns_message_id;
    private int dns_qr;
    private int dns_opcode;
    private int dns_aa;
    private int dns_tc;
    private int dns_rd;
    private int dns_ra;
    private int dns_rcode;
    private int dns_qdcount;
    private int dns_ancount;
    private int dns_nscount;
    private int dns_arcount;
    private String dns_qname;
    private int dns_qtype;
    private int dns_qclass;
    private String dns_cname;
    private int dns_sub;
    private String dns_rr;

    private String ssl_version;
    private String ssl_sni;
    private String ssl_san;
    private String ssl_cn;
    private int ssl_pinningst;
    private int ssl_intercept_state;
    private int ssl_server_side_latency;
    private int ssl_client_side_latency;
    private String ssl_server_side_version;
    private String ssl_client_side_version;
    private int ssl_cert_verify;
    private String ssl_error;
    private int ssl_con_latency_ms;

    private String ftp_url;
    private String ftp_content;

    private int bgp_type;
    private String bgp_as_num;
    private String bgp_route;

    private String voip_calling_account;
    private String voip_called_account;
    private String voip_calling_number;
    private String voip_called_number;

    private int radius_packet_type;
    private String radius_nas_ip;
    private String radius_framed_ip;
    private String radius_account;
    private int radius_session_timeout;
    private int radius_idle_timeout;
    private int radius_acct_status_type;
    private int radius_acct_terminate_cause;

    private String streaming_media_url;
    private String streaming_media_protocol;

    public CommonLog() {
    }

    public String getCommon_sub_action() {
        return common_sub_action;
    }

    public void setCommon_sub_action(String common_sub_action) {
        this.common_sub_action = common_sub_action;
    }

    public String getCommon_schema_type() {
        return common_schema_type;
    }

    public void setCommon_schema_type(String common_schema_type) {
        this.common_schema_type = common_schema_type;
    }

    public int getCommon_service() {
        return common_service;
    }

    public void setCommon_service(int common_service) {
        this.common_service = common_service;
    }

    public int getCommon_direction() {
        return common_direction;
    }

    public void setCommon_direction(int common_direction) {
        this.common_direction = common_direction;
    }

    public String getCommon_l4_protocol() {
        return common_l4_protocol;
    }

    public void setCommon_l4_protocol(String common_l4_protocol) {
        this.common_l4_protocol = common_l4_protocol;
    }

    public int getCommon_address_type() {
        return common_address_type;
    }

    public void setCommon_address_type(int common_address_type) {
        this.common_address_type = common_address_type;
    }

    public int getCommon_policy_id() {
        return common_policy_id;
    }

    public void setCommon_policy_id(int common_policy_id) {
        this.common_policy_id = common_policy_id;
    }

    public String getCommon_user_tags() {
        return common_user_tags;
    }

    public void setCommon_user_tags(String common_user_tags) {
        this.common_user_tags = common_user_tags;
    }

    public int getCommon_action() {
        return common_action;
    }

    public void setCommon_action(int common_action) {
        this.common_action = common_action;
    }

    public String getCommon_user_region() {
        return common_user_region;
    }

    public void setCommon_user_region(String common_user_region) {
        this.common_user_region = common_user_region;
    }

    public String getCommon_client_ip() {
        return common_client_ip;
    }

    public void setCommon_client_ip(String common_client_ip) {
        this.common_client_ip = common_client_ip;
    }

    public int getCommon_client_port() {
        return common_client_port;
    }

    public void setCommon_client_port(int common_client_port) {
        this.common_client_port = common_client_port;
    }

    public int getCommon_entrance_id() {
        return common_entrance_id;
    }

    public void setCommon_entrance_id(int common_entrance_id) {
        this.common_entrance_id = common_entrance_id;
    }

    public String getCommon_device_id() {
        return common_device_id;
    }

    public void setCommon_device_id(String common_device_id) {
        this.common_device_id = common_device_id;
    }

    public int getCommon_link_id() {
        return common_link_id;
    }

    public void setCommon_link_id(int common_link_id) {
        this.common_link_id = common_link_id;
    }

    public String getCommon_isp() {
        return common_isp;
    }

    public void setCommon_isp(String common_isp) {
        this.common_isp = common_isp;
    }

    public int getCommon_encapsulation() {
        return common_encapsulation;
    }

    public void setCommon_encapsulation(int common_encapsulation) {
        this.common_encapsulation = common_encapsulation;
    }

    public String getCommon_sled_ip() {
        return common_sled_ip;
    }

    public void setCommon_sled_ip(String common_sled_ip) {
        this.common_sled_ip = common_sled_ip;
    }

    public String getCommon_server_ip() {
        return common_server_ip;
    }

    public void setCommon_server_ip(String common_server_ip) {
        this.common_server_ip = common_server_ip;
    }

    public int getCommon_server_port() {
        return common_server_port;
    }

    public void setCommon_server_port(int common_server_port) {
        this.common_server_port = common_server_port;
    }

    public String getCommon_app_label() {
        return common_app_label;
    }

    public void setCommon_app_label(String common_app_label) {
        this.common_app_label = common_app_label;
    }

    public int getCommon_c2s_pkt_num() {
        return common_c2s_pkt_num;
    }

    public void setCommon_c2s_pkt_num(int common_c2s_pkt_num) {
        this.common_c2s_pkt_num = common_c2s_pkt_num;
    }

    public int getCommon_s2c_pkt_num() {
        return common_s2c_pkt_num;
    }

    public void setCommon_s2c_pkt_num(int common_s2c_pkt_num) {
        this.common_s2c_pkt_num = common_s2c_pkt_num;
    }

    public int getCommon_c2s_byte_num() {
        return common_c2s_byte_num;
    }

    public void setCommon_c2s_byte_num(int common_c2s_byte_num) {
        this.common_c2s_byte_num = common_c2s_byte_num;
    }

    public int getCommon_s2c_byte_num() {
        return common_s2c_byte_num;
    }

    public void setCommon_s2c_byte_num(int common_s2c_byte_num) {
        this.common_s2c_byte_num = common_s2c_byte_num;
    }

    public int getCommon_start_time() {
        return common_start_time;
    }

    public void setCommon_start_time(int common_start_time) {
        this.common_start_time = common_start_time;
    }

    public int getCommon_end_time() {
        return common_end_time;
    }

    public void setCommon_end_time(int common_end_time) {
        this.common_end_time = common_end_time;
    }

    public int getCommon_con_duration_ms() {
        return common_con_duration_ms;
    }

    public void setCommon_con_duration_ms(int common_con_duration_ms) {
        this.common_con_duration_ms = common_con_duration_ms;
    }

    public int getCommon_stream_dir() {
        return common_stream_dir;
    }

    public void setCommon_stream_dir(int common_stream_dir) {
        this.common_stream_dir = common_stream_dir;
    }

    public String getCommon_address_list() {
        return common_address_list;
    }

    public void setCommon_address_list(String common_address_list) {
        this.common_address_list = common_address_list;
    }

    public int getCommon_has_dup_traffic() {
        return common_has_dup_traffic;
    }

    public void setCommon_has_dup_traffic(int common_has_dup_traffic) {
        this.common_has_dup_traffic = common_has_dup_traffic;
    }

    public String getCommon_stream_error() {
        return common_stream_error;
    }

    public void setCommon_stream_error(String common_stream_error) {
        this.common_stream_error = common_stream_error;
    }

    public long getCommon_stream_trace_id() {
        return common_stream_trace_id;
    }

    public void setCommon_stream_trace_id(long common_stream_trace_id) {
        this.common_stream_trace_id = common_stream_trace_id;
    }

    public String getHttp_url() {
        return http_url;
    }

    public void setHttp_url(String http_url) {
        this.http_url = http_url;
    }

    public String getHttp_host() {
        return http_host;
    }

    public void setHttp_host(String http_host) {
        this.http_host = http_host;
    }

    public String getHttp_request_line() {
        return http_request_line;
    }

    public void setHttp_request_line(String http_request_line) {
        this.http_request_line = http_request_line;
    }

    public String getHttp_response_line() {
        return http_response_line;
    }

    public void setHttp_response_line(String http_response_line) {
        this.http_response_line = http_response_line;
    }

    public String getHttp_request_header() {
        return http_request_header;
    }

    public void setHttp_request_header(String http_request_header) {
        this.http_request_header = http_request_header;
    }

    public String getHttp_response_header() {
        return http_response_header;
    }

    public void setHttp_response_header(String http_response_header) {
        this.http_response_header = http_response_header;
    }

    public String getHttp_request_body() {
        return http_request_body;
    }

    public void setHttp_request_body(String http_request_body) {
        this.http_request_body = http_request_body;
    }

    public String getHttp_response_body() {
        return http_response_body;
    }

    public void setHttp_response_body(String http_response_body) {
        this.http_response_body = http_response_body;
    }

    public String getHttp_request_body_key() {
        return http_request_body_key;
    }

    public void setHttp_request_body_key(String http_request_body_key) {
        this.http_request_body_key = http_request_body_key;
    }

    public String getHttp_response_body_key() {
        return http_response_body_key;
    }

    public void setHttp_response_body_key(String http_response_body_key) {
        this.http_response_body_key = http_response_body_key;
    }

    public int getHttp_proxy_flag() {
        return http_proxy_flag;
    }

    public void setHttp_proxy_flag(int http_proxy_flag) {
        this.http_proxy_flag = http_proxy_flag;
    }

    public int getHttp_sequence() {
        return http_sequence;
    }

    public void setHttp_sequence(int http_sequence) {
        this.http_sequence = http_sequence;
    }

    public String getHttp_snapshot() {
        return http_snapshot;
    }

    public void setHttp_snapshot(String http_snapshot) {
        this.http_snapshot = http_snapshot;
    }

    public String getHttp_cookie() {
        return http_cookie;
    }

    public void setHttp_cookie(String http_cookie) {
        this.http_cookie = http_cookie;
    }

    public String getHttp_referer() {
        return http_referer;
    }

    public void setHttp_referer(String http_referer) {
        this.http_referer = http_referer;
    }

    public String getHttp_user_agent() {
        return http_user_agent;
    }

    public void setHttp_user_agent(String http_user_agent) {
        this.http_user_agent = http_user_agent;
    }

    public String getHttp_content_length() {
        return http_content_length;
    }

    public void setHttp_content_length(String http_content_length) {
        this.http_content_length = http_content_length;
    }

    public String getHttp_content_type() {
        return http_content_type;
    }

    public void setHttp_content_type(String http_content_type) {
        this.http_content_type = http_content_type;
    }

    public String getHttp_set_cookie() {
        return http_set_cookie;
    }

    public void setHttp_set_cookie(String http_set_cookie) {
        this.http_set_cookie = http_set_cookie;
    }

    public String getHttp_version() {
        return http_version;
    }

    public void setHttp_version(String http_version) {
        this.http_version = http_version;
    }

    public String getMail_protocol_type() {
        return mail_protocol_type;
    }

    public void setMail_protocol_type(String mail_protocol_type) {
        this.mail_protocol_type = mail_protocol_type;
    }

    public String getMail_sender() {
        return mail_sender;
    }

    public void setMail_sender(String mail_sender) {
        this.mail_sender = mail_sender;
    }

    public String getMail_receiver() {
        return mail_receiver;
    }

    public void setMail_receiver(String mail_receiver) {
        this.mail_receiver = mail_receiver;
    }

    public String getMail_subject() {
        return mail_subject;
    }

    public void setMail_subject(String mail_subject) {
        this.mail_subject = mail_subject;
    }

    public String getMail_content() {
        return mail_content;
    }

    public void setMail_content(String mail_content) {
        this.mail_content = mail_content;
    }

    public String getMail_attachment_name() {
        return mail_attachment_name;
    }

    public void setMail_attachment_name(String mail_attachment_name) {
        this.mail_attachment_name = mail_attachment_name;
    }

    public String getMail_attachment_content() {
        return mail_attachment_content;
    }

    public void setMail_attachment_content(String mail_attachment_content) {
        this.mail_attachment_content = mail_attachment_content;
    }

    public String getMail_eml_file() {
        return mail_eml_file;
    }

    public void setMail_eml_file(String mail_eml_file) {
        this.mail_eml_file = mail_eml_file;
    }

    public String getMail_snapshot() {
        return mail_snapshot;
    }

    public void setMail_snapshot(String mail_snapshot) {
        this.mail_snapshot = mail_snapshot;
    }

    public int getDns_message_id() {
        return dns_message_id;
    }

    public void setDns_message_id(int dns_message_id) {
        this.dns_message_id = dns_message_id;
    }

    public int getDns_qr() {
        return dns_qr;
    }

    public void setDns_qr(int dns_qr) {
        this.dns_qr = dns_qr;
    }

    public int getDns_opcode() {
        return dns_opcode;
    }

    public void setDns_opcode(int dns_opcode) {
        this.dns_opcode = dns_opcode;
    }

    public int getDns_aa() {
        return dns_aa;
    }

    public void setDns_aa(int dns_aa) {
        this.dns_aa = dns_aa;
    }

    public int getDns_tc() {
        return dns_tc;
    }

    public void setDns_tc(int dns_tc) {
        this.dns_tc = dns_tc;
    }

    public int getDns_rd() {
        return dns_rd;
    }

    public void setDns_rd(int dns_rd) {
        this.dns_rd = dns_rd;
    }

    public int getDns_ra() {
        return dns_ra;
    }

    public void setDns_ra(int dns_ra) {
        this.dns_ra = dns_ra;
    }

    public int getDns_rcode() {
        return dns_rcode;
    }

    public void setDns_rcode(int dns_rcode) {
        this.dns_rcode = dns_rcode;
    }

    public int getDns_qdcount() {
        return dns_qdcount;
    }

    public void setDns_qdcount(int dns_qdcount) {
        this.dns_qdcount = dns_qdcount;
    }

    public int getDns_ancount() {
        return dns_ancount;
    }

    public void setDns_ancount(int dns_ancount) {
        this.dns_ancount = dns_ancount;
    }

    public int getDns_nscount() {
        return dns_nscount;
    }

    public void setDns_nscount(int dns_nscount) {
        this.dns_nscount = dns_nscount;
    }

    public int getDns_arcount() {
        return dns_arcount;
    }

    public void setDns_arcount(int dns_arcount) {
        this.dns_arcount = dns_arcount;
    }

    public String getDns_qname() {
        return dns_qname;
    }

    public void setDns_qname(String dns_qname) {
        this.dns_qname = dns_qname;
    }

    public int getDns_qtype() {
        return dns_qtype;
    }

    public void setDns_qtype(int dns_qtype) {
        this.dns_qtype = dns_qtype;
    }

    public int getDns_qclass() {
        return dns_qclass;
    }

    public void setDns_qclass(int dns_qclass) {
        this.dns_qclass = dns_qclass;
    }

    public String getDns_cname() {
        return dns_cname;
    }

    public void setDns_cname(String dns_cname) {
        this.dns_cname = dns_cname;
    }

    public int getDns_sub() {
        return dns_sub;
    }

    public void setDns_sub(int dns_sub) {
        this.dns_sub = dns_sub;
    }

    public String getDns_rr() {
        return dns_rr;
    }

    public void setDns_rr(String dns_rr) {
        this.dns_rr = dns_rr;
    }

    public String getSsl_version() {
        return ssl_version;
    }

    public void setSsl_version(String ssl_version) {
        this.ssl_version = ssl_version;
    }

    public String getSsl_sni() {
        return ssl_sni;
    }

    public void setSsl_sni(String ssl_sni) {
        this.ssl_sni = ssl_sni;
    }

    public String getSsl_san() {
        return ssl_san;
    }

    public void setSsl_san(String ssl_san) {
        this.ssl_san = ssl_san;
    }

    public String getSsl_cn() {
        return ssl_cn;
    }

    public void setSsl_cn(String ssl_cn) {
        this.ssl_cn = ssl_cn;
    }

    public int getSsl_pinningst() {
        return ssl_pinningst;
    }

    public void setSsl_pinningst(int ssl_pinningst) {
        this.ssl_pinningst = ssl_pinningst;
    }

    public int getSsl_intercept_state() {
        return ssl_intercept_state;
    }

    public void setSsl_intercept_state(int ssl_intercept_state) {
        this.ssl_intercept_state = ssl_intercept_state;
    }

    public int getSsl_server_side_latency() {
        return ssl_server_side_latency;
    }

    public void setSsl_server_side_latency(int ssl_server_side_latency) {
        this.ssl_server_side_latency = ssl_server_side_latency;
    }

    public int getSsl_client_side_latency() {
        return ssl_client_side_latency;
    }

    public void setSsl_client_side_latency(int ssl_client_side_latency) {
        this.ssl_client_side_latency = ssl_client_side_latency;
    }

    public String getSsl_server_side_version() {
        return ssl_server_side_version;
    }

    public void setSsl_server_side_version(String ssl_server_side_version) {
        this.ssl_server_side_version = ssl_server_side_version;
    }

    public String getSsl_client_side_version() {
        return ssl_client_side_version;
    }

    public void setSsl_client_side_version(String ssl_client_side_version) {
        this.ssl_client_side_version = ssl_client_side_version;
    }

    public int getSsl_cert_verify() {
        return ssl_cert_verify;
    }

    public void setSsl_cert_verify(int ssl_cert_verify) {
        this.ssl_cert_verify = ssl_cert_verify;
    }

    public String getSsl_error() {
        return ssl_error;
    }

    public void setSsl_error(String ssl_error) {
        this.ssl_error = ssl_error;
    }

    public int getSsl_con_latency_ms() {
        return ssl_con_latency_ms;
    }

    public void setSsl_con_latency_ms(int ssl_con_latency_ms) {
        this.ssl_con_latency_ms = ssl_con_latency_ms;
    }

    public String getFtp_url() {
        return ftp_url;
    }

    public void setFtp_url(String ftp_url) {
        this.ftp_url = ftp_url;
    }

    public String getFtp_content() {
        return ftp_content;
    }

    public void setFtp_content(String ftp_content) {
        this.ftp_content = ftp_content;
    }

    public int getBgp_type() {
        return bgp_type;
    }

    public void setBgp_type(int bgp_type) {
        this.bgp_type = bgp_type;
    }

    public String getBgp_as_num() {
        return bgp_as_num;
    }

    public void setBgp_as_num(String bgp_as_num) {
        this.bgp_as_num = bgp_as_num;
    }

    public String getBgp_route() {
        return bgp_route;
    }

    public void setBgp_route(String bgp_route) {
        this.bgp_route = bgp_route;
    }

    public String getVoip_calling_account() {
        return voip_calling_account;
    }

    public void setVoip_calling_account(String voip_calling_account) {
        this.voip_calling_account = voip_calling_account;
    }

    public String getVoip_called_account() {
        return voip_called_account;
    }

    public void setVoip_called_account(String voip_called_account) {
        this.voip_called_account = voip_called_account;
    }

    public String getVoip_calling_number() {
        return voip_calling_number;
    }

    public void setVoip_calling_number(String voip_calling_number) {
        this.voip_calling_number = voip_calling_number;
    }

    public String getVoip_called_number() {
        return voip_called_number;
    }

    public void setVoip_called_number(String voip_called_number) {
        this.voip_called_number = voip_called_number;
    }

    public int getRadius_packet_type() {
        return radius_packet_type;
    }

    public void setRadius_packet_type(int radius_packet_type) {
        this.radius_packet_type = radius_packet_type;
    }

    public String getRadius_nas_ip() {
        return radius_nas_ip;
    }

    public void setRadius_nas_ip(String radius_nas_ip) {
        this.radius_nas_ip = radius_nas_ip;
    }

    public String getRadius_framed_ip() {
        return radius_framed_ip;
    }

    public void setRadius_framed_ip(String radius_framed_ip) {
        this.radius_framed_ip = radius_framed_ip;
    }

    public String getRadius_account() {
        return radius_account;
    }

    public void setRadius_account(String radius_account) {
        this.radius_account = radius_account;
    }

    public int getRadius_session_timeout() {
        return radius_session_timeout;
    }

    public void setRadius_session_timeout(int radius_session_timeout) {
        this.radius_session_timeout = radius_session_timeout;
    }

    public int getRadius_idle_timeout() {
        return radius_idle_timeout;
    }

    public void setRadius_idle_timeout(int radius_idle_timeout) {
        this.radius_idle_timeout = radius_idle_timeout;
    }

    public int getRadius_acct_status_type() {
        return radius_acct_status_type;
    }

    public void setRadius_acct_status_type(int radius_acct_status_type) {
        this.radius_acct_status_type = radius_acct_status_type;
    }

    public int getRadius_acct_terminate_cause() {
        return radius_acct_terminate_cause;
    }

    public void setRadius_acct_terminate_cause(int radius_acct_terminate_cause) {
        this.radius_acct_terminate_cause = radius_acct_terminate_cause;
    }

    public String getStreaming_media_url() {
        return streaming_media_url;
    }

    public void setStreaming_media_url(String streaming_media_url) {
        this.streaming_media_url = streaming_media_url;
    }

    public String getStreaming_media_protocol() {
        return streaming_media_protocol;
    }

    public void setStreaming_media_protocol(String streaming_media_protocol) {
        this.streaming_media_protocol = streaming_media_protocol;
    }
}
