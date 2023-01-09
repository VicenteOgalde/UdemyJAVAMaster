package cl.vicoga.api.stream.model;

public class User {

    private String name;
    private String nick;


    public User(String name) {
        this.name = name;
    }

    public User(String name, String nick) {
        this.name = name;
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
}
