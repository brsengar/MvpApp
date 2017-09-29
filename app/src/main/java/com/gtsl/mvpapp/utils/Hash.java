package com.gtsl.mvpapp.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static String md5(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(value.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuilder hex = new StringBuilder();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2) {
                    h = "0" + h;
                }
                hex.append(h);
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
