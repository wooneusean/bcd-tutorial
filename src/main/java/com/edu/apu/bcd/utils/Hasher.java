package com.edu.apu.bcd.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Hasher {
    public static String md5(String plaintext) {
        return hash(plaintext, "MD5");
    }

    public static String md5(String plaintext, byte[] salt) {
        return hash(plaintext, "MD5", salt);
    }

    public static String sha256(String plaintext) {
        return hash(plaintext, "SHA256");
    }

    public static String sha256(String plaintext, byte[] salt) {
        return hash(plaintext, "SHA256", salt);
    }

    public static String sha384(String plaintext) {
        return hash(plaintext, "SHA384");
    }

    public static String sha384(String plaintext, byte[] salt) {
        return hash(plaintext, "SHA384", salt);
    }

    public static String sha512(String plaintext) {
        return hash(plaintext, "SHA512");
    }

    public static String sha512(String plaintext, byte[] salt) {
        return hash(plaintext, "SHA512", salt);
    }

    public static byte[] getSalt(int size) {
        SecureRandom sr = new SecureRandom();
        byte[] b = new byte[size];
        sr.nextBytes(b);
        return b;
    }

    private static String hash(String plaintext, String algorithm, byte[] salt) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(plaintext.getBytes());
        md.update(salt);
        return Base64.getEncoder().encodeToString(md.digest());
    }

    private static String hash(String plaintext, String algorithm) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(md.digest());
    }
}
