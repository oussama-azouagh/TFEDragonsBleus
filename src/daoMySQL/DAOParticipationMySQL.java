/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOParticipation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Categorie;
import transfertObject.Competition;
import transfertObject.Eleve;
import transfertObject.Participation;
import transfertObject.TypeCompetition;
import transfertObject.Ville;

/**
 *
 * @author MediaMonster
 */
public class DAOParticipationMySQL implements DAOParticipation{
    
    private static DAOParticipationMySQL uniqueInstance = new DAOParticipationMySQL();
    
    public static DAOParticipationMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne toutes les relationParticipation (Eleve-Competition) et les renvoie dans une liste chaînée */
    public ArrayList <Participation> selectRelationParticipation ()
    {
        ArrayList <Participation> myList = new ArrayList();
        String request = "Select * from Participation";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Participation ( new Eleve(resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )  ),
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
    
    
    public ArrayList <Participation> selectRelationParticipationParEleve (int idElv)
    {
        ArrayList <Participation> myList = new ArrayList();
        String request = "Select * from Participation where IdEleve = '"+idElv+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Participation ( new Eleve(resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )  ),
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
    
    
    public ArrayList <Participation> selectRelationParticipationParCompetition (int idComp)
    {
        ArrayList <Participation> myList = new ArrayList();
        String request = "Select * from Participation where IdCompetition = '"+idComp+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Participation ( new Eleve(resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )  ),
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
    
        /* Efface la relationParticipation (Eleve-Competition) dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteRelationParticipation (int idElv,int idComp)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Participation where IdEleve = '" +
        idElv +  "' And idCompetition = '" + idComp + "' ");
        
        return ok;
    }
    
     /* Insère une relation Participation (Eleve-Competition) passée en paramètre dans la table Participation. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertRelParticipation (Participation  relPart)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Participation ( IdEleve, IdCompetition)" +
        " values ('" + relPart.getIdEleve() + "','" + relPart.getIdCompetition() +
        ")");
        
        return ok;
    }
    
}
