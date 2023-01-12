/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Retrait;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eboa
 */
@Local
public interface RetraitFacadeLocal {

    void create(Retrait retrait);

    void edit(Retrait retrait);

    void remove(Retrait retrait);

    Retrait find(Object id);

    List<Retrait> findAll();

    List<Retrait> findRange(int[] range);

    int count();
    
}
