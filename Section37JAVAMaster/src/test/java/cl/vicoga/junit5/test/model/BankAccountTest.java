package cl.vicoga.junit5.test.model;

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

        BankAccount account2 = new BankAccount("j7ohn", new BigDecimal("1000.123"));

//        assertNotEquals(account,account2);
        assertEquals(account,account2);


    }
}