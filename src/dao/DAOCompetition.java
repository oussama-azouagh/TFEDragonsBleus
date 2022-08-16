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
public interface DAOCompetition {
    
    ArrayList selectCompetition ();
    
    ArrayList selectCompetitionParNom (String nom);
    
    ArrayList selectCompetitionParType (String nomType);
    
    ArrayList selectCompetitionParDateEvenement (Date date,Date jour);
    
    ArrayList selectCompetitionParDateInscription (Date date);
    
    ArrayList selectCompetitionParLieu (String lieu);
    
    boolean insertCompetition (Competition comp);
    
    boolean deleteCompetition (int ident);
    
    boolean updateCompetition (Competition comp);
    
}
