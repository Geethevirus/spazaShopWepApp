<%-- 
    Document   : product_list
    Created on : Apr 26, 2024, 6:10:43 PM
    Author     : Gonts
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.ejb.entities.Productv"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>==============Products==============</h1>
        <%
            List<Productv> prods = (List<Productv>)session.getAttribute("products");
            
            for (int i = 0; i < prods.size(); i++) {
                
                String name = prods.get(i).getName();
                Double price = prods.get(i).getPrice();
                String prod_code = prods.get(i).getItem_code();
                
        %>
        <form action="CartDisplyController.do" method="POST">
            
            <table cell-padding="50" border="0">
                <tr>
                    <th>Description</th>
                    <th>Price</th>
                    <th><input type="hidden" name="prod_code" value="<%=prod_code%>"></th>
                </tr>
                <tr>
                    <td><%=name%></td>
                    <td><%=price%></td>
                    <td><input type="submit" name="add_to_cart" value="Add to cart"></td>
                </tr>
            </table>
            
        </form>
        <%}%>
        
        <p>Click <a href="customer_use.html">Here</a> to go to menu Page</p>
    </body>
</html>
