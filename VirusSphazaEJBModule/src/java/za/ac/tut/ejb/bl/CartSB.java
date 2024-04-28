/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package za.ac.tut.ejb.bl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import za.ac.tut.ejb.entities.OrderItem;
import za.ac.tut.ejb.model.LineItem;

/**
 *
 * @author Gonts
 */
@Stateful
public class CartSB implements CartSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private List<LineItem> cart = new ArrayList<>();
    private List<OrderItem> orderItems = new ArrayList<>();
    
    @Override
    public void addItem(LineItem item)
    {
        boolean item_found = false;
        
        
        for (int i = 0; i < cart.size(); i++) {
            
            if (item.getProduct().getItem_code().equalsIgnoreCase(cart.get(i).getProduct().getItem_code())) {
                
               Integer num = cart.get(i).getQuantity() + item.getQuantity();
               cart.get(i).setQuantity(num);
               orderItems.get(i).setQuantity(num);
               
               
               item_found=true;
               break; 
            }
            
        }
        
        if (item_found == false){
            
            cart.add(item);
            OrderItem orderItem = new OrderItem(item.getProduct().getName(),item.getQuantity());
            
            orderItems.add(orderItem);
            
        }
        
    }

    @Override
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @Override
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    
    @Override
    public void remove(String prod_code)
    {
        
        for (int i = 0; i < cart.size(); i++) {
            
            if (prod_code.equalsIgnoreCase(cart.get(i).getProduct().getItem_code())) {
              
                cart.remove(i);
                break; 
               
            }
        }
        
        
    }
    @Override
    public double total_amount()
    {
        double total = 0;
        
        for (int i = 0; i < cart.size(); i++) {
            
            total += cart.get(i).getProduct().getPrice()*cart.get(i).getQuantity();
            
        }
        return total;
    }

    @Override
    public List<LineItem> getCart() {
        
        return cart;
        
    }
    
    
}
