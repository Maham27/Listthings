package com.example.listthings;

public class listinfo {
    String name,date,time,p,s;

    public listinfo() {
    }

    public listinfo(String name, String date, String time,String p,String s) {
        this.name = name;
        this.date=date;
        this.time=time;
        this.p=p;
        this.s=s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "listinfo{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", p='" + p + '\'' +
                ", s='" + s + '\'' +
                '}';
    }
}


