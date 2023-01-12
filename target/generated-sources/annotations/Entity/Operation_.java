package Entity;

import Entity.Compte;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-30T15:17:59")
@StaticMetamodel(Operation.class)
public abstract class Operation_ { 

    public static volatile SingularAttribute<Operation, String> typeOperation;
    public static volatile SingularAttribute<Operation, Double> montant;
    public static volatile SingularAttribute<Operation, Integer> id;
    public static volatile SingularAttribute<Operation, Date> dateOperation;
    public static volatile SingularAttribute<Operation, Compte> compte;

}