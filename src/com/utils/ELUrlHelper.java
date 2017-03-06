package com.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * EL表达式转码以及去除特殊字符的处理类
 * @author zhongshan.zhang
 *
 */
public class ELUrlHelper {
	
	public static String urlEncode(String str) throws UnsupportedEncodingException{
        return URLEncoder.encode(str,"utf-8");
    }
	
	public static String urlEncodeToId(String str) throws UnsupportedEncodingException{
        return URLEncoder.encode(str,"utf-8").replaceAll("[%~`,@#&=:;<>/]", "");
    }
	
}
