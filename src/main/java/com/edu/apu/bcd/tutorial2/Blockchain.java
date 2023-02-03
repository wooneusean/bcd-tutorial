package com.edu.apu.bcd.tutorial2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.LinkedList;

public class Blockchain {
    private static LinkedList<Block> blockList = new LinkedList<>();

    private static String file;

    private static Block currentBlock;

    public static String getFile() {
        return file;
    }

    public static void setFile(String file) {
        Blockchain.file = file;
    }

    public static LinkedList<Block> getBlockList() {
        return blockList;
    }

    public static void pushTransaction(Transaction txn) {
        try {
            currentBlock = blockList.getLast();
        } catch (Exception e) {
            currentBlock = new Block("0");
            blockList.add(currentBlock);
        }

        if (currentBlock.getTransactionList().size() >= Block.MAX_TRANSACTIONS) {
            currentBlock.commit();
            currentBlock = new Block(currentBlock.getHash());
            blockList.add(currentBlock);
        }
        currentBlock.addTransaction(txn);
    }

    public static void load() {
        try (FileInputStream f = new FileInputStream(file);
             ObjectInputStream o = new ObjectInputStream(f)) {
            blockList = (LinkedList<Block>) o.readObject();
            System.out.println("Read from file");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void persist() {
        currentBlock.commit();
        try (FileOutputStream f = new FileOutputStream(file);
             ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(blockList);
            System.out.println("Saved to file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void distribute() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(Blockchain.getBlockList().toString());
        System.out.println(gson.toJson(je));
    }
}
