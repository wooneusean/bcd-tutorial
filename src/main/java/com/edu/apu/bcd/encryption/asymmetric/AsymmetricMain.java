package com.edu.apu.bcd.encryption.asymmetric;

import com.edu.apu.bcd.encryption.asymmetric.keygenerators.AsymmetricKeyPairGenerator;
import com.edu.apu.bcd.encryption.symmetric.SymmetricEncryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.util.Base64;

public class AsymmetricMain {
    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
//        KeyPair kp = AsymmetricKeyPairGenerator.generate();
//        System.out.println("Private key: " + Base64.getEncoder().encodeToString(kp.getPrivate().getEncoded()));
//        System.out.println("Public key: " + Base64.getEncoder().encodeToString(kp.getPublic().getEncoded()));
//        AsymmetricKeyPairGenerator.save(kp, "keys");


        KeyPair lkp = AsymmetricKeyPairGenerator.load("keys");
        System.out.println("Private key: " + Base64.getEncoder().encodeToString(lkp.getPrivate().getEncoded()));
        System.out.println("Public key: " + Base64.getEncoder().encodeToString(lkp.getPublic().getEncoded()));

        AsymmetricEncryptor se = new AsymmetricEncryptor("RSA");
        String cipher = se.encrypt("lorem ipsum dolor sit amet", lkp.getPublic());
        System.out.println(cipher);
        String plain = se.decrypt(cipher, lkp.getPrivate());
        System.out.println(plain);
    }
}
