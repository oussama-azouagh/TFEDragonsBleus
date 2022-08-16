/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOCompetition;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Competition;
import transfertObject.TypeCompetition;


/**
 *
 * @author MediaMonster
 */
public class DAOCompetitionMySQL implements DAOCompetition{
    
        private static DAOCompetitionMySQL uniqueInstance = new DAOCompetitionMySQL();
    
    public static DAOCompetitionMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne toutes les Competitions et les renvoie dans une liste chaînée */
    public ArrayList <Competition> selectCompetition ()
    {
        ArrayList <Competition> myList = new ArrayList();
                
        String request = "Select IdCompetition, Nom, DateEvenement, DateLimiteInscription, C.IdTypeCompetition, NomType, PrixInscription, Lieu, Duree  From Competition C, TypeCompetition T Where C.idTypeCompetition = T.idTypeCompetition ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Competition
                myList.add(new Competition (resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree")
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
    
    /*  Sélectionne toutes les Competitions d'un certain TypeCompetition 
     *  et les renvoie dans une liste chaînée. */
    public ArrayList <Competition> selectCompetitionParType (String nomType)
    {
        ArrayList myList = new ArrayList();
        
        String req = "Select IdCompetition, Nom, DateEvenement, DateLimiteInscription, " +
        "C.TypeCompetion, PrixInscription, Lieu, Duree from competiton C, typeCompetition T" +
        " where C.IdTypeCompetition = T.IdTypeCompetition" +
        " and NomType like '" + nomType + "' order by 1";
        
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (req);
        try {
            while (resu.next())
            {                
                 //création de l'objet Competition
                myList.add(new Competition (resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree")
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
    
  public ArrayList <Competition> selectCompetitionParNom (String nom)
    {
        ArrayList <Competition> myList = new ArrayList();
                
        String request = "Select * From Competition where nom like '%"+nom+"%' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Competition
                myList.add(new Competition (resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree")
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
  
  public ArrayList <Competition> selectCompetitionParDateEvenement (Date date,Date jour)
    {
        ArrayList <Competition> myList = new ArrayList();
                
        String request = "Select * From Competition where dateEvenement Between '"+date+"' And '"+jour+"' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Competition
                myList.add(new Competition (resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree")
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
  
  public ArrayList <Competition> selectCompetitionParDateInscription (Date date)
    {
        ArrayList <Competition> myList = new ArrayList();
                
        String request = "Select * From Competition where dateLimiteInscription <= '"+date+"' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Competition
                myList.add(new Competition (resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree")
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
  
  public ArrayList <Competition> selectCompetitionParLieu (String lieu)
    {
        ArrayList <Competition> myList = new ArrayList();
                
        String request = "Select * From Competition where lieu like '%"+lieu+"%' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Competition
                myList.add(new Competition (resu.getInt("idCompetition"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),new TypeCompetition(resu.getInt("idTypeCompetition"),resu.getString("nomType")),
                resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("duree")
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
    
    /* Insère une Competition passée en paramètre dans la table Competition. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertCompetition (Competition comp)
    {
        System.out.println(comp.toString());
        System.out.println(comp.getDateEvenementSQL());
        System.out.println(comp.getDateEvenement());
        
        // Attention date en type SQL !!!
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Competition (IdCompetition, Nom, DateEvenement, " +
        "DateLimiteInscription, idTypeCompetition, PrixInscription, Lieu, Duree) values ('" + comp.getIdCompetition() + "','" 
        + comp.getNom() + "'," + comp.getDateEvenementSQL() + "," + comp.getDateLimiteInscriptionSQL()+ ",'" + comp.getidTypeCompetition().getIdTypeCompetition() + 
        "','" + comp.getPrixInscription() + "','" + comp.getLieu() +
         "','" + comp.getDuree()+ "')");
        
        return ok;
    }
    
    /* Efface la Competition dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteCompetition (int ident)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Competition where IdCompetition = '" +
        ident + "'");
        
        return ok;
    }
    
 
    
    /* Modifie une Competition. On passe en paramètre l'objet Competition contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateCompetition (Competition comp)
    {
        String request = "Update Competition set Nom = '" + comp.getNom() +
        "', DateEvenement = " + comp.getDateEvenementSQL() + ", DateLimiteInscription = " + comp.getDateLimiteInscriptionSQL() +
        ", idTypeCompetition = '" + comp.getidTypeCompetition().getIdTypeCompetition() + "', PrixInscription = '" + comp.getPrixInscription() + 
        "',Lieu = '" + comp.getLieu() + "', Duree = '" + comp.getDuree() + "' where IdCompetition = '" + comp.getIdCompetition() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
}
