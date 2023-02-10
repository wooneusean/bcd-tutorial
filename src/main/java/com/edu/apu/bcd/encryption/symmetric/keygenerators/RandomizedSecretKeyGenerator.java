package com.edu.apu.bcd.encryption.symmetric.keygenerators;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class RandomizedSecretKeyGenerator {
    public static SecretKey create() {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(256, new SecureRandom());
            return kg.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
