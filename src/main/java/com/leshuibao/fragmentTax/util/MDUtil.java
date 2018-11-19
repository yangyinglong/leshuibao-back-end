package com.leshuibao.fragmentTax.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class MDUtil {

    private static String src = "cakin24 security md";

    public static void main(String[] args) {

    }

    public static String jdkMD5(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(content.getBytes());
            return Hex.encodeHexString(md5Bytes).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void jdkMD2() {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD2");
//            byte[] md2Bytes = md.digest(src.getBytes());
//            System.out.println("JDK MD2 : " + Hex.encodeHexString(md2Bytes));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void bcMD5() {
//        Digest digest = new MD5Digest();
//        digest.update(src.getBytes(), 0, src.getBytes().length);
//        byte[] md5Bytes = new byte[digest.getDigestSize()];
//        digest.doFinal(md5Bytes, 0);
//        System.out.println("BC MD5 : " + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
//    }
//
//    public static void bcMD4() {
//        try {
//            Security.addProvider(new BouncyCastleProvider());
//            MessageDigest md = MessageDigest.getInstance("MD4");
//            byte[] md5Bytes = md.digest(src.getBytes());
//            System.out.println("BC MD4 : " + Hex.encodeHexString(md5Bytes));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void ccMD5() {
//        System.out.println("CC MD5 : " + DigestUtils.md5Hex(src.getBytes()));
//    }
//
//    public static void ccMD2() {
//        System.out.println("CC MD2 : " + DigestUtils.md2Hex(src.getBytes()));
//    }
}
