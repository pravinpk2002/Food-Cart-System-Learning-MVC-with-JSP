<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--     <%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@ page import="com.xyz.foodcart.Food" %>  
<%@ page import="java.util.List" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>menu</title>
</head>
<body>
	
	<h1 align="center">Menu</h1>
    <h4 align="center">*******************************************************************</h4>
    
    <table border="1" cellpadding="40%" align="center" style="border: 2px solid green; border-collapse: collapse;">
    	<tr> 
    		<th>Food Id</th>
    		<th>Item</th>
    		<th>Price</th>    		
    	</tr>
    	
    	
    <% 
            List<Food> items = (List<Food>) request.getAttribute("foodItems");
            for (Food item : items) {
        %>
        <tr>
            <td><%= item.getId() %> </td>
            <td><%= item.getItem() %> </td> 
            <td><%= item.getPrice() %> </td>
        </tr>    
        <% 
            } 
        %>
    
    </table>
   
</body>
</html>