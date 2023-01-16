package cl.vicoga.junit5.test.model;

import java.math.BigDecimal;

public class BankAccount {

    private String name;
    private BigDecimal balance;

    public BankAccount(String name,BigDecimal balance) {
        this.balance = balance;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
