package Entity;

import Entity.Compte;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-30T15:17:59")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> codeClt;
    public static volatile SingularAttribute<Client, String> nomClt;
    public static volatile ListAttribute<Client, Compte> cp;

}