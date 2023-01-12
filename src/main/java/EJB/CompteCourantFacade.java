/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.CompteCourant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eboa
 */
@Stateless
public class CompteCourantFacade extends AbstractFacade<CompteCourant> implements CompteCourantFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_gestionCompte_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteCourantFacade() {
        super(CompteCourant.class);
    }
    
}
