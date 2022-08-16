/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOStage;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Stage;



/**
 *
 * @author MediaMonster
 */
public class DAOStageMySQL implements DAOStage{
    
        private static DAOStageMySQL uniqueInstance = new DAOStageMySQL();
    
    public static DAOStageMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    /* Sélectionne toutes les Stages et les renvoie dans une liste chaînée */
    public ArrayList <Stage> selectStage ()
    {
        ArrayList <Stage> myList = new ArrayList();
                
        String request = "Select * From Stage";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Stage
                myList.add(new Stage (resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("nbreMax"),resu.getInt("duree")
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
    
    public ArrayList <Stage> selectStageParNom (String nom)
    {
        ArrayList <Stage> myList = new ArrayList();
                
        String request = "Select * From Stage where nom like '%"+nom+"%' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Stage
                myList.add(new Stage (resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("nbreMax"),resu.getInt("duree")
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
    
   public ArrayList <Stage> selectStageParDateEvenement (Date date, Date jour)
    {
        ArrayList <Stage> myList = new ArrayList();
                
        String request = "Select * From Stage where dateEvenement Between '"+jour+"' And '"+jour+"' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Stage
                myList.add(new Stage (resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("nbreMax"),resu.getInt("duree")
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
   
    public ArrayList <Stage> selectStageParDateInscription (Date date)
    {
        ArrayList <Stage> myList = new ArrayList();
                
        String request = "Select * From Stage where dateLimiteInscription <= '"+date+"' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Stage
                myList.add(new Stage (resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("nbreMax"),resu.getInt("duree")
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
    
      public ArrayList <Stage> selectStageParLieu (String lieu)
    {
        ArrayList <Stage> myList = new ArrayList();
                
        String request = "Select * From Stage where lieu like '%"+lieu+"%' ";
        
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {  
                //création de l'objet Stage
                myList.add(new Stage (resu.getInt("idStage"),resu.getString("nom"),resu.getDate("dateEvenement"),
                resu.getDate("dateLimiteInscription"),resu.getInt("prixInscription"),resu.getString("lieu"),resu.getInt("nbreMax"),resu.getInt("duree")
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
    
    /* Insère un Stage passé en paramètre dans la table Stage. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertStage (Stage sta)
    {
      
        // Attention date en type SQL !!!
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Stage (IdStage, Nom, DateEvenement, " +
        "DateLimiteInscription, PrixInscription, Lieu, NbreMax, Duree) values ('" + sta.getIdStage() + "','" 
        + sta.getNom() + "','" + sta.getDateEvenementSQL() + "','" + sta.getDateLimiteInscriptionSQL()+ "','" + sta.getPrixInscription() + "','" 
        + sta.getLieu() + "','" + sta.getNbreMax() + "','" + sta.getDuree()+ "')");
        
        return ok;
    }
    
    /* Efface le Stage dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteStage (int idSta)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Stage where IdStage = '" +
        idSta + "'");
        
        return ok;
    }
    
 
    
    /* Modifie un Stage. On passe en paramètre l'objet Stage contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateStage (Stage sta)
    {
        String request = "Update Stage set Nom = '" + sta.getNom() +
        "', DateEvenement = '" + sta.getDateEvenementSQL() + "', DateLimiteInscription = '" + sta.getDateLimiteInscriptionSQL() +
        "', PrixInscription = '" + sta.getPrixInscription() + "',Lieu = '" + sta.getLieu() + "', NbreMax = '" + sta.getNbreMax() +
        "', Duree = '" + sta.getDuree() + "' where IdStage = '" + sta.getIdStage() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
}
