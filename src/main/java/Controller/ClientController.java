
package Controller;

import EJB.ClientFacadeLocal;
import Entity.Client;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean
@SessionScoped
@Named(value = "clientController")
public class ClientController implements Serializable{
    @EJB
    private ClientFacadeLocal clientFacade;
    private List<Client> listClt;
    private Client client;
    String message;

    public List<Client> getListClt() {
        this.listClt = this.clientFacade.findAll();
        return listClt;
    }

    public void setListClt(List<Client> listClt) {
        this.listClt = listClt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    @PostConstruct
    public void init(){
        this.client = new Client();
    }
    
    public void create(){
        try{
            this.clientFacade.create(this.client);
            this.client = new Client();
            this.message = "Insertion réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void update(){
        try{
            this.clientFacade.edit(this.client);
            this.client = new Client();
            this.message = "Modification réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void delete(Client clt){
        try{
            this.clientFacade.remove(clt);
            this.message = "Suppression réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void edit(Client clt){
        this.client = clt;
    }
    
    public void reset(){
        this.client = new Client();
    }
    
}
