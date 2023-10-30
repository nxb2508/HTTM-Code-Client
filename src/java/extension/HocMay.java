/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extension;

import java.util.ArrayList;
import model.KhachHang;
import model.SoThich;
import model.SoThichKhachHang;

/**
 *
 * @author Back
 */
public class HocMay {

    public ArrayList<SoThich> getSoThichKhachHang(KhachHang kh) {
        ArrayList<SoThich> kq = new ArrayList<>();
        if (kh.getDsSoThich() != null) {
            for (SoThichKhachHang stkh : kh.getDsSoThich()) {
                kq.add(stkh.getSoThich());
            }
        }
        return kq;
    }
}
