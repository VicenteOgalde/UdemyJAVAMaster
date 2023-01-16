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

}