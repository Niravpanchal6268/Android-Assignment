package com.example.dailyexpensetracker;

public class model {
    public  int id;
    public  int expence;
    public  String title;
    public String description;
    public  String date;

    public model(String string, int anInt, String cursorString, String description, String date) {
    }



    public model(int id, int expence, String title, String description, String date) {
        this.id = id;
        this.expence = expence;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpence() {
        return expence;
    }

    public void setExpence(int expence) {
        this.expence = expence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
