<%-- 
    Document   : GDChinhKH
    Created on : Oct 19, 2023, 10:47:11 AM
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
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if(khachHang != null) {
        %>
            <h1>Giao Dien Chinh <%= khachHang.getHoTen()%></h1>
            <a href="GDThongTinKH.jsp">Thong Tin Tai Khoan</a>
            <a href="GDToanBoSanPham.jsp">Toan Bo San Pham</a>
        <%
        } else {
        %>
        <h1>Chua Dang Nhap</h1>
        <a href="GDDangNhap.jsp">Dang Nhap</a>
        <%
        }
        %>
    </body>
</html>
