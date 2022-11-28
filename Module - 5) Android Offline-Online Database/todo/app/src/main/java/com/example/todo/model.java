package com.example.todo;

public class model {
    public  int  id;
    public  String  title ;
    public  String  des;
    public  String  date;

    public model() {
    }

    public model(int id, String title, String des, String date) {
        this.id = id;
        this.title = title;
        this.des = des;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
