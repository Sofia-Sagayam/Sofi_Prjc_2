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
<a href="all?name=4"><input type="button" value="ViewGenre"/></a>
<form:form action="musicMap" modelAttribute="music" method="post">
GenreId:<form:input path="genreid"/><br/>
GenreName:<form:input path="genrename" /><br/>
Desc:<form:input path="desc"/><br/>
Price:<form:input path="price" /><br/>
<input type="submit" value="add"/>
</form:form>


</body>
</html>