/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Versement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eboa
 */
@Local
public interface VersementFacadeLocal {

    void create(Versement versement);

    void edit(Versement versement);

    void remove(Versement versement);

    Versement find(Object id);

    List<Versement> findAll();

    List<Versement> findRange(int[] range);

    int count();
    
}
