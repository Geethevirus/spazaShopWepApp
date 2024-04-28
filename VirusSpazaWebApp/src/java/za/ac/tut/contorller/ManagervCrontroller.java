/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.contorller;

import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.ejb.bl.ProductvFacadeLocal;
import za.ac.tut.ejb.entities.Productv;

/**
 *
 * @author Gonts
 */
public class ManagervCrontroller extends HttpServlet {
    @EJB
    private ProductvFacadeLocal pfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opt = request.getParameter("opt");
        
        if (opt.equalsIgnoreCase("prod_add")) {
            
            String name = request.getParameter("prod_name");
            String prod_code = request.getParameter("prod_code");
            Integer prod_quantity = Integer.parseInt(request.getParameter("prod_quantity"));
            Double prod_price = Double.parseDouble(request.getParameter("prod_price"));
            
            Productv prod = new Productv();
            prod.setName(name);
            prod.setItem_code(prod_code);
            prod.setPrice(prod_price);
            prod.setQuantity(prod_quantity);
            
            pfl.create(prod);
            
            RequestDispatcher disp = request.getRequestDispatcher("add_outcome.html");
            disp.forward(request, response);
            
            
        }
        
        
    }


}
