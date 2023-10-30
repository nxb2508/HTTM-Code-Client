/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Back
 */
public class HoaDon {
    int id;
    Date ngayMua;
    double tongTien;
    String ghiChu;
    KhachHang khachHang;
    ArrayList<SanPhamDaMua> dsSanPhamDaMua;

    public HoaDon() {
    }

    public HoaDon(int id, Date ngayMua, double tongTien, String ghiChu, KhachHang khachHang, ArrayList<SanPhamDaMua> dsSanPhamDaMua) {
        this.id = id;
        this.ngayMua = ngayMua;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.khachHang = khachHang;
        this.dsSanPhamDaMua = dsSanPhamDaMua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public ArrayList<SanPhamDaMua> getDsSanPhamDaMua() {
        return dsSanPhamDaMua;
    }

    public void setDsSanPhamDaMua(ArrayList<SanPhamDaMua> dsSanPhamDaMua) {
        this.dsSanPhamDaMua = dsSanPhamDaMua;
    }
    
}
