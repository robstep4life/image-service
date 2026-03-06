package com.example.imageservice.model;

public class ServiceTime {

    private String day;
    private String time;
    private String detail;

    public ServiceTime(String day, String time, String detail) {
        this.day = day;
        this.time = time;
        this.detail = detail;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getDetail() {
        return detail;
    }
}