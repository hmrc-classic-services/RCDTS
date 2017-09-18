package Model;

import java.util.HashMap;

public class User {

    private final String uniqueId;
    private String username;
    private double credit;

    public User(String uniqueId, String username) {
        this.uniqueId = uniqueId;
        this.username = username;
        this.credit = 0;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void addCredit(double credit) { this.credit += credit;}
}
