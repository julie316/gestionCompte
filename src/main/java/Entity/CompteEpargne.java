
package Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE_EPARGNE")
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
    @Column(name = "TAUX")
    private double taux;

    public CompteEpargne() {
    }

    public CompteEpargne(int id, String numCpte, Client client, String typeCpte, double solde, Date dateCreation,double taux) {
        super(id, numCpte, client, typeCpte, solde, dateCreation);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
    
}
