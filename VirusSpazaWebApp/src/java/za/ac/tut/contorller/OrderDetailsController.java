/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.contorller;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.CartSBLocal;
import za.ac.tut.ejb.entities.Address;
import za.ac.tut.ejb.model.LineItem;

/**
 *
 * @author Gonts
 */
public class OrderDetailsController extends HttpServlet {

    @EJB
    private CartSBLocal csb;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        String street = request.getParameter("street");
        String code = request.getParameter("code");
        String area = request.getParameter("area");
        
        
        Address addr = new Address(street, area, code);
        
        
        List<LineItem> cartItems = csb.getCart();
        Double total = csb.total_amount();
        
        session.setAttribute("addr", addr);
        request.setAttribute("total", total);
        request.setAttribute("cartItems", cartItems);
        
        
        
        RequestDispatcher disp = request.getRequestDispatcher("order_details.jsp");
        disp.forward(request, response);
        
    }

   

}
