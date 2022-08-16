/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOAdresse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Ville;
import transfertObject.Adresse;

/**
 *
 * @author MediaMonster
 */
public class DAOAdresseMySQL implements DAOAdresse{
 
       private static DAOAdresseMySQL uniqueInstance = new DAOAdresseMySQL();
    
    public static DAOAdresseMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne tous les Adresses et les renvoie dans une liste chaînée */
    public ArrayList <Adresse> selectAdresse ()
    {
        ArrayList <Adresse> myList = new ArrayList();
                
        String request = "Select IdAdresse, NomAdresse, Numero, Boite, CodePostal, A.IdVille, V.IdVille, V.Nom From A.Adresse, V.Ville Where A.IdVille = V.IdVille ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Adresse
                myList.add(new Adresse(resu.getInt("IdAdresse"),resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),
                    resu.getInt("CodePostal"),new Ville(resu.getInt("IdVille"),resu.getString("Nom") )
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
    
    /* Insère une Adresse passée en paramètre dans la table Adresse. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertAdresse (Adresse adresse)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into adresse (IdAdresse, NomAdresse, Numero, Boite, CodePostal, Ville)" +
        " values ('" + adresse.getIdAdresse() + "','" + adresse.getNomAdresse() +
         "','" + adresse.getNumero() + "', '" + adresse.getBoite() + "','" + adresse.getCodePostal() + "','" + adresse.getIdVille() + "' )"  );
        
        return ok;
    }
    
    /* Efface l'Adresse dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteAdresse (int idAdresse)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Adresse where IdAdresse = '" +
        idAdresse+ "'");
        
        return ok;
    }
    
    
    /* Modifie une Adresse. On passe en paramètre l'objet Adresse contenant les
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     ça s'est bien passé, false sinon */
    public boolean updateAdresse (Adresse adresse)
    {
       String request = "Update Adresse set NomAdresse = '" + adresse.getNomAdresse() +
        "', Numero = " + adresse.getNumero() + ", Boite = " + adresse.getBoite() +
        ", CodePostal = '" + adresse.getCodePostal() + "', IdVille = " + adresse.getIdVille().getIdVille() + " where IdAdresse = '"
        + adresse.getIdAdresse() + "'";
               
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }    

  
  
}
