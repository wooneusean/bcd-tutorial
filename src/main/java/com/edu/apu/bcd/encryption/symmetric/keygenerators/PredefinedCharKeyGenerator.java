package com.edu.apu.bcd.encryption.symmetric.keygenerators;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;

public class PredefinedCharKeyGenerator {
    private static final String SECRET_CHARS = "Sm4g5ZZh#sNdfU2UD6^mk6!%H5KJd@MQcHmB5Ct3ntVZnkW8XsTXZYk&xSwVh!JfRj^V7K!kCz&5vAG#T8u%aJ8gCMB7RCfT6YQR2sz5ishXQA*N%Ymk3gXQN#9Z##*V";

    public static Key create() {
        return new SecretKeySpec(Arrays.copyOf(SECRET_CHARS.getBytes(), 32), "AES");
    }
}
