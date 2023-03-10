package Section55JAVAMaster.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Embedded
    private Audit audit = new Audit();


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "clients_addresses",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"address_id"}))
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    List<Invoice> invoices;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    DetailClient detailClient;

    public Client() {
        this.addresses = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public Client(Long id, String name, String surname, String paymentMethod) {
        this(name, surname, paymentMethod);
        this.id = id;

    }

    public Client(String name, String surname) {
        this();
        this.name = name;
        this.surname = surname;
    }

    public Client(String name, String surname, String payment) {
        this(name, surname);
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


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }


    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void addInvoice(Invoice i) {
        this.invoices.add(i);
        i.setClient(this);
    }

    public DetailClient getDetailClient() {
        return detailClient;
    }

    public void setDetailClient(DetailClient detailClient) {
        this.detailClient = detailClient;
    }

    @Override
    public String toString() {
        String c = "empty";
        String u = "empty";
        if (audit != null) {
            c = audit.getCreatedAt() != null ? audit.getCreatedAt().toString() : "empty";
            u = audit.getUpdatedAt() != null ? audit.getUpdatedAt().toString() : "empty";
        }
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", created at='" + c + '\'' +
                ", updated at='" + u + '\'' +
                ", invoices='" + this.invoices + '\'' +
                ", details='" + this.detailClient + '\'' +
                '}';
    }
}
