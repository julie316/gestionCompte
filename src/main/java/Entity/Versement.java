
package Entity;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VERSEMENT")
@DiscriminatorValue("2")
public class Versement extends Operation{

    public Versement() {
    }

    public Versement(Integer id, Compte compte, double montant, Date dateOperation) {
        super(id, compte, montant, dateOperation);
    }

   
}
