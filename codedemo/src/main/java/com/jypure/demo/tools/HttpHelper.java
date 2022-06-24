package com.jypure.demo.tools;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author jyl
 * @version V1.0
 * @date 2021/11/11 11:31
 */
public final class HttpHelper {
    private static final String UNKNOWN = "unknown";
    private static final String X_FORWARDED_FOR = "X-Forwarded-For";
    private static final String X_REAL_IP = "X-Real-IP";
    private static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";
    private static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    private static final String EMPTY_STRING = "";

    private HttpHelper() {
    }


    private static boolean notValidIpsValue(String s) {
        return StringUtils.isEmpty(s) || UNKNOWN.equalsIgnoreCase(s);
    }

    /**
     * 获取客户端ip
     *
     * @return
     */
    public static String getClientIp(ServerWebExchange exchange) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String ipChainStr = headers.getFirst(X_FORWARDED_FOR);
        if (notValidIpsValue(ipChainStr)) {
            ipChainStr = headers.getFirst(HTTP_X_FORWARDED_FOR);
        }
        if (notValidIpsValue(ipChainStr)) {
            ipChainStr = headers.getFirst(X_REAL_IP);
        }
        if (notValidIpsValue(ipChainStr)) {
            ipChainStr = headers.getFirst(HTTP_CLIENT_IP);
        }
        if (notValidIpsValue(ipChainStr)) {
            return EMPTY_STRING;
        }
        return cipFromIpChain(ipChainStr);
    }

    /**
     * find the first ip in list, the ip must not a private and UNKNOWN
     * e.g. "unknown, 192.168.1.120, 202.192.1.2, 61.212.2.32, 172.16.3.101", return 202.192.1.2
     *
     * @param ipChainStr
     * @return
     */
    private static String cipFromIpChain(String ipChainStr) {
        String clientIp = "";
        try {
            String[] arr = ipChainStr.split(",");
            for (String item : arr) {
                String chkItem = item.trim();
                if (StringUtils.isEmpty(chkItem) || UNKNOWN.equalsIgnoreCase(chkItem)) {
                    continue;
                }
                clientIp = chkItem;
                if (IpUtil.isPublicIP(chkItem)) {
                    return clientIp;
                }
            }
        } catch (Exception ignored) {
            //ignored
        }
        return clientIp;
    }


}
