/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.CompteEpargne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eboa
 */
@Stateless
public class CompteEpargneFacade extends AbstractFacade<CompteEpargne> implements CompteEpargneFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_gestionCompte_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteEpargneFacade() {
        super(CompteEpargne.class);
    }
    
}
