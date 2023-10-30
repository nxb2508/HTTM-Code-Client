<%-- 
    Document   : GDDangNhap
    Created on : Oct 18, 2023, 11:01:01 PM
    Author     : Back
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*, dao.*"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng Nhập</title>
        <link rel="stylesheet" href="./Assets/css/GDDangNhap.css">
    </head>

    <body>
        <%
            KhachHang kh = (KhachHang) session.getAttribute("khachHang");
            if(kh != null){
                response.sendRedirect("GDChinhKH.jsp");
            }
        %>
        <div class="sign-in">
            <h1>Đăng Nhập</h1>
            <form action="doDangNhap.jsp" method="post">
                <div class="form-input">
                    <label for="username">Tài Khoản</label>
                    <input type="text" name="username" id="username" placeholder="Nhập Tài Khoản">
                </div>
                <div class="form-input">
                    <label for="password">Mật Khẩu</label>
                    <input type="password" name="password" id="password" placeholder="Nhập Mật Khẩu">
                </div>
                <div class="form-input">
                    <button type="submit">Đăng Nhập</button>
                </div>
            </form>
        </div>
        <%
            String err = request.getParameter("err");
            if(err!=null && err.equals("saiTaiKhoan")){
                %><script>alert("Tai Khoan Hoac Mat Khau Khong Dung");</script><%
            }
        %>
    </body>

</html>