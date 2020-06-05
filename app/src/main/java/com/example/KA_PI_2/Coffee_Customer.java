package com.example.KA_PI_2;

public class Coffee_Customer {
    String beang;
    int degree;
    int time;
    int Temperature;
    int water;

    public Coffee_Customer(String beang, int degree, int time, int Temperature, int water) {
        this.beang = beang;
        this.degree = degree;
        this.time = time;
        this.Temperature = Temperature;
        this.water = water;
    }


    @Override
    public String toString() {
        return "Coffee_Customer{" +
                "beantype='" + beang + '\'' +
                ", degree=" + degree +
                ", time=" + time +
                ", temp=" + Temperature +
                ", beang=" + beang +
                ", water=" + water +
                '}';
    }

    public String getBeang() {
        return beang;
    }

    public void setBeantype(String beang) {
        this.beang = beang;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTemp() {
        return Temperature;
    }

    public void setTemp(int Temperature) {
        this.Temperature = Temperature;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }
}
