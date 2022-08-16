/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOTypeCompetition;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.TypeCompetition;



/**
 *
 * @author MediaMonster
 */
public class DAOTypeCompetitionMySQL implements DAOTypeCompetition{
    
        private static DAOTypeCompetitionMySQL uniqueInstance = new DAOTypeCompetitionMySQL();
    
    public static DAOTypeCompetitionMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne touts les TypeCompetition et les renvoie dans une liste chaînée */
    public ArrayList <TypeCompetition> selectTypeCompetition ()
    {
        ArrayList <TypeCompetition> myList = new ArrayList();
                
        String request = "Select * From TypeCompetition";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet TypeCompetition
                myList.add(new TypeCompetition (resu.getInt("idTypeCompetition"),resu.getString("nomType")) );
             }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
  public ArrayList <TypeCompetition> selectTypeCompetitionParNomType (String nom)
    {
        ArrayList <TypeCompetition> myList = new ArrayList();
                
        String request = "Select * From TypeCompetition where nomType like '%"+nom+"%' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet TypeCompetition
                myList.add(new TypeCompetition (resu.getInt("idTypeCompetition"),resu.getString("nomType")) );
             }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    /* Insère un TypeCompetition passé en paramètre dans la table TypeCompetition. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertTypeCompetition (TypeCompetition typeComp)
    {
      
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into TypeCompetition (IdTypeCompetition, NomType) values ('"  
              + typeComp.getIdTypeCompetition()  + "', '" + typeComp.getNomType() + "') ");
        
        return ok;
    }
    
    /* Efface le TypeCompetition dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteTypeCompetition (int idTypeComp)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from TypeCompetition where IdTypeCompetition = '" +
        idTypeComp + "'");
        
        return ok;
    }
    
 
    
    /* Modifie un TypeCompetition. On passe en paramètre l'objet TypeCompetition contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateTypeCompetition (TypeCompetition typeComp)
    {
        String request = "Update TypeCompetition set NomType = '" + typeComp.getNomType() +
       "' where IdTypeCompetition = '" + typeComp.getIdTypeCompetition() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
}
