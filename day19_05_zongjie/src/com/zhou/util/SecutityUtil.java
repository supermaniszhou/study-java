package com.zhou.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * 周刘成   2019-12-5
 */
public class SecutityUtil {

    public static String Md5(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] bytes = md.digest(message.getBytes());
            BASE64Encoder base64 = new BASE64Encoder();
            return base64.encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encode(String message) {
        try {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            return base64Encoder.encode(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decode(String message) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] ba = decoder.decodeBuffer(message);
            return new String(ba);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
