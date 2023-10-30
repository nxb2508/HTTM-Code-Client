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
        <link rel="stylesheet" href="./Assets/css/GDSuaThongTinKH.css">
    </head>

    <body>
        <%
            KhachHang kh = (KhachHang) session.getAttribute("khachHang");
            if(kh == null){
                response.sendRedirect("GDDangNhap.jsp");
            } else {
        %>
        <form action="doSuaThongTinKH.jsp" method="post">
            <h1>Sửa Thông Tin Tài Khoản</h1>
            <div class="profile">
                <p>Họ Và Tên:</p>
                <input type="text" name="fullName" value="<%= kh.getHoTen() %>">
            </div>
            <div class="profile">
                <p>Số Điện Thoại:</p>
                <input type="text" name="phoneNumber" value="<%= kh.getSoDienThoai() %>">
            </div>
            <div class="profile">
                <p>Địa Chỉ:</p>
                <input type="text" name="address" value="<%= kh.getDiaChi() %>">
            </div>
            <%
                ArrayList<Integer> idSoThichCuaKhachHang = new ArrayList<>();
                if(kh.getDsSoThich() != null){
                    for(SoThichKhachHang stkh : kh.getDsSoThich()){
                        idSoThichCuaKhachHang.add(stkh.getSoThich().getId());
                    }
                }
                SoThichDAO stDAO = new SoThichDAO();
                ArrayList<SoThich> tatCaSoThich = stDAO.getSoThich();
            %>
            <div class="profile">
                <p class="hobby-header">Sở Thích:</p>
                <div class="hobby">
                    <%
                        for(SoThich temp : tatCaSoThich){
                            %>
                                <span class="ten-so-thich"><%= temp.getTen() %></span>
                                <input type="checkbox" name="idSoThich" 
                                       <%
                                           if(idSoThichCuaKhachHang.contains(temp.getId())){
                                           %>checked<%
                                           }
                                       %>
                                       value="<%= temp.getId() %>">
                            <%
                        }
                    %>
                </div>
            </div>
            <div class="update">
                <button type="submit">Sửa</button>
            </div>
        </form>
        <%
            }
        %>

    </body>

</html>