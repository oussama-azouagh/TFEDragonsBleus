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
public interface DAOCours {
    
    ArrayList selectCours ();
    
    ArrayList selectCoursParNom (String nom);
    
    ArrayList selectCoursParLocal (String nomLoc);
    
    boolean deleteCours (int idCours);
    
    boolean updateCours (Cours cours);
    
    boolean insertCours (Cours cours);
}
