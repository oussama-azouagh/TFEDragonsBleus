/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.util.ArrayList;
import transfertObject.*;

/**
 *
 * @author MediaMonster
 */
public interface DAOStage {
    
    ArrayList selectStage();
    
    ArrayList selectStageParNom (String nom);
    
    ArrayList selectStageParDateInscription (Date date);
    
    ArrayList selectStageParDateEvenement (Date date, Date jour);
    
    ArrayList selectStageParLieu (String lieu);
    
    boolean insertStage (Stage sta);
    
    boolean deleteStage (int idSta);
    
    boolean updateStage (Stage sta);
}
