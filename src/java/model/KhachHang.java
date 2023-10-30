/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Back
 */
public class KhachHang {
    int id;
    String taiKhoan, matKhau, hoTen, soDienThoai, diaChi;
    
    ArrayList<SoThichKhachHang> dsSoThich;
    
    public KhachHang() {
    }

    public KhachHang(int id, String taiKhoan, String matKhau, String hoTen, String soDienThoai, String diaChi, ArrayList<SoThichKhachHang> dsSoThich) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.dsSoThich = dsSoThich;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ArrayList<SoThichKhachHang> getDsSoThich() {
        return dsSoThich;
    }

    public void setDsSoThich(ArrayList<SoThichKhachHang> dsSoThich) {
        this.dsSoThich = dsSoThich;
    }
    
    
    
}
