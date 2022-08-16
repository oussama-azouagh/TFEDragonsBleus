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
public interface DAOGroupe {
    
    ArrayList selectGroupe ();
    
    ArrayList selectGroupeParNom (String nom);
    
    boolean deleteGroupe (int idGrp);
    
    boolean updateGroupe (Groupe grp);
    
    boolean insertGroupe (Groupe grp);
}
