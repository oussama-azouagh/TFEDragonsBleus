/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import transfertObject.Participe;

/**
 *
 * @author MediaMonster
 */
public interface DAOParticipe {
    
    ArrayList selectRelationParticipe ();
    
    ArrayList selectRelationParticipeParMoniteur (int idMoni);
    
    ArrayList selectRelationParticipeParStage (int idSta);
    
    boolean deleteRelationParticipe (int idMoni,int idSta);
    
    boolean insertRelParticipe (Participe  relPart);
    
}
