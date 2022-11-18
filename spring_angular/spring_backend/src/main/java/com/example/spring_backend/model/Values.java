package com.example.spring_backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vales")
public class Values {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tenhang_hung")
    private String tenhang_hung;

    @Column(name = "gia")
    private Float gia;

    @Column(name = "soluong")
    private Float soluong;

    @Column(name = "ngaynhap")
    private Date ngaynhap;

    @Column(name = "loaihang")
    private String loaihang;

    public Values() {
    }

    public Values(String tenhang_hung, Float gia, Float soluong, Date ngaynhap, String loaihang) {
        this.tenhang_hung = tenhang_hung;
        this.gia = gia;
        this.soluong = soluong;
        this.ngaynhap = ngaynhap;
        this.loaihang = loaihang;
    }

    public long getId() {
        return id;
    }

    public String getTenhang_hung() {
        return tenhang_hung;
    }

    public void setTenhang_hung(String tenhang_hung) {
        this.tenhang_hung = tenhang_hung;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
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
                ", tenhang_hung='" + tenhang_hung + '\'' +
                ", gia=" + gia +
                ", soluong=" + soluong +
                ", ngaynhap=" + ngaynhap +
                ", loaihang='" + loaihang + '\'' +
                '}';
    }
}