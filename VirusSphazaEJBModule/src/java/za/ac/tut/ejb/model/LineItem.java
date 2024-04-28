/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.ejb.model;

import za.ac.tut.ejb.entities.Productv;

/**
 *
 * @author Gonts
 */
public class LineItem {
    
    private Productv product;
    private Integer quantity;

    public LineItem(Productv product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    
    public Productv getProduct() {
        return product;
    }

    public void setProduct(Productv product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
}
