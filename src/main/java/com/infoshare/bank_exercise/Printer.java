package com.infoshare.bank_exercise;

public interface Printer {

    void printHeader();

    void printTransaction(Transaction transaction, int balance);
}
