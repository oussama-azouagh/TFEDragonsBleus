/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOCotisation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Cotisation;
import transfertObject.PayementEnPlusieursParties;

/**
 *
 * @author MediaMonster
 */
public class DAOCotisationMySQL implements DAOCotisation{
    
    private static DAOCotisationMySQL uniqueInstance = new DAOCotisationMySQL();
    
    public static DAOCotisationMySQL getInstance()
    {
        return uniqueInstance;
    }
    
     /* Sélectionne toutes les Cotisations et les renvoie dans une liste chaînée */
    public ArrayList <Cotisation> selectCotisation ()
    {
        ArrayList <Cotisation> myList = new ArrayList();
        String request = "Select IdCotisation, Accompte, TotalAnnuel, Rabais, DatePayement, AnneeCotisation, C.idPayement, P.idPayement, P.Montant, P.NombreVersement from C.Cotisation, P.PayementEnPlusieursParties Where P.idPayement = C.idPayement";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Cotisation(resu.getInt("IdCotisatoin"), resu.getInt("Accompte"), resu.getInt("TotalAnnuel"),
                    resu.getInt("Rabais"), resu.getDate("DatePayement"),resu.getString("AnneeCotisation"), 
                    new PayementEnPlusieursParties(resu.getInt("IdPayement"),
                    resu.getInt("Montant"),resu.getInt("NombreVersement")
                          ) ));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        return myList;
    }
    
    
        /* Efface la Cotisation dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteCotisation (int idCoti)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Cotisation where IdCotisation = '" +
        idCoti + "'");
        
        return ok;
    }
    
 
    
    /* Modifie une Cotisation. On passe en paramètre l'objet Cotisation contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean updateCotisation (Cotisation coti)
    {
        String request = "Update Cotisation set Accompte = '" + coti.getAccompte() +
        "', TotalAnnuel = '" + coti.getTotalAnnuel() + "', Rabais = '" + coti.getRabais() +
        "', DatePayement = '" + coti.getDatePayementSQL() + "', AnneeCotisation = '" + coti.getAnneeCotisation() +
        "', IdPayement = '" + coti.getIdPayement() + "' where IdCotisation = '" + coti.getIdCotisation() + "' ";
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery(request);
        
        return ok;
    }
    
      /* Insère une Cotisation passée en paramètre dans la table Cotisation. Renvoie true si 
     �a s'est bien passé, false sinon */
    public boolean insertCotisation (Cotisation coti)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Cotisation (IdCotisation, Accompte, TotalAnnuel, Rabais, DatePayement, AnneeCotisation, IdPayement ) " +
        "values ('" + coti.getIdCotisation() + "','" + coti.getAccompte() + "','" + coti.getTotalAnnuel() + "','" + coti.getRabais() +
        "','" + coti.getDatePayementSQL() +  "','" + coti.getAnneeCotisation() + "','" + coti.getIdPayement().getIdPayement() +      
                ")");
        
        return ok;
    }
    
}
