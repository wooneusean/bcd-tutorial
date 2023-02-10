package com.edu.apu.bcd.encryption.symmetric;

import com.edu.apu.bcd.encryption.symmetric.keygenerators.PredefinedCharKeyGenerator;
import com.edu.apu.bcd.encryption.symmetric.keygenerators.RandomizedSecretKeyGenerator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class SymmetricMain {
    public static void main(String[] args) throws
                                           IllegalBlockSizeException,
                                           BadPaddingException,
                                           InvalidKeyException,
                                           InterruptedException {
        SymmetricEncryptor enc = new SymmetricEncryptor();

        String message = "There is RM 20 million under the swimming pool in Najib's house";

        Key secretKey = PredefinedCharKeyGenerator.create();
        System.out.println("Encrypting '" + message + "' with secret key: " +
                           Base64.getEncoder().encodeToString(secretKey.getEncoded()));
        String ciphertext = enc.encrypt(message, secretKey);
        System.out.println(ciphertext);
        System.out.println("Decrypting '" + ciphertext + "' with secret key: " +
                           Base64.getEncoder().encodeToString(secretKey.getEncoded()));
        String plaintext = enc.decrypt(ciphertext, secretKey);
        System.out.println(plaintext);

        TimeUnit.SECONDS.sleep(5);

        Key randomSecretKey = RandomizedSecretKeyGenerator.create();
        System.out.println(
                "Encrypting '" + message + "' with secret key: " +
                Base64.getEncoder().encodeToString(randomSecretKey.getEncoded()));
        ciphertext = enc.encrypt(message, randomSecretKey);
        System.out.println(ciphertext);
        System.out.println("Decrypting '" + ciphertext + "' with secret key: " +
                           Base64.getEncoder().encodeToString(randomSecretKey.getEncoded()));
        plaintext = enc.decrypt(ciphertext, randomSecretKey);
        System.out.println(plaintext);

        // decode the base64 encoded string
        byte[] decodedKey = Base64.getDecoder().decode("YXNkZHNhcXdlZXdxcGJubQ==");
        // rebuild key using SecretKeySpec
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        plaintext = enc.decrypt("M3hwGPVCBcz1AEogO77ppg==", originalKey);
        System.out.println(plaintext);
    }
}
