package com.example.spring_backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vales")
public class Values {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tenhang")
    private String tenhang;

    @Column(name = "gia_hung")
    private Float gia_hung;

    @Column(name = "soluong")
    private Float soluong;

    @Column(name = "ngaynhap")
    private Date ngaynhap;

    @Column(name = "loaihang")
    private String loaihang;

    public Values() {
    }

    public Values(String tenhang, Float gia_hung, Float soluong, Date ngaynhap, String loaihang) {
        this.tenhang = tenhang;
        this.gia_hung = gia_hung;
        this.soluong = soluong;
        this.ngaynhap = ngaynhap;
        this.loaihang = loaihang;
    }

    public long getId() {
        return id;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public Float getGia_hung() {
        return gia_hung;
    }

    public void setGia_hung(Float gia_hung) {
        this.gia_hung = gia_hung;
    }

    public Float getSoluong() {
        return soluong;
    }

    public void setSoluong(Float soluong) {
        this.soluong = soluong;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getLoaihang() {
        return loaihang;
    }

    public void setLoaihang(String loaihang) {
        this.loaihang = loaihang;
    }

    @Override
    public String toString() {
        return "Values{" +
                "id=" + id +
                ", tenhang='" + tenhang + '\'' +
                ", gia_hung=" + gia_hung +
                ", soluong=" + soluong +
                ", ngaynhap=" + ngaynhap +
                ", loaihang='" + loaihang + '\'' +
                '}';
    }
}