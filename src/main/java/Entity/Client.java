
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name = "CODE_CLIENT")
   private String codeClt;
   @Column(name = "NOM_CLIENT")
   private String nomClt;
   @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
   private List<Compte> cp;

    public Client() {
    }
    
    public Client(int id, String codeClt, String nomClt) {
        this.id = id;
        this.codeClt = codeClt;
        this.nomClt = nomClt;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeClt() {
        return codeClt;
    }

    public void setCodeClt(String codeClt) {
        this.codeClt = codeClt;
    }

    public String getNomClt() {
        return nomClt;
    }

    public void setNomClt(String nomClt) {
        this.nomClt = nomClt;
    }

    public List<Compte> getCp() {
        return cp;
    }

    public void setCp(List<Compte> cp) {
        this.cp = cp;
    }
   
   
}
