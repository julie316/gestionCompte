
package Controller;

import EJB.CompteFacadeLocal;
import EJB.OperationFacadeLocal;
import Entity.*;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Eboa
 */
@ManagedBean
@Named(value = "operationController")
@SessionScoped
public class OperationController implements Serializable {

    @EJB
    private CompteFacadeLocal compteFacade;
    @EJB
    private OperationFacadeLocal operationFacade;
    private Operation operation;
    private List<Operation> listOperation;
    private List<Compte> listCompte;
    private Retrait retrait;
    private Versement versement;
    private int compteNumber;
    private int cpteNumber;
    String message;
    
    public OperationController() {
    }

    public List<Operation> getListOperation() {
        this.listOperation = this.operationFacade.findAll();
        return listOperation;
    }

    public void setListOperation(List<Operation> listOperation) {
        this.listOperation = listOperation;
    }

    public List<Compte> getListCompte() {
        return listCompte;
    }

    public void setListCompte(List<Compte> listCompte) {
        this.listCompte = listCompte;
    }

    public int getCompteNumber() {
        return compteNumber;
    }

    public void setCompteNumber(int compteNumber) {
        this.compteNumber = compteNumber;
    }

    public int getCpteNumber() {
        return cpteNumber;
    }

    public void setCpteNumber(int cpteNumber) {
        this.cpteNumber = cpteNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Retrait getRetrait() {
        return retrait;
    }

    public void setRetrait(Retrait retrait) {
        this.retrait = retrait;
    }

    public Versement getVersement() {
        return versement;
    }

    public void setVersement(Versement versement) {
        this.versement = versement;
    }
    
    @PostConstruct
    public void init(){
        this.retrait = new Retrait();
        this.versement = new Versement();
        this.listCompte = this.compteFacade.findAll();
    }
    
    public void createRetrait(){
        try{
            Compte compte = this.compteFacade.find(this.compteNumber);
            this.retrait.setCompte(compte);
            this.retrait.setDateOperation(new Date());
            this.operationFacade.create(this.retrait);
            this.retrait = new Retrait();
            compte.setSolde(compte.getSolde()-this.retrait.getMontant());
            this.compteFacade.edit(compte);
            this.message = "Opération réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void createVersement(){
        try{
            Compte compte = this.compteFacade.find(this.compteNumber);
            this.versement.setCompte(compte);
            this.versement.setDateOperation(new Date());
            this.operationFacade.create(this.versement);
            this.versement = new Versement();
            compte.setSolde(compte.getSolde()+this.versement.getMontant());
            this.compteFacade.edit(compte);
            this.message = "Opération réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void createVirement(){
        try{
            // rechercher le compte du déposant et retirer le montant du solde
            Compte cp1 = this.compteFacade.find(this.compteNumber);
            cp1.setSolde(cp1.getSolde()-this.versement.getMontant());
            this.compteFacade.edit(cp1);
            // rechercher le compte du dépositaire et verser le montant dans le solde
            Compte cp2 = this.compteFacade.find(this.cpteNumber);
            cp2.setSolde(cp2.getSolde()+this.versement.getMontant());
            this.compteFacade.edit(cp2);
            this.versement = new Versement();
            this.message = "Opération réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void resetRetrait(){
        this.retrait = new Retrait();
    }
    
    public void resetVersement(){
        this.versement = new Versement();
    }
}
