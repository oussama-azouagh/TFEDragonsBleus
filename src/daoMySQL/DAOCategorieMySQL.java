/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOCategorie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Categorie;


/**
 *
 * @author MediaMonster
 */
public class DAOCategorieMySQL implements DAOCategorie{
    
    private static DAOCategorieMySQL uniqueInstance = new DAOCategorieMySQL();
    
    public static DAOCategorieMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    public ArrayList <Categorie> selectCategorie ()
    {
        ArrayList <Categorie> myList = new ArrayList();
        String request = "Select * from Categorie";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Categorie (resu.getInt("IdCategorie"), resu.getString("description"), resu.getInt("TarifCotisation") ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
        public boolean deleteCategorie (int idCat)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Categorie where IdCategorie = '" +
        idCat + "'");
        
        return ok;
    }
    
 
    
    /* Modifie une Categorie. On passe en paramètre l'objet Categorie contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateCategorie (Categorie cat)
    {
        String request = "Update Categorie set Description = '" + cat.getDescription() +
        "', TarifCotisation = '" + cat.getTarifCotisation() +  
        "' where IdCategorie = '" + cat.getIdCategorie() + "'";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
    
      /* Insère une Categorie passée en paramètre dans la table Categorie. Renvoie true si 
     �a s'est bien passé, false sinon */
    public boolean insertCategorie (Categorie cat)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Categorie ( IdCategorie, Description, TarifCotisation ) " +
        "values ('" + cat.getIdCategorie() + "','" + cat.getDescription() +  "','" + cat.getTarifCotisation()+
                "')");
        
        return ok;
    }
}
 