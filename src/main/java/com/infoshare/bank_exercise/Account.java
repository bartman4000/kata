package com.infoshare.bank_exercise;

public class Account {

    private final Printer printer;
    private final TransactionRepository transactionRepository;
    private final Calendar calendar;

    public Account(Printer printer, TransactionRepository transactionRepository, Calendar calendar) {
        this.printer = printer;
        this.transactionRepository = transactionRepository;
        this.calendar = calendar;
    }

    public void deposit(int value) {
        createAndStoreTransaction(value);
    }

    public void withdrawal(int value) {
        checkBalance(value);
        createAndStoreTransaction(-value);
    }

    private void checkBalance(int value) {
        if (getBalance() < value)
            throw new IllegalStateException("There is not enough money on the account");
    }

    private void createAndStoreTransaction(int value) {
        transactionRepository.add(new Transaction(value, calendar.today()));
    }

    public void printStatement() {
        printer.printHeader();

        int balance = 0;
        for (Transaction transaction : transactionRepository.getAll()) {
            balance += transaction.getAmount();
            printer.printTransaction(transaction, balance);
        }
    }

    public int getBalance() {
        int balance = 0;
        for (Transaction transaction : transactionRepository.getAll()) {
            balance += transaction.getAmount();
        }
        return balance;
    }
}
