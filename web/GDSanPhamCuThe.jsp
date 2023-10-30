<%-- 
    Document   : GDSanPhamCuThe
    Created on : Oct 20, 2023, 3:43:51 PM
    Author     : Back
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*, dao.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./Assets/css/GDSanPhamCuThe.css">
    </head>
    <body>
        <%
            String idSanPhamStr = request.getParameter("idSanPham");
            int idSanPham = Integer.parseInt(idSanPhamStr);
            SanPham sanPham = new SanPhamDAO().getSanPhamTheoMa(idSanPham);
        %>
        <h1>Chi tiết sản phẩm</h1>
        <div class="product-details">
            <div class="product-image">
                <img src="<%=sanPham.getLinkAnh()%>">
            </div>
            <div class="product-info">
                <h2 class="product-name"><%=sanPham.getTen()%></h2>
                <p class="product-price"><strong>Giá:</strong> <%=sanPham.getGia()%></p>
                <p class="product-description">Mô tả: <%=sanPham.getMoTa()%></p>
                <form action="GDMuaHang.jsp">
                    <input type="hidden" name="idSanPham" value="<%=sanPham.getId()%>">
                    <input type="number" min="1" name="quantity" value="1">
                    <button type="submit">Mua hàng</button>
                </form>
            </div>
        </div>
    </body>
</html>
