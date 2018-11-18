<%--importing packages like in java code--%>
<%@page import="com.treselle.dao.UserDao"%>
<%--Creates instances of object like java code --%>
<jsp:useBean id="u" class="com.treselle.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserDao.delete(u);
response.sendRedirect("viewusers.jsp");
%>