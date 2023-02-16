package Section55JAVAMaster.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "details_clients")
public class DetailClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean prime;
    private Long points;
@OneToOne
 private Client client;

    public DetailClient() {
    }

    public DetailClient(boolean prime, Long points) {
        this.prime = prime;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "DetailClient{" +
                "id=" + id +
                ", prime=" + prime +
                ", points=" + points +
                '}';
    }
}
