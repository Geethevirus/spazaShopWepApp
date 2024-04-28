/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.ejb.entities.OrderItem;
import za.ac.tut.ejb.model.LineItem;

/**
 *
 * @author Gonts
 */
@Local
public interface CartSBLocal {
    public List<LineItem> getCart() ;
    public double total_amount();
    public void addItem(LineItem item);
    public void remove(String prod_code);
    public void setOrderItems(List<OrderItem> orderItems);
    public List<OrderItem> getOrderItems();
}
