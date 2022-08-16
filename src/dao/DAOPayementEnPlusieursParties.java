/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import transfertObject.*;

/**
 *
 * @author MediaMonster
 */
public interface DAOPayementEnPlusieursParties {
    
    ArrayList selectPayementEnPlusieursParties ();
    
    ArrayList selectPayementEnPlusieursPartiesParMontant (int mont);
    
    ArrayList selectPayementEnPlusieursPartiesParNombreVersement (int nbre);
    
    boolean deletePayementEnPlusieursParties (int idPayement);
    
    boolean updateEleve (PayementEnPlusieursParties pay);
    
    boolean insertPayementEnPlusieursParties (PayementEnPlusieursParties  pls);
}
