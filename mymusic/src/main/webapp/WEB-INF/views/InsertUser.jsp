<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <a href="ud?name=1"><input type="button" value="ViewUser"/></a>
<form:form action="userMap" modelAttribute="user" method="post">

UserName:<form:input path="uname" /><br/>
UserPass:<form:input path="upass"/><br/>
ROLE:<form:input path="urole" /><br/>
<input type="submit" value="add"/>
</form:form>


</body>
</html>