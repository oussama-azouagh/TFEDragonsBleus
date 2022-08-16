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
public interface DAOEleve {
    
    ArrayList selectEleve ();
    
    ArrayList selectEleveParNom (String nom);
    
    ArrayList selectEleveParCategorie (String cate);
    
    ArrayList selectEleveParAdresse (String adr);
    
    boolean deleteEleve (int idEleve);
    
    boolean updateEleve (Eleve elv);
    
    boolean insertEleve (Eleve elv);
    
}
