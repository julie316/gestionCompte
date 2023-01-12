/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.CompteEpargne;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eboa
 */
@Local
public interface CompteEpargneFacadeLocal {

    void create(CompteEpargne compteEpargne);

    void edit(CompteEpargne compteEpargne);

    void remove(CompteEpargne compteEpargne);

    CompteEpargne find(Object id);

    List<CompteEpargne> findAll();

    List<CompteEpargne> findRange(int[] range);

    int count();
    
}
