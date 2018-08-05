package com.example.vanluc.buoi8;

public class Info {
    private int userID;
    private int id;
    private String tittle;

    public Info() {
    }

    private String body;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Info(int userID, int id, String tittle, String body) {

        this.userID = userID;
        this.id = id;
        this.tittle = tittle;
        this.body = body;
    }


}
