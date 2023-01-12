
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "OPERATION")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_OPERATION",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Operation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="COMPTE_ID")
    private Compte compte;
    @Column(name = "MONTANT")
    private double montant;
    @Column(name = "TYPE_OPERATION")
    private String typeOperation;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DATE_OPERATION")
    private Date dateOperation;

    public Operation() {
    }

    public Operation(int id, Compte compte, double montant, Date dateOperation) {
        this.id = id;
        this.compte = compte;
        this.montant = montant;
        this.dateOperation = dateOperation;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }
    
}
