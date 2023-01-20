package com.edu.apu.bcd.tutorial2;

public class Tutorial2 {


    public static void main(String[] args) {
        // Block max transactions set to 3

        // Block #0
        Blockchain.pushTransaction(new Transaction("alice", "bob", "USD 200"));
        Blockchain.pushTransaction(new Transaction("carol", "bob", "USD 100"));
        Blockchain.pushTransaction(new Transaction("bob", "alice", "USD 200"));

        // Block #1
        Blockchain.pushTransaction(new Transaction("bob", "carol", "USD 50"));
        Blockchain.pushTransaction(new Transaction("dennis", "bob", "USD 20"));
        Blockchain.pushTransaction(new Transaction("ethan", "jacob", "USD 450"));

        // Block #2
        Blockchain.pushTransaction(new Transaction("bob", "alice", "USD 200"));

        System.out.println(Blockchain.getBlockList());
    }
}
