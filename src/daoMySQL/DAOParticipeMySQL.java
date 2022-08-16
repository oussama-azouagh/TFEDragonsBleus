/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOParticipe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Stage;
import transfertObject.Moniteur;
import transfertObject.Participe;
import transfertObject.Ville;

/**
 *
 * @author MediaMonster
 */
public class DAOParticipeMySQL implements DAOParticipe{
    
    private static DAOParticipeMySQL uniqueInstance = new DAOParticipeMySQL();
    
    public static DAOParticipeMySQL getInstance()
    {
        return uniqueInstance;
    }
    
     /* Sélectionne toutes les relationParticipe (Moniteur-Stage) et les renvoie dans une liste chaînée */
    public ArrayList <Participe> selectRelationParticipe ()
    {
        ArrayList <Participe> myList = new ArrayList();
        String request = "Select * from Participe";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Participe ( new Moniteur( resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                        resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse")
                                ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                        new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )),
                       new Stage(resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
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
    
    
    public ArrayList <Participe> selectRelationParticipeParMoniteur (int idMoni)
    {
        ArrayList <Participe> myList = new ArrayList();
        String request = "Select * from Participe where IdMoniteur = '"+idMoni+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Participe ( new Moniteur( resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                        resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse")
                                ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                        new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )),
                       new Stage(resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
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
    
    
    public ArrayList <Participe> selectRelationParticipeParStage (int idSta)
    {
        ArrayList <Participe> myList = new ArrayList();
        String request = "Select * from Participe where IdStage = '"+idSta+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Participe ( new Moniteur( resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                        resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse")
                                ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                        new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )),
                       new Stage(resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
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
    
        /* Efface la relationParticipe (Moniteur-Stage) dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteRelationParticipe (int idMoni,int idSta)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Participe where IdMoniteur = '" +
        idMoni +  "' And idStage = '" + idSta + "' ");
        
        return ok;
    }
    
     /* Insère une relation Participe (Moniteur-Stage) passée en paramètre dans la table Participe. Renvoie true si 
     ça s'est bien passé, false sinon */
    public boolean insertRelParticipe (Participe  relPart)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Participe ( IdMoniteur, IdStage)" +
        " values ('" + relPart.getIdMoniteur() + "','" + relPart.getIdStage() +
        ")");
        
        return ok;
    }
    
}
