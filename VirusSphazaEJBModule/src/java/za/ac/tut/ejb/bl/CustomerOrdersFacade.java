/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.ejb.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.ejb.entities.CustomerOrders;

/**
 *
 * @author Gonts
 */
@Stateless
public class CustomerOrdersFacade extends AbstractFacade<CustomerOrders> implements CustomerOrdersFacadeLocal {

    @PersistenceContext(unitName = "VirusSphazaEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerOrdersFacade() {
        super(CustomerOrders.class);
    }
    
}
