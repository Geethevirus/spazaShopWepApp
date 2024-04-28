package za.ac.tut.ejb.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-27T12:29:23")
@StaticMetamodel(Productv.class)
public class Productv_ { 

    public static volatile SingularAttribute<Productv, String> item_code;
    public static volatile SingularAttribute<Productv, Integer> quantity;
    public static volatile SingularAttribute<Productv, Double> price;
    public static volatile SingularAttribute<Productv, String> name;
    public static volatile SingularAttribute<Productv, Date> creating_date;
    public static volatile SingularAttribute<Productv, Long> id;

}