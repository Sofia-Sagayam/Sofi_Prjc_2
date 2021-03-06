<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
     uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="<c:url value='/resources/css/login.css'></c:url>">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default">
		<div class="container-fluid">
		<button type="button" class="navbar-toggle collapsed" 
   data-toggle="collapse" data-target="#collapse-example" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
		<div class="navbar-header">
        <c:url value="/resources/images/ast.jpg" var="url"></c:url>
		<a class="navbar-brand" href=""><img src="${url }" alt="NIIT" height="30px" width="30px"></a>
			</div>
			<div  class="collapse navbar-collapse" id="collapse-example">
		<ul class="nav navbar-nav">
		<c:url value="/home" var="homeUrl"></c:url>
			<li class="active"><a href="${homeUrl }">Home<span class="sr-only">You are in home page link</span></a></li>
			<c:url value="/aboutus" var="aboutUsUrl"></c:url>
			<li><a href="${aboutUsUrl }">AboutUs</a></li>
			<c:url value="/admin/getproductform?id=0" var="productForm"></c:url>
			<security:authorize access="hasRole('ROLE_ADMIN')">
			
			<li><a href="${productForm }">Add Product</a></li>
			</security:authorize>
			
			<c:url value="/all/getallproducts" var="productsUrl"></c:url>
			<!--  productsUrl = http://localhost:9090/project1_frontend/all/getallproducts -->
			<li><a href="${productsUrl }">Browse all products</a></li>
			<li class="dropdown">
			<a href="" class="dropdown-toggle" data-toggle="dropdown">
                     Select by Category<b class="caret"></b></a>
			<ul class="dropdown-menu">
					<li>
					<c:forEach items="${categories }" var="c">
		<c:url 
			value="/all/product/searchbycategory?searchCondition=${c.categoryname }"
				var="url" ></c:url>
                <a href="${url }" >${c.categoryname } </a>
                </c:forEach>
                <c:url value="/all/product/searchbycategory?searchCondition=All" var="url1">
                </c:url>
                 <a href="${url1 }">All</a>
                </li>
			</ul>
			</li>
			<security:authorize access="hasRole('ROLE_USER')">
			<li><a href="<c:url value='/cart/getcart'></c:url>">cart</a></li>
			</security:authorize>
			<c:if test="${pageContext.request.userPrincipal.name==null }">
			<li><a href="<c:url value='/login'></c:url>">Sign In</a></li>
			<li><a href='<c:url value='/all/registrationform'></c:url>'>Sign Up</a></li>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<li><a href="">Welcome ${pageContext.request.userPrincipal.name}</a></li>
			<li><a href="<c:url value='/j_spring_security_logout'></c:url>">logout</a></li>
			</c:if>
			
			</ul>
			</div>
		</div>
	</nav>
</body>
</html>