/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import transfertObject.Participation;

/**
 *
 * @author MediaMonster
 */
public interface DAOParticipation {
    
    ArrayList selectRelationParticipation ();
    
    ArrayList selectRelationParticipationParEleve (int idElv);
    
    ArrayList selectRelationParticipationParCompetition (int idComp);
    
    boolean deleteRelationParticipation (int idElv,int idComp);
    
    boolean insertRelParticipation (Participation  relPart);
    
}
