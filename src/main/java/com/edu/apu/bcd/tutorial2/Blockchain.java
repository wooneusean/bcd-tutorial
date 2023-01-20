package com.edu.apu.bcd.tutorial2;

import java.util.LinkedList;

public class Blockchain {
    private static final LinkedList<Block> blockList = new LinkedList<>();

    public static LinkedList<Block> getBlockList() {
        return blockList;
    }

    public static void pushTransaction(Transaction txn) {
        Block block = null;
        try {
            block = blockList.getLast();
        } catch (Exception e) {
            block = new Block("0");
            blockList.add(block);
        }

        if (block.getTransactionList().size() >= Block.MAX_TRANSACTIONS) {
            block = new Block(block.getHash());
            blockList.add(block);
        }
        block.addTransaction(txn);
        block.commit();
    }
}
