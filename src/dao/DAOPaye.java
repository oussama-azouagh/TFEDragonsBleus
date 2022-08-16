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
public interface DAOPaye {
    
    ArrayList selectRelationPaye ();
    
    ArrayList selectRelationPayeParEleve (int idElv);
    
    ArrayList selectRelationPayeParCotisation (int idCoti);
    
    boolean deleteRelationPaye (int idElv,int idCoti);
    
    boolean insertRelPaye (Paye  relPay);
    
}
