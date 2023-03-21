package com.edu.apu.bcd.digitalsignature;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class DigitalSigner {
    private Signature sig;

    public DigitalSigner() {
        super();
        try {
            sig = Signature.getInstance("SHA256WithRSA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * sign()
     */
    public String sign(String data, PrivateKey key) throws Exception {
        sig.initSign(key);
        sig.update(data.getBytes());
        return Base64.getEncoder().encodeToString(sig.sign());
    }

    /**
     * verify()
     */
    public boolean verify(String data, String signature, PublicKey key) throws Exception {
        sig.initVerify(key);
        sig.update(data.getBytes());
        return sig.verify(Base64.getDecoder().decode(signature));
    }
}
