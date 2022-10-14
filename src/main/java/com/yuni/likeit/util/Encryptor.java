package com.yuni.likeit.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Encryptor {
    public String passwordToSha256(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            return bytesToHex(md.digest());
        }
        catch(NoSuchAlgorithmException e) {
            return "CANNOT_ENCRYPT";
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for(byte eachByte : bytes)
            sb.append(String.format("%02x", eachByte));

        return sb.toString();
    }
}
