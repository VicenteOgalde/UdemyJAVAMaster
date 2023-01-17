package cl.vicoga.junit5.test.model;

import java.math.BigDecimal;
import java.util.Objects;

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

    public void debit(BigDecimal amount){

        this.balance=this.balance.subtract(amount);
    }
    public void credit(BigDecimal amount){
        this.balance=this.balance.add(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount account = (BankAccount) o;
        return Objects.equals(name, account.name) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }
}
