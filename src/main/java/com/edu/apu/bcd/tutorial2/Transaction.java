package com.edu.apu.bcd.tutorial2;

public class Transaction {
    private String from;
    private String to;
    private String data;

    public Transaction(String from, String to, String data) {
        this.from = from;
        this.to = to;
        this.data = data;
    }

    @Override
    public String toString() {
        return "{\"Transaction\":{" +
               "\"from\":\"" + from + '\"' +
               ", \"to\":\"" + to + '\"' +
               ", \"data\":\"" + data + '\"' +
               "}}";
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHashData() {
        return from + to + data;
    }
}
