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
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


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

    @PrePersist
    public void prePersist(){
        System.out.println("init before persist");
        this.createdAt=LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        System.out.println("init before Update");
        this.updatedAt=LocalDateTime.now();
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", created at='"+createdAt+'\''+", updated at='"+updatedAt+'\''+
                '}';
    }
}
