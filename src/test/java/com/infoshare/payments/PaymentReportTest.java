package com.infoshare.payments;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PaymentReportTest {

    @Test
    public void should_send_mail_with_total_payment() {
        // given
        MailSender sender = mock(MailSender.class);

        EmployeeRepository repository = mock(EmployeeRepository.class);
        List<Employee> employees = Lists.newArrayList(new Employee("Bob", 2300),
                new Employee("John", 1200));
        when(repository.getAll()).thenReturn(employees);

        // when
        new PaymentReport(sender, repository).generate();

        // then
        verify(sender).sendEmail(eq("Total payment: " + 3500), anyString());
    }

}