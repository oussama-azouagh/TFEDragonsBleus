/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import transfertObject.Ville;

/**
 *
 * @author MediaMonster
 */
public interface DAOVille {
    
    ArrayList selectVille ();
    
    ArrayList selectVilleParNom (String nom);
    
    boolean insertVille (Ville ville);
    
    boolean deleteVille (int identVille);
    
    boolean updateVille (Ville ville);
}
