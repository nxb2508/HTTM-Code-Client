/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.HoaDon;
import model.SanPhamDaMua;

/**
 *
 * @author Back
 */
public class HoaDonDAO extends DAO{

    public HoaDonDAO() {
        super();
    }
    
    public int addHoaDon(HoaDon hd) {
        int kq = 0;
        String sqlThemHoaDon = "insert into tblhoadon (tongTien, ghiChu, idKhachHang) values (?, ?, ?)";
        String sqlLayHoaDonMoiThem = "select * from tblhoadon order by id desc limit 1";
        String sqlThemSPDM = "insert into tblsanphamdamua (soLuong, gia, idHoaDon, idSanPham) values(?, ?, ?, ?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement stmThemHoaDon = conn.prepareStatement(sqlThemHoaDon);
            stmThemHoaDon.setDouble(1, hd.getTongTien());
            stmThemHoaDon.setString(2, hd.getGhiChu());
            stmThemHoaDon.setInt(3, hd.getKhachHang().getId());
            stmThemHoaDon.executeUpdate();
            PreparedStatement stmLayHoaDonMoiThem = conn.prepareStatement(sqlLayHoaDonMoiThem);
            ResultSet rs = stmLayHoaDonMoiThem.executeQuery();
            if(rs.next()){
                hd.setId(rs.getInt(1));
                for(SanPhamDaMua spdm : hd.getDsSanPhamDaMua()){
                    PreparedStatement stmThemSPDM = conn.prepareStatement(sqlThemSPDM);
                    stmThemSPDM.setInt(1, spdm.getSoLuong());
                    stmThemSPDM.setDouble(2, spdm.getGia());
                    stmThemSPDM.setInt(3, hd.getId());
                    stmThemSPDM.setInt(4, spdm.getSanPham().getId());
                    stmThemSPDM.executeUpdate();
                }
                conn.commit();
                kq = 1;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
                System.out.println(ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }
        return kq;
    }
    
}
