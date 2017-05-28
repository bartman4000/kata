package com.infoshare.payments;

public interface MailSender {
    void sendEmail(String message, String emailAddress);
}
