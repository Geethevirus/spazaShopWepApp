<%-- 
    Document   : disply_cart
    Created on : Apr 26, 2024, 7:08:00 PM
    Author     : Gonts
--%>

<%@page import="za.ac.tut.ejb.model.LineItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>==============Your Cart==============</h1>
        
        <%
            List<LineItem> lineItems = (List<LineItem>)request.getAttribute("cartItems");
            Double amount_due = (Double)request.getAttribute("total");
            
            for (int i = 0; i < lineItems.size(); i++) {
                
                String item_name = lineItems.get(i).getProduct().getName();
                String item_code = lineItems.get(i).getProduct().getItem_code();
                Integer item_quantity = lineItems.get(i).getQuantity();
                
                
                
        %>
        
        <form action="UpdateCartServlet.do" method="POST">
            <table>
                <tr>
                    <td><%=item_name%></td>
                    <td><input type="text" value="<%=item_quantity%>"></td>
                    <td><input type="submit" name="update" value="update"></td>
                    <td><input type="submit" name="remove" value="remove"></td>
                    <td><input type="hidden" name="item_code" value="<%=item_code%>"></td>
                </tr>
            </table>
        </form>
        
        <%}%>
        <hr>
        <table>
            <tr>
                <td>Total</td>
                <td><%=amount_due%></td>
            </tr>
        </table>
        <p>Click <a href="customer_use.html">Here</a> to go to MENU page or <a href="address_page.html">Here</a> to CHECKOUT.</p>
        <p>Click <a href="product_list.jsp"> Here</a> to shop.</p>
    </body>
</html>
