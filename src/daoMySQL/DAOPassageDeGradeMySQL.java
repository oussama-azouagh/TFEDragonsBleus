/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOPassageDeGrade;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Categorie;
import transfertObject.Eleve;
import transfertObject.Moniteur;
import transfertObject.PassageDeGrade;
import transfertObject.Ville;



/**
 *
 * @author MediaMonster
 */
public class DAOPassageDeGradeMySQL implements DAOPassageDeGrade{
    
        private static DAOPassageDeGradeMySQL uniqueInstance = new DAOPassageDeGradeMySQL();
    
    public static DAOPassageDeGradeMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne touts les PassageDeGrade et les renvoie dans une liste chaînée */
    public ArrayList <PassageDeGrade> selectPassageDeGrade ()
    {
        ArrayList <PassageDeGrade> myList = new ArrayList();
                
        String request = "Select * From PassageDeGrade";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet PassageDeGrade
                myList.add(new PassageDeGrade(resu.getInt(1),resu.getDate(2),
                resu.getInt(3),resu.getInt(4),resu.getInt(5),resu.getInt(6),resu.getInt(7),
                resu.getString(8),new Eleve(resu.getInt(9) ),
                        
                new Moniteur(resu.getInt(10))        
                ) );
             }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
    public ArrayList <PassageDeGrade> selectPassageDeGradeParGrade (String grade)
    {
        ArrayList <PassageDeGrade> myList = new ArrayList();
                
        String request = "Select * From PassageDeGrade where Grade like '%"+grade+"%' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet PassageDeGrade
                myList.add(new PassageDeGrade (resu.getInt("idPassageDeGrade"),resu.getDate("datePassageDeGrade"),
                resu.getInt("cotePartie1"),resu.getInt("cotePartie2"),resu.getInt("cotePartie3"),resu.getInt("coteRandori"),resu.getInt("coteTotal"),
                resu.getString("gradeDesire"),new Eleve (resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse"),
                    resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                        
                new Moniteur(resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse"),
                    resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ))        
                ) );
             }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
    public ArrayList <PassageDeGrade> selectPassageDeGradeParDate (Date datepass, Date jour)
    {
        ArrayList <PassageDeGrade> myList = new ArrayList();
                
        String request = "Select * From PassageDeGrade where DatePassageDeGrade between '"+datepass+"' and '"+jour+"' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet PassageDeGrade
                myList.add(new PassageDeGrade (resu.getInt("idPassageDeGrade"),resu.getDate("datePassageDeGrade"),
                resu.getInt("cotePartie1"),resu.getInt("cotePartie2"),resu.getInt("cotePartie3"),resu.getInt("coteRandori"),resu.getInt("coteTotal"),
                resu.getString("gradeDesire"),new Eleve (resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse"),
                    resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                        
                new Moniteur(resu.getInt("IdMoniteur"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"), new Adresse(resu.getInt("IdAdresse"),
                    resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ))        
                ) );
             }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
    
    
  /*
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    peut etre ajoute des select par... ?
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!        
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    */
    
    /* Insère un PassageDeGrade passé en paramètre dans la table PassageDeGrade. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertPassageDeGrade (PassageDeGrade pass)
    {
      
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into PassageDeGarde (IdPassageDeGrade, DatePassage, CotePartie1, " +
        "CotePartie2, CotePartie3, CoteRandori, CoteTotal, IdEleve, IdMoniteur) values ('" + pass.getIdPassageDeGrade() + "','" 
        + pass.getDatePassageSQL() + "'," + pass.getCotePartie1() + "," + pass.getCotePartie2()+ ",'" + pass.getCotePartie3() + "'," 
        + pass.getCoteRandori() + "," + pass.getCoteTotal() + ",'" + pass.getIdEleve()+ "," + pass.getIdMoniteur() + ")");
        
        return ok;
    }
    
    /* Efface le PassageDeGrade dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deletePassageDeGrade (int idPass)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from PassageDeGrade where IdPassageDeGrade = '" +
        idPass + "'");
        
        return ok;
    }
    
 
    
    /* Modifie un PassageDeGrade. On passe en paramètre l'objet PassageDeGrade contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updatePassageDeGrade (PassageDeGrade pass)
    {
        String request = "Update PassageDeGrade set DatePassage = '" + pass.getDatePassageSQL() +
        "', CotePartie1 = '" + pass.getCotePartie1() + "', CotePartie2 = '" + pass.getCotePartie2() +
        "', CotePartie3 = '" + pass.getCotePartie3() + "', CoteRandori = '" + pass.getCoteRandori() + "', CoteTotal = '" + pass.getCoteTotal() +
        "', IdEleve = '" + pass.getIdEleve() + "', IdMoniteur = '" + pass.getIdMoniteur() +
        "' where IdPassgeDeGrade = '" + pass.getIdPassageDeGrade() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
}
