package Entity;

import Entity.Client;
import Entity.Operation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-30T15:17:59")
@StaticMetamodel(Compte.class)
public abstract class Compte_ { 

    public static volatile SingularAttribute<Compte, String> numCpte;
    public static volatile SingularAttribute<Compte, String> typeCpte;
    public static volatile ListAttribute<Compte, Operation> op;
    public static volatile SingularAttribute<Compte, Date> dateCreation;
    public static volatile SingularAttribute<Compte, Client> client;
    public static volatile SingularAttribute<Compte, Double> solde;
    public static volatile SingularAttribute<Compte, Integer> id;

}