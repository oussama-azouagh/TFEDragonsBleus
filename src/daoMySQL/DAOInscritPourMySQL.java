/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOInscritPour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Competition;
import transfertObject.Moniteur;
import transfertObject.InscritPour;
import transfertObject.TypeCompetition;
import transfertObject.Ville;

/**
 *
 * @author MediaMonster
 */
public class DAOInscritPourMySQL implements DAOInscritPour{
    
    private static DAOInscritPourMySQL uniqueInstance = new DAOInscritPourMySQL();
    
    public static DAOInscritPourMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne toutes les relationInscritPour (Competition-Moniteur) et les renvoie dans une liste chaînée */
    public ArrayList <InscritPour> selectRelationInscritPour ()
    {
        ArrayList <InscritPour> myList = new ArrayList();
        String request = "Select * from InscritPour ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new InscritPour ( new Moniteur(resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                        resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse")
                                ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                        new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                       new Competition(resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree") ) 
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
    
    
    public ArrayList <InscritPour> selectRelationInscritPourParMoniteur (int idMoni)
    {
        ArrayList <InscritPour> myList = new ArrayList();
        String request = "Select * from InscritPour where IdMoniteur = '"+idMoni +"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new InscritPour ( new Moniteur(resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                        resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse")
                                ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                        new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                       new Competition(resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree") ) 
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
    
    
    public ArrayList <InscritPour> selectRelationInscritPourParCompetition (int idComp)
    {
        ArrayList <InscritPour> myList = new ArrayList();
        String request = "Select * from InscritPour where idCompetition = '"+idComp+"'";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new InscritPour ( new Moniteur(resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                        resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse")
                                ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                        new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                       new Competition(resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree") ) 
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
    
        /* Efface la relationInscritPour (Moniteur-Competition) dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteRelationInscritPour (int idMoni,int idComp)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from InscritPour where IdMoniteur = '" +
        idMoni +  "' And idCompetition = '" + idComp + "' ");
        
        return ok;
    }
    

    
    /* Modifie une relationEst (Competition-TypeCompetition). On passe en paramètre l'objet Cotisation contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
   // public boolean updateRelationEst (Competition comp,TypeCompetition typeComp )
   // {
   // }
   // pas besoin car Relation a des id en table uniquement
    
    
    
    /* Insère une relation InscritPour (Moniteur-Competition) passée en paramètre dans la table InscritPour. Renvoie true si 
     �a s'est bien passé, false sinon */
    public boolean insertRelInscritPour (InscritPour  relInscr)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into InscritPour ( IdMoniteur, IdCompetition)" +
        " values ('" + relInscr.getIdMoniteur() + "','" + relInscr.getIdCompetition() +
        ")");
        
        return ok;
    }
    
    
}
