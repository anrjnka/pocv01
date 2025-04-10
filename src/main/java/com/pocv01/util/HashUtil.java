package com.pocv01.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashUtil {
    public static String hashId(Long id) throws NoSuchAlgorithmException{

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(id.toString().getBytes());

        return Base64.getEncoder().encodeToString(hashBytes);

    }
}
