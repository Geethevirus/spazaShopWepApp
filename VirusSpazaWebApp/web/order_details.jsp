<%-- 
    Document   : order_details
    Created on : Apr 26, 2024, 10:03:07 PM
    Author     : Gonts
--%>

<%@page import="za.ac.tut.ejb.entities.Address"%>
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
        <h1>Order details</h1>
          <hr>
         <%
            List<LineItem> lineItems = (List<LineItem>)request.getAttribute("cartItems");
            Address addr = (Address)session.getAttribute("addr");
            Double amount_due = (Double)request.getAttribute("total");
            
            String code = addr.getCode();
            String area = addr.getArea();
            String street = addr.getStreet();
            
            for (int i = 0; i < lineItems.size(); i++) {
                
                String item_name = lineItems.get(i).getProduct().getName();
                Integer item_quantity = lineItems.get(i).getQuantity();
                
                
                
        %>
      
        <table>
                <tr>
                    <td><%=item_name%></td>
                    <td><%=item_quantity%></td>

                </tr>
        </table>
        <%}%>
        <p>Total      <%=amount_due%></p>
        <hr>
        <table>
            <tr>
                <td>Street:</td>
                <td><%=street%></td>
            </tr>
            <tr>
                <td>area:</td>
                <td><%=area%></td>
            </tr>
            <tr>
                <td>code:</td>
                <td><%=code%></td>
            </tr>
        </table>
        <form action="CartDisplyController.do" method="POST">
            <input type="submit" name="pay_btn" value="CLICK PAY">
        </form>
    </body>
</html>
