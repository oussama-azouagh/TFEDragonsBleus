/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOEleve;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Categorie;
import transfertObject.Eleve;
import transfertObject.Ville;
/**
 *
 * @author MediaMonster
 */
public class DAOEleveMySQL implements DAOEleve{
    
    private static DAOEleveMySQL uniqueInstance = new DAOEleveMySQL();
    
    public static DAOEleveMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne tous les Eleves et les renvoie dans une liste chaînée */
    public ArrayList <Eleve> selectEleve ()
    {
        ArrayList <Eleve> myList = new ArrayList();
        String request = "Select E.IdEleve, E.Nom, E.Prenom, E.AnneeNaissance, E.Telephone, E.NumAffilieFederation, E.Assurance, E.Grade, "
                + "E.Mail, E.IdCategorie, E.IdAdresse, C.IdCategorie, C.Description, C.TarifCotisation, A.IdAdresse, A.NomAdresse, "
                + "A.Numero, A.Boite, A.CodePostal, A.IdVille, V.IdVille, V.Nom "
                + "From Eleve E, Adresse A, Ville V, Categorie C Where E.idAdresse = A.idAdresse "
                + "And E.IdCategorie = C.IdCategorie And A.idVille = V.idVille";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Eleve (resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    public ArrayList <Eleve> selectEleveParNom (String nom)
    {
        ArrayList <Eleve> myList = new ArrayList();
        String request = "Select * from Eleve Where Nom like '" +nom+ "' Order By 1";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Eleve (resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
    public ArrayList <Eleve> selectEleveParCategorie (String cate)
    {
        ArrayList <Eleve> myList = new ArrayList();
        String request = "Select * from Eleve E, Categorie C Where E.IdCategorie = C.IdCategorie AND C.Description like '" +cate+ "' Order By 1";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Eleve (resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    public ArrayList <Eleve> selectEleveParAdresse (String adr)
    {
        ArrayList <Eleve> myList = new ArrayList();
        String request = "Select * from Eleve E, Adresse A Where E.IdAdresse = A.IdAdresse AND A.NomAdresse like '" +adr+ "' Order By 1";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Eleve (resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
        public boolean deleteEleve (int idEleve)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Eleve where IdEleve = '" +
        idEleve + "'");
        
        return ok;
    }
    
 
    
    /* Modifie un Eleve. On passe en paramètre l'objet Eleve contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateEleve (Eleve elv)
    {
        String request = "Update Eleve set Nom = '" + elv.getNom() +
        "', Prenom = '" + elv.getPrenom() + "', AnneeNaissance = '" + elv.getAnneeNaissanceSQL() +
        "', Telephone = '" + elv.getTelephone() + "', NumAffilieFederation = '" + elv.getNumAffilieFederation() +
        "', Assurance = '" + elv.isAssurance() + "', Grade = '" + elv.getGrade() + "', Mail '" + elv.getMail() + 
        "', IdCategorie = '" + elv.getIdCategorie().getIdCategorie() + "', Adresse = '" + elv.getIdAdresse().getIdAdresse() +     
        "' where IdEleve = '" + elv.getIdEleve() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
    
    
       /* Insère un Eleve passé en paramètre dans la table Eleve. Renvoie true si 
     �a s'est bien passé, false sinon */
    public boolean insertEleve (Eleve elv)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Eleve (IdEleve, Nom, Prenom, AnneeNaissance, Telephone, NumAffilieFederation, Assurance, " +
                " Grade, Mail, IdCategorie, IdAdresse ) values ('" + elv.getIdEleve() + "','" + elv.getNom() + "','" + elv.getPrenom() +
                "','" + elv.getAnneeNaissanceSQL() + "','" + elv.getTelephone() + "','" + elv.getNumAffilieFederation() + "','" + elv.isAssurance() +
                "','" + elv.getGrade() + "','" + elv.getMail() + "','" + elv.getIdCategorie().getIdCategorie() + "','" + elv.getIdAdresse().getIdAdresse() +
                ")");
        
        return ok;
    }
}
