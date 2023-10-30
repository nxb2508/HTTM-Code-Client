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
import model.KhachHang;
import model.SanPham;
import model.SoThich;
import model.SoThichKhachHang;
import model.SoThichSanPham;

/**
 *
 * @author Back
 */
public class KhachHangDAO extends DAO {

    public KhachHangDAO() {
        super();
    }

    public boolean kiemTraTaiKhoan(KhachHang kh) {
        String sql = "select * from tblkhachhang "
                + "where taiKhoan = ? and matKhau = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, kh.getTaiKhoan());
            stm.setString(2, kh.getMatKhau());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int idKH = rs.getInt("id");
                kh.setId(idKH);
                kh.setHoTen(rs.getString("hoTen"));
                kh.setSoDienThoai(rs.getString("soDienThoai"));
                kh.setDiaChi(rs.getString("diaChi"));
                ArrayList<SoThichKhachHang> dsSTKH = new ArrayList<>();
                String sqlSTKH = "select stkh.id as stkhId, st.id, st.ten from tblsothich as st\n"
                        + "join tblsothichkhachhang as stkh\n"
                        + "where st.id = stkh.idSoThich\n"
                        + "and idKhachHang = " + idKH;
                PreparedStatement stmSTKH = conn.prepareStatement(sqlSTKH);
                ResultSet rsSTKH = stmSTKH.executeQuery();
                while (rsSTKH.next()) {
                    SoThichKhachHang soThichKhachHang = new SoThichKhachHang();
                    soThichKhachHang.setId(rsSTKH.getInt(1));
                    SoThich soThich = new SoThich();
                    int idSoThich = rsSTKH.getInt(2);
                    soThich.setId(idSoThich);
                    soThich.setTen(rsSTKH.getString(3));
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
                    dsSTKH.add(soThichKhachHang);
                }
                kh.setDsSoThich(dsSTKH);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }

    public int capNhatThongTin(KhachHang kh) {
        int kq = 0;
        try {
            conn.setAutoCommit(false);
            String sqlSuaKhachHang = "update tblkhachhang set hoTen = ?, soDienThoai = ?, diaChi = ? where id = ?";
            String sqlXoaSoThich = "delete from tblsothichkhachhang where idKhachHang = ?";
            String sqlThemSoThichKhachHang = "insert into tblsothichkhachhang(idKhachHang, idSoThich) values(?, ?)";
            PreparedStatement stmSuaKH = conn.prepareStatement(sqlSuaKhachHang);
            stmSuaKH.setString(1, kh.getHoTen());
            stmSuaKH.setString(2, kh.getSoDienThoai());
            stmSuaKH.setString(3, kh.getDiaChi());
            stmSuaKH.setInt(4, kh.getId());
            stmSuaKH.executeUpdate();
            PreparedStatement stmXoaSoThich = conn.prepareStatement(sqlXoaSoThich);
            stmXoaSoThich.setInt(1, kh.getId());
            stmXoaSoThich.executeUpdate();
            if (kh.getDsSoThich() != null) {
                for (SoThichKhachHang temp : kh.getDsSoThich()) {
                    PreparedStatement stmThemSoThichKhachHang = conn.prepareStatement(sqlThemSoThichKhachHang);
                    stmThemSoThichKhachHang.setInt(1, kh.getId());
                    stmThemSoThichKhachHang.setInt(2, temp.getSoThich().getId());
                    stmThemSoThichKhachHang.executeUpdate();
                }
            }
            conn.commit();
            kq = 1;
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

    public static void main(String[] args) {
        KhachHang kh = new KhachHang();
        kh.setTaiKhoan("username1");
        kh.setMatKhau("123456");
        KhachHangDAO khdao = new KhachHangDAO();
        System.out.println(khdao.kiemTraTaiKhoan(kh));;
    }

}
