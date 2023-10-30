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
public class SoThich {
    int id;
    String ten;
    ArrayList<SoThichSanPham> dsSanPham;

    public SoThich() {
        dsSanPham = new ArrayList<>();
    }

    public SoThich(int id, String ten, ArrayList<SoThichSanPham> dsSanPham) {
        this.id = id;
        this.ten = ten;
        this.dsSanPham = dsSanPham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public ArrayList<SoThichSanPham> getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham(ArrayList<SoThichSanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }
    
    
    
}
