package com.edu.apu.bcd.tutorial1;

import com.edu.apu.bcd.utils.Hasher;

public class Tutorial1 {
    public static void main(String[] args) {
        byte[] salt = Hasher.getSalt(32);

        System.out.println(Hasher.md5("123456", salt));
        System.out.println(Hasher.sha256("123456", salt));
        System.out.println(Hasher.sha384("123456", salt));
        System.out.println(Hasher.sha512("123456", salt));

        System.out.println(Hasher.md5("123456", salt));
        System.out.println(Hasher.sha256("123456", salt));
        System.out.println(Hasher.sha384("123456", salt));
        System.out.println(Hasher.sha512("123456", salt));
    }
}
