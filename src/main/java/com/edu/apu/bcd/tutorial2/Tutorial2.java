package com.edu.apu.bcd.tutorial2;

public class Tutorial2 {


    public static void main(String[] args) {
        Blockchain.setFile("block.bin");
//        Blockchain.load();

        Blockchain.pushTransaction(new Transaction("mark", "spencer", "USD 1490"));
        Blockchain.pushTransaction(new Transaction("john", "doe", "USD 250"));
        Blockchain.pushTransaction(new Transaction("henry", "mary", "USD 125"));
        Blockchain.pushTransaction(new Transaction("swag", "lord", "USD 150"));
        Blockchain.pushTransaction(new Transaction("clark", "spencer", "USD 670"));
        Blockchain.pushTransaction(new Transaction("shark", "cancer", "USD 650"));
        Blockchain.pushTransaction(new Transaction("ark", "fencer", "USD 450"));

        Blockchain.persist();

        Blockchain.distribute();
    }
}
