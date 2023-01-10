package cl.vicoga.api.stream.model;

public class Invoice {

    private String desc;
    private User user;

    public Invoice() {
    }

    public Invoice(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
