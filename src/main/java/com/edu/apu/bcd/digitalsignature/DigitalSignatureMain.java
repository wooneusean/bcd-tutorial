package com.edu.apu.bcd.digitalsignature;

import com.edu.apu.bcd.encryption.asymmetric.keygenerators.AsymmetricKeyPairGenerator;

import java.security.KeyPair;
import java.util.Base64;

public class DigitalSignatureMain {
    public static void main(String[] args) throws Exception {
        KeyPair lkp = AsymmetricKeyPairGenerator.load("keys");
        System.out.println("Private key: " + Base64.getEncoder().encodeToString(lkp.getPrivate().getEncoded()));
        System.out.println("Public key: " + Base64.getEncoder().encodeToString(lkp.getPublic().getEncoded()));

        DigitalSigner sig = new DigitalSigner();
        String creditData = "alice|bob|credit|100.0";
        String creditSignature = sig.sign(creditData, lkp.getPrivate());
        System.out.println(creditData + "|" + creditSignature);

        String debitData = "alice|bob|debit|200.0";
        String debitSignature = sig.sign(debitData, lkp.getPrivate());
        System.out.println(debitData + "|" + debitSignature);

//        boolean isValid = sig.verify(data, signature, lkp.getPublic());
//        System.out.println("isValid: " + isValid);
    }
}
