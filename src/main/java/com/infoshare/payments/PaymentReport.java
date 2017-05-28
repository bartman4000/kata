package com.infoshare.payments;

import java.util.List;

public class PaymentReport {

    private MailSender mailSender;
    private EmployeeRepository employeeRepository;

    public PaymentReport(MailSender mailSender, EmployeeRepository employeeRepository) {
        this.mailSender = mailSender;
        this.employeeRepository = employeeRepository;
    }

    public void generate() {
        List<Employee> all = employeeRepository.getAll();

        int totalPayment = 0;
        for (Employee employee : all) {
            totalPayment += employee.getPayment();
        }

        mailSender.sendEmail("Total payment: " + totalPayment, "hr@company.com");
    }
}
