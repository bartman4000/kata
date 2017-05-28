package com.infoshare.bank_exercise;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Equals;
import static org.hamcrest.core.IsEqual.equalTo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static sun.nio.cs.Surrogate.is;

/**
 *  1. Stwórz dummy object dla daty oraz mocki dla zależności.
 *  2. Niech mock klasy Calendar zawsze zwraca w metodzie today() wcześniej stworzony dummy object.
 *  3. Zaimplementuj wszystkie testy, pamiętaj o testowaniu jednego przypadku w jednej metodzie.
 */
public class AccountTest {

    private Printer mockPrinter;
    private TransactionRepository mockRepository;
    private Calendar mockCalendar;
    private Account account;
    private LocalDate today;

    @Before
    public void initialize_mocks()
    {
        mockPrinter = mock(Printer.class);
        mockRepository = mock(TransactionRepository.class);
        mockCalendar = mock(Calendar.class);
        account = new Account(mockPrinter, mockRepository, mockCalendar);
        today = LocalDate.of(2017,3,24);
        when(mockCalendar.today()).thenReturn(today);
    }

    @Test
    public void should_print_only_header_statement_for_empty_account() {

        //when
        account.printStatement();

        //then
        verify(mockPrinter).printHeader();
        verify(mockPrinter, never()).printTransaction(any(Transaction.class),anyInt());
    }

    @Test
    public void should_create_500_deposit_transaction() {

        //when
        account.deposit(500);

        //then
        verify(mockRepository, times(1)).add(new Transaction(500,mockCalendar.today()));
    }

    @Test
    public void should_balance_equals_500_for_single_deposit_transaction() {

        //given
        Transaction transaction = new Transaction(500,today);
        when(mockRepository.getAll()).thenReturn(new ArrayList<Transaction>(Arrays.asList(transaction)));

        //when
        account.deposit(500);

        //then
        assertThat(account.getBalance(), equalTo(500));
    }

    @Test(expected = IllegalStateException.class)
    public void should_throw_exception_for_withdraw_when_there_is_not_enough_money() {

        account.withdrawal(1000);

    }

    @Test
    public void should_create_withdraw_transaction() {

        //given
        Transaction transaction = new Transaction(500,today);
        when(mockRepository.getAll()).thenReturn(new ArrayList<Transaction>(Arrays.asList(transaction)));
        account.deposit(transaction.getAmount());

        //when
        account.withdrawal(100);

        //then
        verify(mockRepository, times(1)).add(new Transaction(-100,mockCalendar.today()));

    }

    @Test
    public void should_balance_equals_500_after_withdraw_transaction() {

        //given
        Transaction transaction = new Transaction(600,today);
        Transaction transaction2 = new Transaction(-100,today);
        when(mockRepository.getAll()).thenReturn(new ArrayList<Transaction>(Arrays.asList(transaction,transaction2)));

        //when
        account.withdrawal(100);

        //then
        verify(mockRepository, times(1)).add(transaction2);
        assertThat(account.getBalance(), equalTo(500));

    }

    @Test
    public void should_print_single_transaction_from_transactionRepository() {

        //given
        Transaction transaction = new Transaction(100,today);
        when(mockRepository.getAll()).thenReturn(new ArrayList<Transaction>(Arrays.asList(transaction)));

        //when
        account.printStatement();

        //then
        verify(mockPrinter).printHeader();
        verify(mockRepository).getAll();
        verify(mockPrinter, times(1)).printTransaction(any(Transaction.class),anyInt());
    }

    @Test
    public void should_print_multiple_transactions_from_transactionRepository() {
        //given
        Transaction transaction = new Transaction(100,today);
        Transaction transaction2 = new Transaction(200,today);
        when(mockRepository.getAll()).thenReturn(new ArrayList<Transaction>(Arrays.asList(transaction,transaction2)));

        //when
        account.printStatement();

        //then
        verify(mockPrinter).printHeader();
        verify(mockRepository).getAll();
        verify(mockPrinter, atLeast(2)).printTransaction(any(Transaction.class),anyInt());
    }
}