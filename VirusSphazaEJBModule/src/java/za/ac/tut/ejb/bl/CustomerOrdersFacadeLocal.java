/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.ejb.entities.CustomerOrders;

/**
 *
 * @author Gonts
 */
@Local
public interface CustomerOrdersFacadeLocal {

    void create(CustomerOrders customerOrders);

    void edit(CustomerOrders customerOrders);

    void remove(CustomerOrders customerOrders);

    CustomerOrders find(Object id);

    List<CustomerOrders> findAll();

    List<CustomerOrders> findRange(int[] range);

    int count();
    
}
