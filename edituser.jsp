<%@page import="com.treselle.dao.UserDao"%>
<jsp:useBean id="u" class="com.treselle.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%-- Delete operation is performed on row--%>
<%
int i=UserDao.update(u);
response.sendRedirect("viewusers.jsp");
%>