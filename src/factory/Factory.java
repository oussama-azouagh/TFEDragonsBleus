/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.*;
import daoMySQL.*;

/**
 *
 * @author MediaMonster
 */
public class Factory {
    
     public static Connexion getDAOConnexion()
    {
        return DAOConnexionMySQL.getInstance();
    }
     
     public static DAOA getDAOA()
     {
         return DAOAMySQL.getInstance();
     }
     
     public static DAOAdresse getDAOAdresse()
     {
         return DAOAdresseMySQL.getInstance();
     }
     
     public static DAOCategorie getDAOCategorie()
     {
         return DAOCategorieMySQL.getInstance();
     }
     
     public static DAOCompetition getDAOCompetition()
     {
         return DAOCompetitionMySQL.getInstance();
     }
     
     public static DAOCotisation getDAOCotisation()
     {
         return DAOCotisationMySQL.getInstance();
     }
     
     public static DAOCours getDAOCours()
     {
         return DAOCoursMySQL.getInstance();
     }
     
     public static DAOEleve getDAOEleve()
     {
         return DAOEleveMySQL.getInstance();
     }
     
     public static DAOEstInscrit getDAOEstInscrit()
     {
         return DAOEstInscritMySQL.getInstance();
     }
     
     public static DAOEst getDAOest()
     {
         return DAOEstMySQL.getInstance();
     }
     
     public static DAOGroupe getDAOGroupe()
     {
         return DAOGroupeMySQL.getInstance();
     }
     
     public static DAOInscritPour getDAOInscritPour()
     {
         return DAOInscritPourMySQL.getInstance();
     }
     
     public static DAOLocal getDAOLocal()
     {
         return DAOLocalMySQL.getInstance();
     }
     
     public static DAOMoniteur getDAOMoniteur()
     {
         return DAOMoniteurMySQL.getInstance();
     }
     
     public static DAOOccupe getDAOOccupe()
     {
         return DAOOccupeMySQL.getInstance();
     }
     
     public static DAOParticipation getDAOParticipation()
     {
         return DAOParticipationMySQL.getInstance();
     }
     
     public static DAOParticipe getDAOParticipe()
     {
         return DAOParticipeMySQL.getInstance();
     }
     
     public static DAOPassageDeGrade getDAOPassageDeGrade()
     {
         return DAOPassageDeGradeMySQL.getInstance();
     }
     
     public static DAOPaye getDAOPaye()
     {
         return DAOPayeMySQL.getInstance();
     }
     
     public static DAOPayementEnPlusieursParties getDAOPayementEnPlusieursParties()
     {
         return DAOPayementEnPlusieursPartiesMySQL.getInstance();
     }
     
     public static DAOStage getDAOStage()
     {
         return DAOStageMySQL.getInstance();
     }
     
     public static DAOSuit getDAOsuit()
     {
         return DAOSuitMySQL.getInstance();
     }
     
     public static DAOTypeCompetition getDAOTypeCompetition()
     {
         return DAOTypeCompetitionMySQL.getInstance();
     }
     
     public static DAOVille getDAOVille()
     {
         return DAOVilleMySQL.getInstance();
     }
}
