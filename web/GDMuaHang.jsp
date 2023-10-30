<%-- 
    Document   : GDMuaHang
    Created on : Oct 20, 2023, 5:31:38 PM
    Author     : Back
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*, dao.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./Assets/css/GDMuaHang.css">
    </head>
    <body>
        <%
            HashMap<Integer, Integer> gioHang = (HashMap<Integer, Integer>) session.getAttribute("gioHang");
            if(gioHang == null){
                gioHang = new HashMap<>();
                session.setAttribute("gioHang", gioHang);
            }
            String xoa = request.getParameter("xoa");
            String idSanPhamReqStr = request.getParameter("idSanPham");
            if(idSanPhamReqStr != null) {
                int idSanPhamReq = Integer.parseInt(idSanPhamReqStr);
                if(xoa != null){
                    if(gioHang.containsKey(idSanPhamReq)){
                        gioHang.remove(idSanPhamReq);
                    }
                } else {
                    String soLuongReqStr = request.getParameter("quantity");
                    int soLuongReq = Integer.parseInt(soLuongReqStr);
                    if(soLuongReq > 0) {
                        if(gioHang.containsKey(idSanPhamReq)){
                            gioHang.put(idSanPhamReq, gioHang.get(idSanPhamReq) + soLuongReq);
                        } else {
                            gioHang.put(idSanPhamReq, soLuongReq);
                        }
                    } else {
                        if(gioHang.containsKey(idSanPhamReq)){
                            if(gioHang.get(idSanPhamReq) + soLuongReq > 0){
                                gioHang.put(idSanPhamReq, gioHang.get(idSanPhamReq) + soLuongReq);
                            } else {
                                gioHang.remove(idSanPhamReq);
                            }
                        }
                    }
                }
            }
            

        %>
        <h1>Mua Hàng</h1>
        <div class="bill">
            <table>
                <thead>
                    <tr>
                        <th>Thứ Tự</th>
                        <th>Tên</th>
                        <th>Số Lượng</th>
                        <th>Giá</th>
                        <th>Tổng Tiền</th>
                        <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int thuTu = 0;
                        int tongSanPham = 0;
                        double tongTien = 0;
                        for(Integer idSanPham : gioHang.keySet()){
                            SanPham sanPham = new SanPhamDAO().getSanPhamTheoMa(idSanPham);
                            thuTu++;
                            double giaSanPham = sanPham.getGia();
                            int soLuongCuaSanPham = gioHang.get(sanPham.getId());
                            double tongTienCuaSanPham = giaSanPham*soLuongCuaSanPham;
                            tongSanPham += soLuongCuaSanPham;
                            tongTien += tongTienCuaSanPham;
                    %>
                    <tr>
                        <td><%=thuTu%></td>
                        <td><%=sanPham.getTen()%></td>
                        <td class="quantity">
                            <a href="GDMuaHang.jsp?idSanPham=<%=sanPham.getId()%>&quantity=-1">-</a>
                            <%=soLuongCuaSanPham%>
                            <a href="GDMuaHang.jsp?idSanPham=<%=sanPham.getId()%>&quantity=1">+</a>
                        </td>
                        <td><%=giaSanPham%></td>
                        <td><%=tongTienCuaSanPham%></td>
                        <td><a href="GDMuaHang.jsp?idSanPham=<%=sanPham.getId()%>&xoa=true">Xóa</a></td>
                    </tr>
                    <%    
                        }

                    %>
                </tbody>
            </table>
        </div>
        <p>Tổng số sản phẩm: <%=tongSanPham%></p>
        <p>Thành Tiền: <%=tongTien%></p>
        <form action="doLuuHoaDon.jsp" method="post">
            <input type="hidden" name="tongTien" value="<%=tongTien%>">
            <label for="ghiChu">Ghi Chu</label>
            <input id="ghiChu" type="text" name="ghiChu">
            <br>
            <button type="submit">Xác Nhận</button>
        </form>
        <%
        String mess = request.getParameter("mess");
        if(mess != null) {
            if(mess.equals("success")){
                %>
                <script>alert("Dat Hang Thanh Cong");</script>
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
