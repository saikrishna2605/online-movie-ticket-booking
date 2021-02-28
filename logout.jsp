<%-- 
    Document   : logout
    Created on : 23 Sep, 2019, 2:06:34 AM
    Author     : sai krishna
--%>

<%
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>
