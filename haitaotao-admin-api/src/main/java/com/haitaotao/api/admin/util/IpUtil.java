package com.haitaotao.api.admin.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangyang.zhang
 * @date 2019年07月05日16:06:22
 */
public class IpUtil {

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * string ip to long ip
     *
     * @param    ip
     * @return    long
     */
    public static long ip2long( String ip ) {
        String[] p = ip.split("\\.");
        if ( p.length != 4 ) {
            return 0;
        }

        int p1 = ((Integer.parseInt(p[0]) << 24) & 0xFF000000);
        int p2 = ((Integer.parseInt(p[1]) << 16) & 0x00FF0000);
        int p3 = ((Integer.parseInt(p[2]) <<  8) & 0x0000FF00);
        int p4 = ((Integer.parseInt(p[3])) & 0x000000FF);

        return ((p1 | p2 | p3 | p4) & 0xFFFFFFFFL);
    }
    /**
     * int to ip string
     *
     * @param    ip
     * @return    string
     */
    public static String long2ip( long ip ) {
        return String.valueOf((ip >> 24) & 0xFF) + '.' +
                ((ip >> 16) & 0xFF) + '.' +
                ((ip >> 8) & 0xFF) + '.' +
                ((ip) & 0xFF);
    }

    /**
     * check the validate of the specifeld ip address
     *
     * @param    ip
     * @return    boolean
     */
    public static boolean isIpAddress( String ip ) {
        String[] p = ip.split("\\.");
        if ( p.length != 4 ) {
            return false;
        }

        for ( String pp : p ) {
            if ( pp.length() > 3 ) {
                return false;
            }
            int val = Integer.parseInt(pp);
            if ( val > 255 ) {
                return false;
            }
        }

        return true;
    }
}
