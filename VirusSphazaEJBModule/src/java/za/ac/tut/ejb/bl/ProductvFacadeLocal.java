/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.ejb.entities.Productv;

/**
 *
 * @author Gonts
 */
@Local
public interface ProductvFacadeLocal {

    void create(Productv productv);

    void edit(Productv productv);

    void remove(Productv productv);

    Productv find(Object id);

    List<Productv> findAll();

    List<Productv> findRange(int[] range);

    int count();
    
}
