/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import transfertObject.*;
import java.util.ArrayList;

/**
 *
 * @author MediaMonster
 */
public interface DAOA {

   ArrayList selectRelationA (); 
    
   boolean deleteRelationA (int idGroupe,int idCours);
   
   boolean insertRelationA (A a);
   
}
