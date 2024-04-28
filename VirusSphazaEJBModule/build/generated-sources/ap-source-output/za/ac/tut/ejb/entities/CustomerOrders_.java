package za.ac.tut.ejb.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.ejb.entities.Address;
import za.ac.tut.ejb.entities.OrderItem;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-27T12:29:23")
@StaticMetamodel(CustomerOrders.class)
public class CustomerOrders_ { 

    public static volatile SingularAttribute<CustomerOrders, Date> creation_time;
    public static volatile SingularAttribute<CustomerOrders, Address> address;
    public static volatile SingularAttribute<CustomerOrders, Double> amount_due;
    public static volatile SingularAttribute<CustomerOrders, Long> id;
    public static volatile ListAttribute<CustomerOrders, OrderItem> items;

}