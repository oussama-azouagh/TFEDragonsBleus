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
public interface DAOLocal {
    
    ArrayList selectLocal ();
    
    ArrayList selectLocalParNom (String nom);
    
    boolean deleteLocal (int idLoc);
    
    boolean updateLocal (Local loc);
    
    boolean insertLocal (Local  loc);
    
}
