package Section55JAVAMaster.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

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
