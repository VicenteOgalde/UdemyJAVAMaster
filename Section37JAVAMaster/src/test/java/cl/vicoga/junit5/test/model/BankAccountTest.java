package cl.vicoga.junit5.test.model;

import cl.vicoga.junit5.test.Exception.NoCreditException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testAccountName(){
        BankAccount account= new BankAccount("tex",new BigDecimal("1000.523"));
//        account.setName("tex");
        String okName="tex";
        String real=account.getName();

        assertEquals(okName,real);



    }
    @Test
    void testBalance(){
        BankAccount account = new BankAccount("tex", new BigDecimal("1000.123"));
        assertEquals(1000.123,account.getBalance().doubleValue());
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO)<0);
    }

    @Test
    void testAccountReference() {
        BankAccount account = new BankAccount("john", new BigDecimal("1000.123"));

        BankAccount account2 = new BankAccount("john", new BigDecimal("1000.123"));

//        assertNotEquals(account,account2);
        assertEquals(account,account2);


    }

    @Test
    void testDebitAccount() {
        BankAccount account = new BankAccount("tex", new BigDecimal("1000.123"));

        account.debit(new BigDecimal(100));

        assertEquals(900,account.getBalance().intValue());

        assertEquals("900.123",account.getBalance().toPlainString());


    }
    @Test
    void testCreditAccount() {
        BankAccount account = new BankAccount("tex", new BigDecimal("1000.123"));

        account.credit(new BigDecimal(100));

        assertEquals(1100,account.getBalance().intValue());

        assertEquals("1100.123",account.getBalance().toPlainString());


    }

    @Test
    void NoCreditException() {
        BankAccount account = new BankAccount("tex", new BigDecimal("1000.123"));

        Exception e= assertThrows(NoCreditException.class,
                ()->{
            account.debit(new BigDecimal("1200.231"));

                });
        assertEquals("not enough funds",e.getMessage());
    }
}