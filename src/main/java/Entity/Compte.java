
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Compte implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NUM_CPTE")
    private String numCpte;
    @ManyToOne
    @JoinColumn(name="CLIENT_ID")
    private Client client;
    @Column(name = "TYPE_CPTE")
    private String typeCpte;
    @Column(name = "SOLDE")
    private double solde;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DATE_CREATION")
    private Date dateCreation;
    @OneToMany(mappedBy="compte")
    private List<Operation> op;

    public Compte() {
    }

    public Compte(int id, String numCpte, Client client, String typeCpte, double solde, Date dateCreation) {
        this.id = id;
        this.numCpte = numCpte;
        this.client = client;
        this.typeCpte = typeCpte;
        this.solde = solde;
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumCpte() {
        return numCpte;
    }

    public void setNumCpte(String numCpte) {
        this.numCpte = numCpte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTypeCpte() {
        return typeCpte;
    }

    public void setTypeCpte(String typeCpte) {
        this.typeCpte = typeCpte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Operation> getOp() {
        return op;
    }

    public void setOp(List<Operation> op) {
        this.op = op;
    }
    
}
