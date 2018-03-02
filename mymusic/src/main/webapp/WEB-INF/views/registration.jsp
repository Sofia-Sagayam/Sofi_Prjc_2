<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Form</h1><br />


        <form:form commandName="USER">
          <table>

      <tr>

        <td>Name: <font color='red'><form:errors path='name' /></font></td>

      </tr>

      <tr>

        <td><form:input path="name" /></td>

      </tr>

      <tr>

        <td>Pass: <font color='red'><form:errors path='pass' /></font></td>

      </tr>

      <tr>

       <td><form:password path="pass" /></td>

      </tr>
      
      <tr>

        <td>Confirm Pass: <font color='red'><form:errors path='cPass' /></font></td>

      </tr>

      <tr>

        <td><form:password path="cPass" /></td>

      </tr>

      <tr>

        <td><input type='submit' value='Submit' /></td>

      </tr>

    </table> 
    	<a href="index.jsp"><input type="button" value="HOME"/></a>
    
        </form:form>
</body>
</html>