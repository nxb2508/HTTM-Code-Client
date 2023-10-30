<%-- 
    Document   : doDangNhap
    Created on : Oct 19, 2023, 10:53:20 AM
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
        <h1>Hello World!</h1>
        <%
            String taiKhoan = request.getParameter("username");
            String matKhau = request.getParameter("password");
            KhachHang kh = new KhachHang();
            kh.setTaiKhoan(taiKhoan);
            kh.setMatKhau(matKhau);
            KhachHangDAO khDAO = new KhachHangDAO();
            boolean kq = khDAO.kiemTraTaiKhoan(kh);
            if(kq){
                session.setAttribute("khachHang", kh);
                response.sendRedirect("GDChinhKH.jsp");
            } else {
                response.sendRedirect("GDDangNhap.jsp?err=saiTaiKhoan");
            }
        %>
    </body>
</html>
