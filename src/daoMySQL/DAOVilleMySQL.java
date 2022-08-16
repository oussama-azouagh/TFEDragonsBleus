/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOVille;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Ville;


/**
 *
 * @author MediaMonster
 */
public class DAOVilleMySQL implements DAOVille{
  
     private static DAOVilleMySQL uniqueInstance = new DAOVilleMySQL();
    
    public static DAOVilleMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne tous les Villes et les renvoie dans une liste chaînée */
    public ArrayList <Ville> selectVille ()
    {
        ArrayList <Ville> myList = new ArrayList();
                
        String request = "Select * From Ville ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //cr�ation de l'objet Ville
                myList.add(new Ville(resu.getInt("IdVille"),resu.getString("Nom")));
             }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    public ArrayList <Ville> selectVilleParNom (String nom)
    {
        ArrayList <Ville> myList = new ArrayList();
                
        String request = "Select * From Ville where Nom like '%"+nom+"%' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //cr�ation de l'objet Ville
                myList.add(new Ville(resu.getInt("IdVille"),resu.getString("Nom")));
             }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    /* Insère une Ville passé en paramètre dans la table Ville. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertVille (Ville ville)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Ville (IdVille, Nom)" +
        " values ('" + ville.getIdVille() + "','" + ville.getNom() + "')");
        
        return ok;
    }
    
    /* Efface la Ville dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteVille (int identVille)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Ville where IdVille = '" +
        identVille + "'");
        
        return ok;
    }
    
    
    /* Modifie une Ville. On passe en paramètre l'objet Ville contenant la 
     modification (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     ça s'est bien passé, false sinon */
    public boolean updateVille (Ville ville)
    {
        String request = "Update Ville set Nom = '" + ville.getNom() + "' where IdVille = '"
        + ville.getIdVille() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
    
}
