<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Information - Converting GSON to JSON</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);

function MyController($scope, $http) {

	
	  
        $scope.getBook = function() {
                $http({
                        method : 'GET',
                        url : 'Music'
                }).success(function(data, status, headers, config) {
                        $scope.music = data; alert(data); 
                }).error(function(data, status, headers, config) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                });
        };
};



</script>
</head>
<body>

<div class="container" ng-app="myApp" ng-controller="MyController">
  
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        
       
        
      </div>      
    </div>
  </form>
  <div ng-init="getBook()">
  <p><input type="text" ng-model="test"></p>
  <table class="table table-bordered ">
    
    <thead>
      <tr>
      <td>
          
            ISBN 
           
        </td>
        
        <td>
         NAME
           
        </td>
        <td>
         
          DESCRIPTION 
           
        </td>
        <td>
         
         PRICE 
           
        </td>
         <td>
        UPDATE 
           
        </td>
         <td>
         
        DELETE
           
        </td>
        <td>info...</td>
      </tr>
      
    </thead>
    
    <tbody>
      <tr ng-repeat="genre in music  | filter:test">
           		<td>{{genre.genreid}}</td>
           		<td>{{genre.genrename}}</td>
           		<td>{{genre.desc}}</td>
           		<td>{{genre.price}}</td>
           		<td><a href="Update?gid={{genre.genreid}}">UPDATE</a></td>
           		<td><a href="Delete?gid={{genre.genreid}}">DELETE</a></td>
           		<td><a href="More"><img src="<c:url value='/resources/img/portfolio/info.png'/>" class="img-rounded" alt="loading...." width="50" height="50"></a></td>
      </tr>
    </tbody>
    
  </table>
	<a href="index.jsp"><input type="button" value="HOME"/></a>

  </div>
</div>

</body>
</html>