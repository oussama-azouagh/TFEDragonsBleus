/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOA;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.A;
import transfertObject.Cours;
import transfertObject.Groupe;
import transfertObject.Local;

/**
 *
 * @author MediaMonster
 */
public class DAOAMySQL implements DAOA {
    
     private static DAOAMySQL uniqueInstance = new DAOAMySQL();
    
    public static DAOAMySQL getInstance()
    {
        return uniqueInstance;
    }
    
     /* Sélectionne toutes les relationA (Groupe-Cours) et les renvoie dans une liste chaînée */
    public ArrayList <A> selectRelationA ()
    {
        ArrayList <A> myList = new ArrayList();
        String request = "Select * from A";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new A ( new Groupe(resu.getInt("IdGroupe"), resu.getString("Nom"), resu.getString("Année"),
                    resu.getInt("AgeMin"), resu.getInt("AgeMax" ) ),
                       new Cours( resu.getInt("IdCours"), resu.getString("Nom"), resu.getString("HeureDebut"),
                    resu.getString("HeureFin"), resu.getString("Jours") ,new Local(resu.getInt("IdLocal"),resu.getString("NomLocal")) )
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
    
    
        /* Efface la relationA (Groupe-Cours) dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteRelationA (int idGroupe,int idCours)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from A where IdGroupe = '" +
        idGroupe +  "' And idCours = '" + idCours + "' ");
        
        return ok;
    }
    

    
    /* Modifie une relationA (Groupe-Cours). On passe en paramètre l'objet Cotisation contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
   // public boolean updateRelationA (Groupe grp,Cours cours )
   // {
   // }
   // pas besoin car Relation a des id en table uniquement
    
    
    
     /* Insère une RelationA(Groupe-Cours) passée en paramètre dans la table A. Renvoie true si 
     �a s'est bien passé, false sinon */
    public boolean insertRelationA (A a)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into A (IdGroupe, IdCours ) " +
        "values ('" + a.getIdGroupe() + "','" + a.getIdCours() +")");
        
        return ok;
    }
 
}
