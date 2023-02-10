package com.edu.apu.bcd.encryption.symmetric;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SymmetricEncryptor {
    private Cipher cipher;

    public SymmetricEncryptor(String algorithm) {
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public SymmetricEncryptor() {
        this("AES");
    }

    public String encrypt(String plaintext, Key key) throws
                                                     InvalidKeyException,
                                                     IllegalBlockSizeException,
                                                     BadPaddingException {
        String ciphertext;

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherBytes = cipher.doFinal(plaintext.getBytes());
        ciphertext = Base64.getEncoder().encodeToString(cipherBytes);

        return ciphertext;
    }

    public String decrypt(String ciphertext, Key key) throws
                                                      InvalidKeyException,
                                                      IllegalBlockSizeException,
                                                      BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));

        return new String(plainBytes);
    }
}
