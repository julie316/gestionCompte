
package Controller;

import EJB.ClientFacadeLocal;
import EJB.CompteFacadeLocal;
import Entity.*;
import java.io.FileInputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Eboa
 */
@ManagedBean
@SessionScoped
@Named(value = "cpteController")
public class CompteController implements Serializable {

    @EJB
    private ClientFacadeLocal clientFacade;
    @EJB
    private CompteFacadeLocal compteFacade;
    private List<Compte> listCpte;
    private List<Client> listClient;
    private CompteCourant cc;
    private CompteEpargne ce;
    String message;
    private int clientId;
    private Compte cp;
    
    public CompteController() {
    }

    public List<Compte> getListCpte() {
        this.listCpte = this.compteFacade.findAll();
        return listCpte;
    }

    public void setListCpte(List<Compte> listCpte) {
        this.listCpte = listCpte;
    }

    public CompteCourant getCc() {
        return cc;
    }

    public void setCc(CompteCourant cc) {
        this.cc = cc;
    }

    public CompteEpargne getCe() {
        return ce;
    }

    public void setCe(CompteEpargne ce) {
        this.ce = ce;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }
    
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    
    @PostConstruct
    public void init(){
        this.cc = new CompteCourant();
        this.ce = new CompteEpargne();
        this.listClient = clientFacade.findAll();
    }
    
     public void createCompteCourant(){
        try{
            Client client = clientFacade.find(this.clientId);
            this.cc.setClient(client);
            this.cc.setDateCreation(new Date());
            this.compteFacade.create(this.cc);
            this.cc = new CompteCourant();
            this.message = "Insertion réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
     
    public void createCompteEpargne(){
        try{
            Client client = clientFacade.find(this.clientId);
            this.ce.setClient(client);
            this.ce.setDateCreation(new Date());
            this.compteFacade.create(this.ce);
            this.ce = new CompteEpargne();
            this.message = "Insertion réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void deleteCompteCourant(CompteCourant cpte){
        try{
            this.compteFacade.remove(cpte);
            this.message = "Suppression réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void deleteCompteEpargne(CompteEpargne cpte){
        try{
            this.compteFacade.remove(cpte);
            this.message = "Suppression réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
 
    public void updateCourant(){
        try{
            this.compteFacade.edit(this.cc);
            this.cc = new CompteCourant();
            this.message = "Modification réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void updateEpargne(){
        try{
            this.compteFacade.edit(this.ce);
            this.ce = new CompteEpargne();
            this.message = "Modification réussie";
        } catch(Exception e){
            e.printStackTrace();
            this.message = "Erreur : "+e.getMessage();
        }
        FacesMessage fm = new FacesMessage(this.message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void editCompteCourant(CompteCourant cpteCourant){
        this.cc = cpteCourant;
    }
    
    public void resetCompteCourant(){
        this.cc = new CompteCourant();
    }

    public void editCompteEpargne(CompteEpargne cpteEpargne){
        this.ce = cpteEpargne;
    }
    
    public void resetCompteEpargne(){
        this.ce = new CompteEpargne();
    } 
    
    public void printReport(Compte compte) throws Exception{
        JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream("C:\\Users\\Eboa\\reportTest.jrxml"));
        HashMap<String, Object> parameters = new HashMap();
        parameters.put("nom_client",compte.getClient().getNomClt());
        parameters.put("num_compte",compte.getNumCpte());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Eboa\\"+compte.getNumCpte()+"-report.pdf");
    }
}
