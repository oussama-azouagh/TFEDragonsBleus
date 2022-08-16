/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOCours;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Cours;
import transfertObject.Local;

/**
 *
 * @author MediaMonster
 */
public class DAOCoursMySQL implements DAOCours{
    
    private static DAOCoursMySQL uniqueInstance = new DAOCoursMySQL();
    
    public static DAOCoursMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    public ArrayList <Cours> selectCours ()
    {
        ArrayList <Cours> myList = new ArrayList();
        String request = "Select * from Cours";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next()) 
            {
                myList.add (new Cours (resu.getInt("IdCours"), resu.getString("Nom"), resu.getString("HeureDebut"),
                    resu.getString("HeureFin"), resu.getString("Jours") ,new Local(resu.getInt("IdLocal"),resu.getString("NomLocal") ) ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
    public ArrayList <Cours> selectCoursParNom (String nom)
    {
        ArrayList <Cours> myList = new ArrayList();
        String request = "Select * from Cours where Nom Like '" +nom + "' order by 1  ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next()) 
            {
                myList.add (new Cours (resu.getInt("IdCours"), resu.getString("Nom"), resu.getString("HeureDebut"),
                    resu.getString("HeureFin"), resu.getString("Jours") ,new Local(resu.getInt("IdLocal"),resu.getString("NomLocal") ) ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
    public ArrayList <Cours> selectCoursParLocal (String nomLoc)
    {
        ArrayList <Cours> myList = new ArrayList();
        String request = "Select * from Cours C, Local L WHERE C.IdLocal =L.IdLocal AND NomLocal Like '" +nomLoc + "' order by 1  ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next()) 
            {
                myList.add (new Cours (resu.getInt("IdCours"), resu.getString("Nom"), resu.getString("HeureDebut"),
                    resu.getString("HeureFin"), resu.getString("Jours") ,new Local(resu.getInt("IdLocal"),resu.getString("NomLocal") ) ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
    
        public boolean deleteCours (int idCours)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Cours where IdCours = '" +
        idCours + "'");
        
        return ok;
    }
    
 
    
    /* Modifie un Cours. On passe en paramètre l'objet Cours contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateCours (Cours cours)
    {
        String request = "Update Cours set Nom = '" + cours.getNom() +
        "', HeureDebut = '" + cours.getHeureDebut() + "', HeureFin = '" + cours.getHeureFin() +
        "', Jours = '" + cours.getJours() + "', IdLocal = '" + cours.getIdLocal().getIdLocal() +    
        "' where IdCours = '" + cours.getIdCours() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
    
    
       /* Insère un Cours passé en paramètre dans la table Cours. Renvoie true si 
     �a s'est bien passé, false sinon */
    public boolean insertCours (Cours cours)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Cours (IdCours ,Nom ,HeureDebut ,HeureFin ,Jours , IdLocal) " +
        "values ('" + cours.getIdCours() + "','" + cours.getNom() + "','" + cours.getHeureDebut() + "','" + cours.getHeureFin() +                 
         "','" + cours.getJours() + "','" + cours.getIdLocal().getIdLocal() +      
                ")");
        
        return ok;
    }
}
