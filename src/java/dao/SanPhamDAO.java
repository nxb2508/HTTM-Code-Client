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

/**
 *
 * @author Back
 */
public class SanPhamDAO extends DAO{

    public SanPhamDAO() {
        super();
    }
    
    public ArrayList<SanPham> getSanPhamTheoSoThich(ArrayList<SoThich> dsSoThich){
        ArrayList<SanPham> kq = new ArrayList<>();
        String sql = "";
        if(dsSoThich != null && dsSoThich.size() > 0){
            String danhSachSoThichStr = "(";
            for(SoThich st : dsSoThich){
                danhSachSoThichStr += st.getId() + ", ";
            }
            danhSachSoThichStr = danhSachSoThichStr.substring(0, danhSachSoThichStr.length() - 2);
            danhSachSoThichStr += ")";
            sql = "select * from tblsanpham as sp "
                    + "join tblsothichsanpham as stsp "
                    + "where sp.id = stsp.idSanPham "
                    + "and stsp.idSoThich in " + danhSachSoThichStr;
        } else {
            sql = "select * from tblsanpham";
        }
        System.out.println(sql);
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                SanPham sanPham = new SanPham();
                sanPham.setId(rs.getInt(1));
                sanPham.setTen(rs.getString(2));
                sanPham.setLinkAnh(rs.getString(3));
                sanPham.setMoTa(rs.getString(4));
                sanPham.setGia(rs.getDouble(5));
                kq.add(sanPham);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public SanPham getSanPhamTheoMa(int id){
        SanPham sanPham = new SanPham();
        String sql = "select * from tblsanpham where id = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                sanPham.setId(rs.getInt(1));
                sanPham.setTen(rs.getString(2));
                sanPham.setLinkAnh(rs.getString(3));
                sanPham.setMoTa(rs.getString(4));
                sanPham.setGia(rs.getDouble(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanPham;
    }
    
}
