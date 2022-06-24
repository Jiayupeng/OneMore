package com.jypure.demo.tools;

import com.google.common.base.Strings;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;

/**
 * @author jyl
 * @version V1.0
 * @date 2021/11/11 10:30
 */
public final class IpUtil {
    private IpUtil() {
    }

    public static long ipToLong(String ipAddress) {
        long result = 0;
        try {
            if (ipAddress.matches("\\d+")) {
                return Long.parseLong(ipAddress);
            } else {
                String[] ipAddressInArray = ipAddress.split("\\.");
                for (int i = 3; i >= 0; i--) {
                    long ip = Long.parseLong(ipAddressInArray[3 - i]);
                    //left shifting 24,16,8,0 and bitwise OR

                    //1. 192 << 24
                    //1. 168 << 16
                    //1. 1   << 8
                    //1. 2   << 0
                    result |= ip << (i * 8);
                }
                return result;
            }
        } catch (Exception e) {
        }
        return result;
    }

    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);

        for (int i = 0; i < 4; i++) {

            result.insert(0, Long.toString(ip & 0xff));

            if (i < 3) {
                result.insert(0, '.');
            }

            ip = ip >> 8;
        }
        return result.toString();
    }

    public static long ipv6ToLong(String ipv6) {
        String[] str = ipv6.split(":");
        BigInteger ip = BigInteger.ZERO;
        for (int i = 0; i < str.length; i++) {
            //::1
            if (str[i].isEmpty()) {
                str[i] = "0";
            }
            ip = ip.add(BigInteger.valueOf(Long.valueOf(str[i], 16))
                    .shiftLeft(16 * (str.length - i - 1)));
        }
        return ip.longValue();
    }


    public static String getIpMaskString(String ip) {
        if (Strings.isNullOrEmpty(ip)) {
            return ip;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        char[] chars = ip.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if ('.' == chars[i]) {
                count++;
                if (2 == count) {
                    start = i;
                } else if (3 == count) {
                    end = i;
                    break;
                }
            }
        }
        if (end <= start) {
            return ip;
        }
        return ip.substring(0, start + 1) + "***" + ip.substring(end, length);
    }


    public static boolean isPrivateIP(String ip4) {
        if (StringUtils.isEmpty(ip4)) {
            return false;
        }
        int ipVal;
        try {
            ipVal = (int) IpUtil.ipToLong(ip4);
        } catch (NumberFormatException e) {
            return false;
        }
        return isPrivateIP(ipVal);
    }

    public static boolean isPrivateIP(int ipVal) {
        return (ipVal & 0xFF000000) == 0x00000000 ||
                (ipVal & 0xFF000000) == 0x0A000000 ||
                (ipVal & 0xFF000000) == 0x7F000000 ||
                (ipVal & 0xFFF00000) == 0xAC100000 ||
                (ipVal & 0xFFFF0000) == 0xA9FE0000 ||
                (ipVal & 0xFFFF0000) == 0xC0A80000;
    }

    public static boolean isPublicIP(String ip4) {
        if (StringUtils.isEmpty(ip4)) {
            return false;
        }
        int ipVal;
        try {
            ipVal = (int) IpUtil.ipToLong(ip4);
        } catch (NumberFormatException e) {
            return false;
        }
        return !isPrivateIP(ipVal);
    }

    public static void main(String[] args) {
        System.out.println(isPublicIP("111.205.143.213"));
        System.out.println(isPublicIP("192.168.143.213"));
        System.out.println(isPublicIP("-"));
    }
}
