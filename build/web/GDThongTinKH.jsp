<%-- 
    Document   : GDThongTinKH
    Created on : Oct 19, 2023, 5:20:25 PM
    Author     : Back
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*, dao.*"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thông Tin Tài Khoản</title>
        <link rel="stylesheet" href="./Assets/css/GDThongTinKH.css">
    </head>

    <body>
        <%
            KhachHang kh = (KhachHang) session.getAttribute("khachHang");
            if(kh == null){
                response.sendRedirect("GDDangNhap.jsp");
            } else {
        %>
        <div class="">
            <h1>Thông Tin Tài Khoản</h1>
            <div class="profile">
                <p for="fullName">Họ Và Tên:</p>
                <input type="text" disabled value="<%= kh.getHoTen() %>">
            </div>
            <div class="profile">
                <p for="phoneNumber">Số Điện Thoại:</p>
                <input type="text" disabled value="<%= kh.getSoDienThoai() %>">
            </div>
            <div class="profile">
                <p for="address">Địa Chỉ:</p>
                <input type="text" disabled value="<%= kh.getDiaChi() %>">
            </div>

            <div class="profile">
                <p>Danh Sách Sở Thích:</p>
                <div class="hobby">
                    <table>
                        <thead>
                            <tr>
                                <th>Tên Sở Thích</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            ArrayList<SoThichKhachHang> dsSoThich = kh.getDsSoThich();
                            if(dsSoThich != null){
                                for(SoThichKhachHang stkh : dsSoThich){

                            %>
                            <tr>
                                <td><%= stkh.getSoThich().getTen()%></td>
                            </tr>
                            <%
                                }
                            }
                            %>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="update">
                <a href="GDSuaThongTinKH.jsp">Sửa Thông Tin</a>
            </div>
        </div>
        <%
            }
        %>
        <%
            String mess = request.getParameter("mess");
            if(mess != null) {
                if(mess.equals("success")){
                    %>
                    <script>alert("Thay đổi thông tin thành công");</script>
                    <%
                } else if (mess.equals("err")){
                    %>
                    <script>alert("Đã xảy ra lỗi vui lòng thử lại");</script>
                    <%
                }
            }
        %>
    </body>

</html>