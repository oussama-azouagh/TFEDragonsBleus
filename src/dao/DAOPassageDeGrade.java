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
public interface DAOPassageDeGrade {
    
    ArrayList selectPassageDeGrade ();
    
    ArrayList selectPassageDeGradeParGrade (String grade);
    
    ArrayList selectPassageDeGradeParDate (Date datepass, Date jour);
    
    boolean insertPassageDeGrade (PassageDeGrade pass);
    
    boolean deletePassageDeGrade (int idPass);
    
    boolean updatePassageDeGrade (PassageDeGrade pass);
    
}
