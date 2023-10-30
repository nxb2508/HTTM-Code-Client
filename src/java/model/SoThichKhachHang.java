/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Back
 */
public class SoThichKhachHang {
    int id;
    SoThich soThich;

    public SoThichKhachHang(int id, SoThich soThich) {
        this.id = id;
        this.soThich = soThich;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SoThich getSoThich() {
        return soThich;
    }

    public void setSoThich(SoThich soThich) {
        this.soThich = soThich;
    }
    

    public SoThichKhachHang() {
    }
}
