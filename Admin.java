package model;

public class Admin extends User {
    public Admin(String id, String password, String name) {
        super(id, password, name);
    }
     @Override
    public String getRole() {
        return "ADMIN";
    }
}