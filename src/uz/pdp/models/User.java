package uz.pdp.models;

import static uz.pdp.utils.BaseUtil.generateUniqueID;

public class User {
    private String userName;
    private String password;
    private String id=generateUniqueID();
    private boolean admin;
    private int mashinalari =0;

    public int getMashinalari() {
        return mashinalari;
    }

    public void setMashinalari(int mashinalari) {
        this.mashinalari = mashinalari;
    }


    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public User(String nomi, String password) {
        this.userName = nomi;
        this.password = password;
    }
}
