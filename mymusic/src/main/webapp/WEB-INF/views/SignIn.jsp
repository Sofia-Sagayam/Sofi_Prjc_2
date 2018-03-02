<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Shopping Cart..</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </head>
<body>
	<a href="index.jsp"><input type="button" value="HOME"/></a>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
LATEST MUSIC ALBUMS...
	<div class = "row">
   
   <div class = "col-sm-6 col-md-3">
      <div class = "thumbnail">
         <img src = "resources/img/portfolio/cart1.jpg" alt = "Generic placeholder thumbnail" height="250" width="250">
      </div>
      
      <div class = "caption">
         <h3>ROCK && ROLL</h3>
         <p>Beatles for sale.</p>
         
         <p>
            <a href ="add" class = "btn btn-primary" role = "button">
              Add To Cart
            </a> 
            
            
         </p>
         
      </div>
   </div>
   
   <div class = "col-sm-6 col-md-3">
      <div class = "thumbnail">
         <img src = "resources/img/portfolio/cart2.jpg" alt = "Generic placeholder thumbnail" height="250" width="250">
      </div>
      
      <div class = "caption">
         <h3>POP MUSIC</h3>
         <p>WORTH IT!!	</p>
         
         <p>
            <a href ="add"class = "btn btn-primary" role = "button">
              Add To Cart
            </a> 
            
            
         </p>
         
      </div>
   </div>
   
   <div class = "col-sm-6 col-md-3">
      <div class = "thumbnail">
         <img src = "resources/img/portfolio/cart3.jpg" alt = "Generic placeholder thumbnail" height="250" width="250">
      </div>
      
      <div class = "caption">
         <h3>JAZZ..</h3>
         <p>What a Wondelfull World.</p>
         
         <p>
            <a href ="add" class = "btn btn-primary" role = "button">
              Add To Cart
            </a> 
           
         </p>
         
      </div>
   </div>
   
   <div class = "col-sm-6 col-md-3">
      <div class = "thumbnail">
         <img src = "resources/img/portfolio/cart4.jpg" alt = "Generic placeholder thumbnail" height="250" width="250">
      </div>
      
      <div class = "caption">
         <h3>HIP HOP</h3>
         <p>Bang !! Bang!!</p>
         
         <p>
            <a href = "add" class = "btn btn-primary" role = "button">
              Add To Cart
            </a> 
            
            
         </p>
         
      </div>
   </div>
   
</div>

	
</body>
</html>