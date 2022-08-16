/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOPayementEnPlusieursParties;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.PayementEnPlusieursParties;
import transfertObject.Cotisation;


/**
 *
 * @author MediaMonster
 */
public class DAOPayementEnPlusieursPartiesMySQL implements DAOPayementEnPlusieursParties{
    
    private static DAOPayementEnPlusieursPartiesMySQL uniqueInstance = new DAOPayementEnPlusieursPartiesMySQL();
    
    public static DAOPayementEnPlusieursPartiesMySQL getInstance()
    {
        return uniqueInstance;
    }
    
    public ArrayList <PayementEnPlusieursParties> selectPayementEnPlusieursParties ()
    {
        ArrayList <PayementEnPlusieursParties> myList = new ArrayList();
        String request = "Select * from PayementEnPlusieursParties";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new PayementEnPlusieursParties (resu.getInt("IdPayement"), resu.getInt("Montant"), resu.getInt("nombreVersement"),
                    new Cotisation(resu.getInt("IdCotisatoin"), resu.getInt("Accompte"), resu.getInt("TotalAnnuel"),
                    resu.getInt("Rabais"), resu.getDate("DatePayement"),resu.getString("AnneeCotisation"), 
                    new PayementEnPlusieursParties(resu.getInt("IdPayement"),
                    resu.getInt("Montant"),resu.getInt("NombreVersement"), new Cotisation ()
                          ) )  ) );
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
     public ArrayList <PayementEnPlusieursParties> selectPayementEnPlusieursPartiesParMontant (int mont)
    {
        ArrayList <PayementEnPlusieursParties> myList = new ArrayList();
        String request = "Select * from PayementEnPlusieursParties where Montant = '"+mont+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new PayementEnPlusieursParties (resu.getInt("IdPayement"), resu.getInt("Montant"), resu.getInt("nombreVersement"),
                    new Cotisation(resu.getInt("IdCotisatoin"), resu.getInt("Accompte"), resu.getInt("TotalAnnuel"),
                    resu.getInt("Rabais"), resu.getDate("DatePayement"),resu.getString("AnneeCotisation"), 
                    new PayementEnPlusieursParties(resu.getInt("IdPayement"),
                    resu.getInt("Montant"),resu.getInt("NombreVersement"), new Cotisation ()
                          ) )  ) );
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
     
      public ArrayList <PayementEnPlusieursParties> selectPayementEnPlusieursPartiesParNombreVersement (int nbre)
    {
        ArrayList <PayementEnPlusieursParties> myList = new ArrayList();
        String request = "Select * from PayementEnPlusieursParties where NombreVersement = '"+nbre+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new PayementEnPlusieursParties (resu.getInt("IdPayement"), resu.getInt("Montant"), resu.getInt("NombreVersement"),
                    new Cotisation(resu.getInt("IdCotisatoin"), resu.getInt("Accompte"), resu.getInt("TotalAnnuel"),
                    resu.getInt("Rabais"), resu.getDate("DatePayement"),resu.getString("AnneeCotisation"), 
                    new PayementEnPlusieursParties(resu.getInt("IdPayement"),
                    resu.getInt("Montant"),resu.getInt("NombreVersement"), new Cotisation ()
                          ) )  ) );
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
     
        public boolean deletePayementEnPlusieursParties (int idPayement)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from PayementEnPlusieursParties where IdPayement = '" +
        idPayement + "'");
        
        return ok;
    }
    
 
    
    /* Modifie un PayementEnPlusieursParties. On passe en paramètre l'objet PayementEnPlusieursParties contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateEleve (PayementEnPlusieursParties pay)
    {
        String request = "Update PayementEnPlusieursParties set Montant = '" + pay.getMontant() +
        "', nombreVersement = '" + pay.getNombreVersement() + "', IdCotisaition = '" + pay.getIdCotisation().getIdCotisation() +  
        "' where IdPayement = '" + pay.getIdPayement() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
    
     /* Insère un PayementEnPlusieursParties passé en paramètre dans la table PayementEnPlusieursParties. Renvoie true si 
     ça s'est bien passé, false sinon */
    public boolean insertPayementEnPlusieursParties (PayementEnPlusieursParties  pls)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into PayementEnPlusieursParties ( IdPayement, Montant," +
        " nombreVersement, IdCotisation) values ('" + pls.getIdPayement() + "','" + pls.getMontant() + "','" + pls.getNombreVersement() +
        "','" + pls.getIdCotisation().getIdCotisation() +        
        ")");
        
        return ok;
    }
    
}
