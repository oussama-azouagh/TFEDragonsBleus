/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOEst;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Est;
import transfertObject.Competition;
import transfertObject.TypeCompetition;


/**
 *
 * @author MediaMonster
 */
public class DAOEstMySQL implements DAOEst{
    
    private static DAOEstMySQL uniqueInstance = new DAOEstMySQL();
    
    public static DAOEstMySQL getInstance()
    {
        return uniqueInstance;
    }
   
      /* Sélectionne toutes les relationEst (Competition-TypeCompetition) et les renvoie dans une liste chaînée */
    public ArrayList <Est> selectRelationEst ()
    {
        ArrayList <Est> myList = new ArrayList();
        String request = "Select E.IdCompetition, E.IdTypeCompetition, C.IdCompetition, C.Nom, C.DateEvenement, C.DateLimiteInscription"
                + " C.PrixInscription, C.Lieu, C.Duree, C.IdTypeCompetition, T.IdTypeCompetion, T.nomType "
                + "From E.Est, C.Competition, T.TypeCompetition Where E.IdCompetition = C.IdCompetition "
                + "And C.IdTypeCompetition = T.IdTypeCompetition";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Est ( new Competition(resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree") ),
                       new TypeCompetition( resu.getInt("idTypeCompetition"),resu.getString("nomType"))
                     ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
        /* Efface la relationEst (Competition-TypeCompetition) dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteRelationEst (int idCompetition,int idTypeCompetition)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Est where IdCompetition = '" +
        idCompetition +  "' And idTypeCompetition = '" + idTypeCompetition + "' ");
        
        return ok;
    }
    

    
    /* Modifie une relationEst (Competition-TypeCompetition). On passe en paramètre l'objet Cotisation contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
   // public boolean updateRelationEst (Competition comp,TypeCompetition typeComp )
   // {
   // }
   // pas besoin car Relation a des id en table uniquement
    
    
    /* Insère une relation Est(Competition-TypeCompetition) passée en paramètre dans la table Est. Renvoie true si 
     ça s'est bien passé, false sinon */
    public boolean insertRelEst (Est relEst)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Est (IdCompetition, IdTypeCompetition)" +
        " values ('" + relEst.getIdCompetition() + "','" + relEst.getIdTypeCompetition() +
        ")");
        
        return ok;
    }
 
}
