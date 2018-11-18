<%@page import="com.treselle.dao.UserDao"%>
<jsp:useBean id="u" class="com.treselle.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
String name=request.getParameter("name");
String password=request.getParameter("password");
String email=request.getParameter("email");
String sex=request.getParameter("sex");
if(name.equals("") || password.equals("") || email.equals("")) {
	out.println("<h1><center>Enter valid details</center></h1>");
	 %><center><a href="userform.html">return back</a>
<%}

else {
int i=UserDao.save(u);
if(i>0){
response.sendRedirect("adduser-success.jsp");
}else{
response.sendRedirect("adduser-error.jsp");
}
}
%>