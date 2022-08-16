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
public interface DAOMoniteur {
    
    ArrayList selectMoniteur ();
    
    ArrayList selectMoniteurParAdresse (String adr);
    
    ArrayList selectMoniteurParVille (String ville);
    
    boolean deleteMoniteur (int idMoni);
    
    boolean updateMoniteur (Moniteur moni);
    
    boolean insertMoniteur (Moniteur moni);
    
}
