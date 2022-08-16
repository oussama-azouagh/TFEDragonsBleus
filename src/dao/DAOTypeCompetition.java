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
public interface DAOTypeCompetition {
    
    ArrayList selectTypeCompetition ();
    
    ArrayList selectTypeCompetitionParNomType (String nom);
    
    boolean insertTypeCompetition (TypeCompetition typeComp);
    
    boolean updateTypeCompetition (TypeCompetition typeComp);
    
    boolean deleteTypeCompetition (int idTypeComp);
}
