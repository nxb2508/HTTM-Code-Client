<%-- 
    Document   : doSuaThongTinKH
    Created on : Oct 19, 2023, 9:34:44 PM
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
            String hoTen = request.getParameter("fullName");
            String soDienThoai = request.getParameter("phoneNumber");
            String diaChi = request.getParameter("address");
            String[] idSoThichStr = request.getParameterValues("idSoThich");
            KhachHang kh = (KhachHang) session.getAttribute("khachHang");
            if(idSoThichStr != null){
                ArrayList<Integer> dsIdSoThich = new ArrayList<>();
                for(String temp : idSoThichStr){
                    dsIdSoThich.add(Integer.parseInt(temp));
                }
                ArrayList<SoThichKhachHang> dsSTKH = new SoThichKhachHangDAO().getDSSTKHTheoDSIdSoThich(dsIdSoThich);
                kh.setDsSoThich(dsSTKH);
            } else {
                kh.setDsSoThich(null);
            }
            kh.setHoTen(hoTen);
            kh.setSoDienThoai(soDienThoai);
            kh.setDiaChi(diaChi);
            int kq = new KhachHangDAO().capNhatThongTin(kh);
            if(kq == 1){
                session.removeAttribute("khachHang");
                session.setAttribute("khachHang", kh);
                response.sendRedirect("GDThongTinKH.jsp?mess=success");
            } else {
                response.sendRedirect("GDThongTinKH.jsp?mess=err");
            }
            
        %>
    </body>
</html>
