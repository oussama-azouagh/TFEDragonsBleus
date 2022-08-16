/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import transfertObject.Est;

/**
 *
 * @author MediaMonster
 */
public interface DAOEst {
    
    ArrayList selectRelationEst ();
    
    boolean deleteRelationEst (int idCompetition,int idTypeCompetition);
    
    boolean insertRelEst (Est relEst);
}
