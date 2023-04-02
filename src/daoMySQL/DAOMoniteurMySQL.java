/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOMoniteur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Moniteur;
import transfertObject.Ville;
/**
 *
 * @author MediaMonster
 */
public class DAOMoniteurMySQL implements DAOMoniteur{
    
    private static DAOMoniteurMySQL uniqueInstance = new DAOMoniteurMySQL();
    
    public static DAOMoniteurMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne tous les Moniteurs et les renvoie dans une liste chaînée */
    public ArrayList <Moniteur> selectMoniteur ()
    {
        ArrayList <Moniteur> myList = new ArrayList();
       /** String request = "Select M.IdMoniteur, M.Nom, M.Prenom, M.AnneeNaissance, M.Telephone, M.NumAffilieFederation, M.Assurance, M.Grade, "
                + "M.Mail, M.IdAdresse, A.IdAdresse, A.NomAdresse, "
                + "A.Numero, A.Boite, A.CodePostal, A.IdVille, V.IdVille, V.Nom "
                + "From Moniteur M, Adresse A, Ville V Where M.idAdresse = A.idAdresse "
                + "And A.idVille = V.idVille"; **/
       
            String request = "Select * From  Moniteur join (Select * from Adresse) Adresse on Moniteur.idAdresse = Adresse.idAdresse";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Moniteur(resu.getInt(1), resu.getString(2), resu.getString(3),
                    resu.getDate(4), resu.getInt(5),resu.getInt(6), 
                    resu.getBoolean(7),resu.getString(8), resu.getString(9),
                   new Adresse(resu.getInt(11),resu.getString(12),resu.getInt(13),resu.getString(14),resu.getInt(15),
                   new Ville(resu.getInt(16),null) )));
                
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
    public ArrayList <Moniteur> selectMoniteurParAdresse (String adr)
    {
        ArrayList <Moniteur> myList = new ArrayList();
        String request = "Select * from Moniteur M, Adresse A Where M.IdAdresse = A.IdAdresse And A.NomAdresse Like '"+adr+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Moniteur(resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                        resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse")
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
    
    
    public ArrayList <Moniteur> selectMoniteurParVille (String ville)
    {
        ArrayList <Moniteur> myList = new ArrayList();
        String request = "Select * from Moniteur M, Ville V Where M.IdVille = V.IdVille And V.Nom Like '"+ville+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Moniteur(resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                        resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse")
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
    
    
        /* Efface le Moniteur dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteMoniteur (int idMoni)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Moniteur where IdMoniteur = '" +
        idMoni + "'");
        
        return ok;
    }
    
 
    
    /* Modifie un Moniteur. On passe en paramètre l'objet Moniteur contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateMoniteur (Moniteur moni)
    {
        String request = "Update Moniteur set Nom = '" + moni.getNom() +
        "', Prenom = '" + moni.getPrenom() + "', AnneeNaissance = '" + moni.getAnneeNaissanceSQL() +
        "', Telephone = '" + moni.getTelephone() + "', NumAffilieFederation = '" + moni.getNumAffilieFederation() +
        "', Assurance = '" + moni.isAssurance() + "', Grade = '" + moni.getGrade() + "', Mail = '" + moni.getMail() + 
        "', IdAdresse = '" + moni.getIdAdresse().getIdAdresse() +        
        "' where IdMoniteur = '" + moni.getIdMoniteur() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
    
    
     /* Insère un Moniteur passé en paramètre dans la table Moniteur. Renvoie true si 
     ça s'est bien passé, false sinon */
    public boolean insertMoniteur (Moniteur moni)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Moniteur ( IdMoniteur, Nom, AnneeNaissance, Telephone, " +
        " NumAffilieFederation, Assurance, Grade, Mail, Adresse )values ('" + moni.getIdMoniteur() + "','" + moni.getNom() +
         "','" + moni.getPrenom() + "','" + moni.getAnneeNaissanceSQL() + "','" + moni.getTelephone() + "','" + moni.getNumAffilieFederation()+
         "','" + moni.isAssurance()+ "','" + moni.getGrade() + "','" + moni.getMail() + "','" + moni.getIdAdresse().getIdAdresse()+       
        ")");
        
        return ok;
    }
    
    
}
