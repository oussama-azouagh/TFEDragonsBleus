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
public interface DAOOccupe {
    
    ArrayList selectRelationOccupe ();
    
    ArrayList selectRelationOccupeParCours (int idCours);
    
    ArrayList selectRelationOccupeParMoniteur (int idMoni);
    
    boolean deleteRelationOccupe (int idMoni,int idCours);
    
    boolean insertRelOccupe (Occupe  relOcc);
}
