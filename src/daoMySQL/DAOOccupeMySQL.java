/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOOccupe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Moniteur;
import transfertObject.Occupe;
import transfertObject.Cours;
import transfertObject.Local;
import transfertObject.Ville;

/**
 *
 * @author MediaMonster
 */
public class DAOOccupeMySQL implements DAOOccupe{
    
    private static DAOOccupeMySQL uniqueInstance = new DAOOccupeMySQL();
    
    public static DAOOccupeMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne toutes les relationOccupe (Moniteur-Cours) et les renvoie dans une liste chaînée */
    public ArrayList <Occupe> selectRelationOccupe ()
    {
        ArrayList <Occupe> myList = new ArrayList();
        String request = "Select * from Occupe";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Occupe ( new Moniteur( resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                       new Cours(resu.getInt("IdCours"), resu.getString("Nom"), resu.getString("HeureDebut"),
                    resu.getString("HeureFin"), resu.getString("Jours") ,new Local(resu.getInt("IdLocal"),resu.getString("NomLocal") ) )
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
    
    
    
     public ArrayList <Occupe> selectRelationOccupeParMoniteur (int idMoni)
    {
        ArrayList <Occupe> myList = new ArrayList();
        String request = "Select * from Occupe where IdMoniteur = '"+idMoni+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Occupe ( new Moniteur( resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                       new Cours(resu.getInt("IdCours"), resu.getString("Nom"), resu.getString("HeureDebut"),
                    resu.getString("HeureFin"), resu.getString("Jours") ,new Local(resu.getInt("IdLocal"),resu.getString("NomLocal") ) )
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
    
     public ArrayList <Occupe> selectRelationOccupeParCours (int idCours)
    {
        ArrayList <Occupe> myList = new ArrayList();
        String request = "Select * from Occupe where IdCours = '"+idCours+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Occupe ( new Moniteur( resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                       new Cours(resu.getInt("IdCours"), resu.getString("Nom"), resu.getString("HeureDebut"),
                    resu.getString("HeureFin"), resu.getString("Jours") ,new Local(resu.getInt("IdLocal"),resu.getString("NomLocal") ) )
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
     
        /* Efface la relationOccupe (Moniteur-Cours) dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteRelationOccupe (int idMoni,int idCours)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from EstInscrit where IdMoniteur = '" +
        idMoni +  "' And idCours = '" + idCours + "' ");
        
        return ok;
    }
    

    
    /* Modifie une relationEst (Competition-TypeCompetition). On passe en paramètre l'objet Cotisation contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
   // public boolean updateRelationEst (Competition comp,TypeCompetition typeComp )
   // {
   // }
   // pas besoin car Relation a des id en table uniquement
    
    
     /* Insère une relation Occupe (Moniteur-Cours) passée en paramètre dans la table Occupe. Renvoie true si 
     ça s'est bien passé, false sinon */
    public boolean insertRelOccupe (Occupe  relOcc)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Occupe ( IdMoniteur, IdCours)" +
        " values ('" + relOcc.getIdMoniteur() + "','" + relOcc.getIdCours() +
        ")");
        
        return ok;
    }
    
}
