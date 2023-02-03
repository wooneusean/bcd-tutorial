package com.edu.apu.bcd.tutorial2;

import com.edu.apu.bcd.utils.Hasher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Block implements Serializable {
    public static final int MAX_TRANSACTIONS = 4;
    private final List<Transaction> transactionList = new ArrayList<>();
    private String hash;
    private String previousHash;
    private String merkleRoot;
    private long timestamp;

    public Block(String previousHash) {
        super();
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "{\"Block\":{" +
               "\"transactionList\":" + transactionList +
               ", \"merkleRoot\":\"" + merkleRoot + '\"' +
               ", \"hash\":\"" + hash + '\"' +
               ", \"previousHash\":\"" + previousHash + '\"' +
               ", \"timestamp\":" + timestamp +
               "}}";
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void addTransaction(Transaction txn) {
        if (transactionList.size() >= MAX_TRANSACTIONS) throw new RuntimeException(
                "Maximum number of transactions for this block reached. (MAX_TRANSACTIONS = " + MAX_TRANSACTIONS
        );
        this.transactionList.add(txn);
    }

    private String getMerkleRoot() {
        List<String> merkleNodes = new ArrayList<>(transactionList.stream()
                                                                  .map(txn -> Hasher.sha256(txn.getTransactionData()))
                                                                  .toList());
        while (merkleNodes.size() > 1) {
            String left = merkleNodes.remove(0);
            String right = merkleNodes.remove(0);
            merkleNodes.add(Hasher.sha256(left + right));
        }
        merkleRoot = merkleNodes.get(0);
        return merkleNodes.get(0);
    }

    public void commit() {
        this.hash = Hasher.sha256(
                String.join(
                        "+",
                        previousHash,
                        String.valueOf(timestamp),
                        getMerkleRoot()
                )
        );
    }

}
