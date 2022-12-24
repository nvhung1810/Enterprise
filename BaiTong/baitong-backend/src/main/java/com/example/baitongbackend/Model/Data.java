package com.example.baitongbackend.Model;

import javax.persistence.*;

@Entity
@Table(name = "quanlygiangvien")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long magv;

    @Column(name = "hoten")
    private String hoten;

    @Column(name = "tenbomon")
    private String tenbomon;

    @Column(name = "hesoluong")
    private Float hesoluong;

    public Data(String hoten, String tenbomon, Float hesoluong) {
        this.hoten = hoten;
        this.tenbomon = tenbomon;
        this.hesoluong = hesoluong;
    }

    public Data() {

    }

    public long getMagv() {
        return magv;
    }

    public void setMagv(long magv) {
        this.magv = magv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getTenbomon() {
        return tenbomon;
    }

    public void setTenbomon(String tenbomon) {
        this.tenbomon = tenbomon;
    }

    public Float getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(Float hesoluong) {
        this.hesoluong = hesoluong;
    }

    @Override
    public String toString() {
        return "Data{" +
                "magv=" + magv +
                ", hoten='" + hoten + '\'' +
                ", tenbomon='" + tenbomon + '\'' +
                ", hesoluong=" + hesoluong +
                '}';
    }
}