/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;
import model.SoThich;
import model.SoThichKhachHang;
import model.SoThichSanPham;

/**
 *
 * @author Back
 */
public class SoThichKhachHangDAO extends DAO {

    public ArrayList<SoThichKhachHang> getDSSTKHTheoDSIdSoThich(ArrayList<Integer> dsIdSoThich) {
        ArrayList<SoThichKhachHang> kq = new ArrayList<>();
        String idSoThichStr = "";
        for (Integer temp : dsIdSoThich) {
            idSoThichStr += temp + ", ";
        }
        idSoThichStr = idSoThichStr.substring(0, idSoThichStr.length() - 2);
        String sql = "select * from tblsothich where id in (" + idSoThichStr + ")";
        System.out.println(sql);
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SoThichKhachHang soThichKhachHang = new SoThichKhachHang();
                SoThich soThich = new SoThich();
                int idSoThich = rs.getInt(1);
                soThich.setId(idSoThich);
                soThich.setTen(rs.getString(2));
                ArrayList<SoThichSanPham> dsSTSP = new ArrayList<>();
                String sqlSTSP = "select stsp.id as stspID, sp.id, sp.ten, sp.linkAnh, sp.moTa, sp.gia from tblsanpham as sp "
                        + "join tblsothichsanpham as stsp "
                        + "where stsp.idSanPham = sp.id "
                        + "and stsp.idSoThich = " + idSoThich;
                PreparedStatement stmSTSP = conn.prepareStatement(sqlSTSP);
                ResultSet rsSTSP = stmSTSP.executeQuery();
                while (rsSTSP.next()) {
                    SoThichSanPham soThichSanPham = new SoThichSanPham();
                    soThichSanPham.setId(rsSTSP.getInt(1));
                    SanPham sanPham = new SanPham();
                    sanPham.setId(rsSTSP.getInt(2));
                    sanPham.setTen(rsSTSP.getString(3));
                    sanPham.setLinkAnh(rsSTSP.getString(4));
                    sanPham.setMoTa(rsSTSP.getString(5));
                    sanPham.setGia(rsSTSP.getDouble(6));
                    soThichSanPham.setSanPham(sanPham);
                    dsSTSP.add(soThichSanPham);
                }
                soThich.setDsSanPham(dsSTSP);
                soThichKhachHang.setSoThich(soThich);
                kq.add(soThichKhachHang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoThichKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    public static void main(String[] args) {
        SoThichKhachHangDAO dao = new SoThichKhachHangDAO();
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        System.out.println(dao.getDSSTKHTheoDSIdSoThich(x).get(1).getSoThich().getDsSanPham().get(0).getSanPham().getLinkAnh());
    }
    
}
