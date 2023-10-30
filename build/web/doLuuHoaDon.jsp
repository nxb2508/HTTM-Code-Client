<%-- 
    Document   : doLuuHoaDon
    Created on : Oct 20, 2023, 6:51:10 PM
    Author     : Back
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*, dao.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HoaDon hd = (HoaDon) session.getAttribute("hoaDon");
            if(hd != null){
                HashMap<Integer, Integer> gioHang = (HashMap<Integer, Integer>) session.getAttribute("gioHang");
                ArrayList<SanPhamDaMua> dsSPDM = new ArrayList<>();
                SanPhamDAO spDAO = new SanPhamDAO();
                for(Integer idSanPham : gioHang.keySet()){
                    SanPhamDaMua spdm = new SanPhamDaMua();
                    SanPham sanPham = spDAO.getSanPhamTheoMa(idSanPham);
                    spdm.setGia(sanPham.getGia());
                    spdm.setSoLuong(gioHang.get(idSanPham));
                    spdm.setSanPham(sanPham);
                    dsSPDM.add(spdm);
                }
                hd.setDsSanPhamDaMua(dsSPDM);
                String tongTienStr = request.getParameter("tongTien");
                Double tongTien = Double.parseDouble(tongTienStr);
                hd.setTongTien(tongTien);
                String ghiChu = request.getParameter("ghiChu");
                hd.setGhiChu(ghiChu);
                HoaDonDAO hdDAO = new HoaDonDAO();
                int kq = hdDAO.addHoaDon(hd);
                if(kq == 1) {
                    session.removeAttribute("gioHang");
                    response.sendRedirect("GDMuaHang.jsp?mess=success");
                } else {
                    response.sendRedirect("GDMuaHang.jsp?mess=error");
                }
            } else {
                response.sendRedirect("GDDangNhap.jsp");
            }
        %>
    </body>
</html>
