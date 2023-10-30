<%-- 
    Document   : GDToanBoSanPham
    Created on : Oct 20, 2023, 3:10:15 PM
    Author     : Back
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*, dao.*, extension.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Assets/css/GDToanBoSanPham.css"/>
    </head>
    <body>
        <h1>Danh sách sản phẩm</h1>
        <div class="list-product">
        <%
            KhachHang kh = (KhachHang) session.getAttribute("khachHang");
            if(kh == null){
                response.sendRedirect("GDDangNhap.jsp");
            } else {
                HoaDon hd = new HoaDon();
                hd.setKhachHang(kh);
                session.setAttribute("hoaDon", hd);
                HocMay hocMay = new HocMay();
                ArrayList<SoThich> dsSoThich = hocMay.getSoThichKhachHang(kh);
                SanPhamDAO spDAO = new SanPhamDAO();
                ArrayList<SanPham> dsSanPham = spDAO.getSanPhamTheoSoThich(dsSoThich);
                for(SanPham sanPham : dsSanPham){
                    %>
                    <a href="GDSanPhamCuThe.jsp?idSanPham=<%=sanPham.getId()%>" class="product">
                        <img src="<%=sanPham.getLinkAnh()%>">
                        <p class="name"><%=sanPham.getTen()%></p>
                        <p class="price"><%=sanPham.getGia()%></p>
                    </a>
                    <%
                }
            }
        %>
        </div>
    </body>
</html>
