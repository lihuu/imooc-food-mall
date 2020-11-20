package com.imooc.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Milo
 * @date 8/10/15
 */
@Log4j2
public class MD5Util {

    public static String getEncrypt(String str, String algorithm) {
        if ("md5".equals(algorithm.toLowerCase())) {
            return DigestUtils.md5Hex(str);
        }

        String md5String = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance(algorithm);
            md5.reset();
            byte[] b = md5.digest(str.getBytes());

            for (int i = 0; i < b.length; i++) {
                String bStr = Integer.toHexString((int)b[i] & 0xff);
                if (bStr.length() == 1) {
                    md5String += "0" + bStr;
                } else {
                    md5String += bStr;
                }
            }
        } catch (NoSuchAlgorithmException nsae) {
            // log.error("没有找到指定的加密算法 : [ " + algorithm + " ]\n" + nsae);
            log.error("can not founded the cryptographic algorithm that appointed  : [ {} ]\n" + nsae, algorithm);
        }

        return md5String;
    }

    public static String shaEncrypt(String strSrc) {
        //parameter strSrc is a string will be encrypted,
        //parameter encName is the algorithm name will be used.
        //encName dafault to "MD5"
        MessageDigest md = null;
        String strDes = null;
        String encName = "SHA-1";
        byte[] bt = strSrc.getBytes();
        try {

            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest());  //to HexString
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid algorithm.");
            return null;
        }
        return strDes;
    }

    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

}
