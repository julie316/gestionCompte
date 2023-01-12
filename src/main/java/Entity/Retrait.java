
package Entity;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RETRAIT")
@DiscriminatorValue("1")
public class Retrait extends Operation{

    public Retrait() {
    }

    public Retrait(Integer id, Compte compte, double montant, Date dateOperation) {
        super(id, compte, montant, dateOperation);
    }
    
}
