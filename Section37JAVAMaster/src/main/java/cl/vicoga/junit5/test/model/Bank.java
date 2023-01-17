package cl.vicoga.junit5.test.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<BankAccount>accounts;

    public Bank() {
        this.accounts=new ArrayList<>();
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }
public void addAccount(BankAccount account){
        this.accounts.add(account);
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void transfer(BankAccount origin, BankAccount destiny, BigDecimal amount){
        origin.debit(amount);
        destiny.credit(amount);
    }
}
