/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOGroupe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Groupe;


/**
 *
 * @author MediaMonster
 */
public class DAOGroupeMySQL implements DAOGroupe{
    
    private static DAOGroupeMySQL uniqueInstance = new DAOGroupeMySQL();
    
    public static DAOGroupeMySQL getInstance()
    {
        return uniqueInstance;
    }
    
     public ArrayList <Groupe> selectGroupe ()
    {
        ArrayList <Groupe> myList = new ArrayList();
        String request = "Select * from Groupe";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next()) 
            {
                myList.add (new Groupe (resu.getInt("IdGroupe"), resu.getString("Nom"), resu.getString("Année"),
                    resu.getInt("AgeMin"), resu.getInt("AgeMax") ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
     
     public ArrayList <Groupe> selectGroupeParNom (String nom)
    {
        ArrayList <Groupe> myList = new ArrayList();
        String request = "Select * from Groupe Where Nom Like '"+nom+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next()) 
            {
                myList.add (new Groupe (resu.getInt("IdGroupe"), resu.getString("Nom"), resu.getString("Année"),
                    resu.getInt("AgeMin"), resu.getInt("AgeMax") ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
        public boolean deleteGroupe (int idGrp)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Groupe where IdGroupe = '" +
        idGrp + "'");
        
        return ok;
    }
    
 
    
    /* Modifie un Groupe. On passe en paramètre l'objet Groupe contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateGroupe (Groupe grp)
    {
        String request = "Update Groupe set Nom = '" + grp.getNom() +
        "', Année = '" + grp.getAnnée() + "', AgeMin= '" + grp.getAgeMin() +
        "', AgeMAx = '" + grp.getAgeMax() +    
        "' where IdGroupe = '" + grp.getIdGroupe() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
    
    
    /* Insère un Groupe passé en paramètre dans la table Groupe. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertGroupe (Groupe grp)
    {
        //System.out.println("Date arriv�e : " + app.getDateArriveeSQL());
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Groupe (IdGroupe, Nom, Année, " +
        "AgeMin, AgeMax) values ('" + grp.getIdGroupe() + "','" + grp.getNom() +
        "'," + grp.getAnnée() + "," + grp.getAgeMin() + ",'" + grp.getAgeMax() +  ")");
        
        return ok;
    }
}
