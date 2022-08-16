/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import transfertObject.InscritPour;

/**
 *
 * @author MediaMonster
 */
public interface DAOInscritPour {
    
    ArrayList selectRelationInscritPour ();
    
    ArrayList selectRelationInscritPourParMoniteur (int idMoni);
    
    ArrayList selectRelationInscritPourParCompetition (int idComp);
    
    boolean deleteRelationInscritPour (int idMoni,int idComp);
    
    boolean insertRelInscritPour (InscritPour  relInscr);
}
