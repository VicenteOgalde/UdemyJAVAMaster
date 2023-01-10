package cl.vicoga.api.stream.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String name;
    private String nick;

    private List<Invoice> invoices;

    public User() {
        this.invoices= new ArrayList<>();
    }

    public User(String name) {
        this();

        this.name = name;
    }

    public User(String name, String nick) {
        this(name);

        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {

        this.invoices.add(invoice);

        invoice.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(nick, user.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nick);
    }
}
