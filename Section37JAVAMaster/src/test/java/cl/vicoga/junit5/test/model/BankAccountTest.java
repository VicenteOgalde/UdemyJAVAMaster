package cl.vicoga.junit5.test.model;

import cl.vicoga.junit5.test.Exception.NoCreditException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount account;
    BankAccount account2;
    @BeforeEach
    void testMethodInit(){

        this.account = new BankAccount("tex", new BigDecimal("1000.523"));
        this.account2 =new BankAccount("john", new BigDecimal("1000.123"));
    }
    @Test
    void testAccountName() {
        account = new BankAccount("tex", new BigDecimal("1000.523"));
//        account.setName("tex");
        String okName = "tex";
        String real = account.getName();

        assertEquals(okName, real,()->"Must be the same name");


    }

    @Test
    void testBalance() {
        account = new BankAccount("tex", new BigDecimal("1000.123"));
        assertEquals(1000.123, account.getBalance().doubleValue());
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    void testAccountReference() {
        account = new BankAccount("john", new BigDecimal("1000.123"));

        account2 = new BankAccount("john", new BigDecimal("1000.123"));

//        assertNotEquals(account,account2);
        assertEquals(account, account2);


    }

    @Test
    void testDebitAccount() {
        account = new BankAccount("tex", new BigDecimal("1000.123"));

        account.debit(new BigDecimal(100));

        assertEquals(900, account.getBalance().intValue());

        assertEquals("900.123", account.getBalance().toPlainString());


    }

    @Test
    void testCreditAccount() {
        account = new BankAccount("tex", new BigDecimal("1000.123"));

        account.credit(new BigDecimal(100));

        assertEquals(1100, account.getBalance().intValue());

        assertEquals("1100.123", account.getBalance().toPlainString());


    }

    @Test
    @DisplayName("Testing name account")
    void NoCreditException() {
        account = new BankAccount("tex", new BigDecimal("1000.123"));

        Exception e = assertThrows(NoCreditException.class,
                () -> {
                    account.debit(new BigDecimal("1200.231"));

                });
        assertEquals("not enough funds", e.getMessage());
    }

    @Test
    @DisplayName("Test money transfer")
    void testTransferMoney() {
        account = new BankAccount("tex", new BigDecimal("1000.123"));
        account2 = new BankAccount("tex", new BigDecimal("5000.123"));

        Bank bank = new Bank();
        bank.transfer(account, account2, new BigDecimal("800.123"));

        assertEquals(account.getBalance().toPlainString(), "200.000");
        assertEquals(account2.getBalance().toPlainString(), "5800.246");

    }

    @Test
    @Disabled
    void testBankAccountsRelationship() {
        fail();
        account = new BankAccount("tex", new BigDecimal("1000.123"));
        account2 = new BankAccount("tox", new BigDecimal("5000.123"));

        Bank bank = new Bank();
        bank.setName("b1");
        bank.addAccount(account);
        bank.addAccount(account2);
        bank.transfer(account, account2, new BigDecimal("800.123"));

        assertAll(
                () -> {
                    assertEquals(2, bank.getAccounts().size(),()->"not the same size");
                }, () -> {
                    assertEquals("tex", bank.getAccounts().stream()
                            .filter(a -> a.getName().equals("tex")).findFirst().get().getName(),()->"not exist that name");
                }, () -> {
                    assertEquals("b1", account.getBank().getName(),()->"not the same name");
                }
        );

        assertEquals(2, bank.getAccounts().size());
        assertEquals("b1", account.getBank().getName());

        assertEquals("tex", bank.getAccounts().stream()
                .filter(a -> a.getName().equals("tex")).findFirst().get().getName());

        assertTrue(bank.getAccounts().stream()
                .anyMatch(a -> a.getName().equals("tex")));

        assertEquals(account.getBalance().toPlainString(), "200.000");
        assertEquals(account2.getBalance().toPlainString(), "5800.246");

    }
}