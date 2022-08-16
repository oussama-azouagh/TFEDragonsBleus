/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOLocal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Local;


/**
 *
 * @author MediaMonster
 */
public class DAOLocalMySQL implements DAOLocal{
    
    private static DAOLocalMySQL uniqueInstance = new DAOLocalMySQL();
    
    public static DAOLocalMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne tous les Locaux et les renvoie dans une liste chaînée */
    public ArrayList <Local> selectLocal ()
    {
        ArrayList <Local> myList = new ArrayList();
        String request = "Select * from Local";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Local(resu.getInt("IdLocal"), resu.getString("Nom") ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
     public ArrayList <Local> selectLocalParNom (String nom)
    {
        ArrayList <Local> myList = new ArrayList();
        String request = "Select * from Local Where nom Like '"+nom+"'";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Local(resu.getInt("IdLocal"), resu.getString("Nom") ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
        /* Efface le Local dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteLocal (int idLoc)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Local where IdLocal = '" +
        idLoc + "'");
        
        return ok;
    }
    
 
    
    /* Modifie un Local. On passe en paramètre l'objet Local contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateLocal (Local loc)
    {
        String request = "Update Local set nom = '" + loc.getNomLocal() +      
        "' where IdLocal = '" + loc.getIdLocal() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
    
     /* Insère un Local passé en paramètre dans la table Local. Renvoie true si 
     �a s'est bien passé, false sinon */
    public boolean insertLocal (Local  loc)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Local ( nom)" +
        " values ('" + loc.getNomLocal() +
        "')");
        //'" + loc.getIdLocal() + "',
        return ok;
    }
    
    
}
