/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOSuit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Categorie;
import transfertObject.Stage;
import transfertObject.Eleve;
import transfertObject.Suit;
import transfertObject.Ville;

/**
 *
 * @author MediaMonster
 */
public class DAOSuitMySQL implements DAOSuit{
    
    private static DAOSuitMySQL uniqueInstance = new DAOSuitMySQL();
    
    public static DAOSuitMySQL getInstance()
    {
        return uniqueInstance;
    }
    
     /* Sélectionne toutes les relationSuit (Eleve-Stage) et les renvoie dans une liste chaînée */
    public ArrayList <Suit> selectRelationSuit ()
    {
        ArrayList <Suit> myList = new ArrayList();
        String request = "Select * from Suit";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Suit ( new Eleve(resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )  ),
                       new Stage( resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("nbreMax"),resu.getInt("duree") )
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
    
    public ArrayList <Suit> selectRelationSuitParEleve (int idElv)
    {
        ArrayList <Suit> myList = new ArrayList();
        String request = "Select * from Suit where IdEleve = '"+idElv+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Suit ( new Eleve(resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )  ),
                       new Stage( resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("nbreMax"),resu.getInt("duree") )
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
    
    public ArrayList <Suit> selectRelationSuitParStage (int idSta)
    {
        ArrayList <Suit> myList = new ArrayList();
        String request = "Select * from Suit where IdStage = '"+idSta+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Suit ( new Eleve(resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )  ),
                       new Stage( resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("nbreMax"),resu.getInt("duree") )
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
    
        /* Efface la relationSuit (Eleve-Stage) dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteRelationSuit (int idElv,int idSta)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Suit where IdEleve = '" +
        idElv +  "' And idStage = '" + idSta + "' ");
        
        return ok;
    }
    
     /* Insère une relation Suit (Eleve-Stage) passée en paramètre dans la table Suit. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertRelSuit (Suit  relSuit)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Suit ( IdEleve, IdStage)" +
        " values ('" + relSuit.getIdEleve() + "','" + relSuit.getIdStage() +
        ")");
        
        return ok;
    }
    
}
