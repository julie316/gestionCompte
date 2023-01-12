
package Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE_COURANT")
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
    @Column(name = "DECOUVERT")
    private double decouvert;

    public CompteCourant() {
    }

    public CompteCourant(int id, String numCpte, Client client, String typeCpte, double solde, Date dateCreation,double decouvert) {
        super(id, numCpte, client, typeCpte, solde, dateCreation);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
    
}
