package com.infoshare.payments;

public class Employee {
    private String name;
    private int payment;

    public Employee(String name, int payment) {
        this.name = name;
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }

    public String getName() {
        return name;
    }
}
