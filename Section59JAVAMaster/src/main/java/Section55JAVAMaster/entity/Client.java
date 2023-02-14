package Section55JAVAMaster.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private String surname;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Embedded
    private Audit audit=new Audit();

    private List<Address> addresses= new ArrayList<>();



    public Client() {
    }

    public Client(Long id, String name, String surname, String paymentMethod) {
        this(name,surname,paymentMethod);
        this.id = id;

    }

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Client(String name, String surname, String payment) {
        this(name,surname);
        this.paymentMethod = payment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        String c=audit!=null?audit.getCreatedAt().toString():"empty";
        String u=audit!=null?audit.getUpdatedAt().toString():"empty";
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", created at='"+c+'\''+
                ", updated at='"+u+'\''+
                '}';
    }
}
