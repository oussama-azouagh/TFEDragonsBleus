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
public interface DAOSuit {
    
    ArrayList selectRelationSuit ();
    
    ArrayList selectRelationSuitParEleve (int idElv);
    
    ArrayList selectRelationSuitParStage (int idSta);
    
    boolean deleteRelationSuit (int idElv,int idSta);
    
    boolean insertRelSuit (Suit  relSuit);
}
