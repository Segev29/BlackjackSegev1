package com.example.blackjacksegev;

public class HelperClass {
    String Gmail,password;

    public HelperClass(String gmail, String password) {
        Gmail = gmail;
        this.password = password;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HelperClass() {
    }
}
