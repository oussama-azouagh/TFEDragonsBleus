/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import transfertObject.EstInscrit;

/**
 *
 * @author MediaMonster
 */
public interface DAOEstInscrit {
    
    ArrayList <EstInscrit> selectRelationEstInscrit ();
    
    ArrayList selectRelationEstInscritParGroupe (int idGrp);
    
    ArrayList selectRelationEstInscritParEleve (int idElv);
    
    boolean deleteRelationEstInscrit (int idElv,int idGrp);
    
    boolean insertEstInscrit (EstInscrit relEstIns);
}
