/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.contorller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.AddressFacadeLocal;
import za.ac.tut.ejb.bl.CartSBLocal;
import za.ac.tut.ejb.bl.CustomerOrdersFacadeLocal;
import za.ac.tut.ejb.bl.ProductvFacadeLocal;
import za.ac.tut.ejb.entities.Address;
import za.ac.tut.ejb.entities.CustomerOrders;
import za.ac.tut.ejb.entities.OrderItem;
import za.ac.tut.ejb.entities.Productv;
import za.ac.tut.ejb.model.LineItem;

/**
 *
 * @author Gonts
 */
public class CartDisplyController extends HttpServlet {

   
    @EJB
    private CartSBLocal csb;
    @EJB
    private CustomerOrdersFacadeLocal cof; 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        
        String url ="disply_cart.jsp";
        List<Productv> prods = (List<Productv>)session.getAttribute("products");
        //boolean add_to_cart = Boolean.valueOf(request.getParameter("add_to_cart"));
        String add_to_cart = (request.getParameter("add_to_cart"));
        String address_btn = (request.getParameter("address_btn"));
        String pay_btn = (request.getParameter("pay_btn"));

        if (add_to_cart != null) {
            
            String prod_code = request.getParameter("prod_code");
            Productv prduct = findProduct(prod_code, prods);
            LineItem item = new LineItem(prduct,1);
        
            csb.addItem(item);
           
        }
        
        if (address_btn != null) {
            
            String street = request.getParameter("street");
            String code = request.getParameter("code");
            String area = request.getParameter("area");
        
        
            Address addr = new Address(street, area, code);
            
            session.setAttribute("addr", addr);
            url = "order_details.jsp";
            
        }
        
       
        
       
        List<LineItem> cartItems = csb.getCart();
       
        Double total = csb.total_amount();
        
        if (pay_btn != null) {
            
             
            List<OrderItem> orderItems = csb.getOrderItems();
            
            Address addr = (Address)session.getAttribute("addr");
            
            CustomerOrders cus_orders = new CustomerOrders();
            CustomerOrders cus_orders2 = new CustomerOrders();
            
            
            cus_orders.setAddress(addr);
            cus_orders.setAmount_due(total);
            cus_orders.setCreation_time(new Date());
            cus_orders.setItems(orderItems);
            
           
            
            cof.create(cus_orders);

            url = "pay_outcome.html";
             
        }
        
        
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("total", total);
        
        
        
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

   private Productv findProduct(String prod_code,  List<Productv> prods)
   {
       
       Productv product =null;
       for (int i = 0; i < prods.size(); i++) {
           
            if (prods.get(i).getItem_code().equalsIgnoreCase(prod_code)) {
               
               product = prods.get(i);
               
           }
           
       }
       return product;
   }

}
