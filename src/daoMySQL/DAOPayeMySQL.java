/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOPaye;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Categorie;
import transfertObject.Cotisation;
import transfertObject.Eleve;
import transfertObject.Paye;
import transfertObject.PayementEnPlusieursParties;
import transfertObject.Ville;

/**
 *
 * @author MediaMonster
 */
public class DAOPayeMySQL implements DAOPaye{
    
    private static DAOPayeMySQL uniqueInstance = new DAOPayeMySQL();
    
    public static DAOPayeMySQL getInstance()
    {
        return uniqueInstance;
    }
    
     /* Sélectionne toutes les relationPaye (Eleve-Cotisation) et les renvoie dans une liste chaînée */
    public ArrayList <Paye> selectRelationPaye ()
    {
        ArrayList <Paye> myList = new ArrayList();
        String request = "Select * from Paye";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Paye ( new Eleve(resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )  ),
                       new Cotisation(resu.getInt("IdCotisation"), resu.getInt("Accompte"), resu.getInt("TotalAnnuel"),
                    resu.getInt("Rabais"), resu.getDate("DatePayement"),resu.getString("AnneeCotisation"), 
                    new PayementEnPlusieursParties(resu.getInt("IdPayement"),
                    resu.getInt("Montant"),resu.getInt("NombreVersement"), new Cotisation ()
                          ) )
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
    
    
     public ArrayList <Paye> selectRelationPayeParEleve (int idElv)
    {
        ArrayList <Paye> myList = new ArrayList();
        String request = "Select * from Paye where idEleve = '"+idElv+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Paye ( new Eleve(resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )  ),
                       new Cotisation(resu.getInt("IdCotisation"), resu.getInt("Accompte"), resu.getInt("TotalAnnuel"),
                    resu.getInt("Rabais"), resu.getDate("DatePayement"),resu.getString("AnneeCotisation"), 
                    new PayementEnPlusieursParties(resu.getInt("IdPayement"),
                    resu.getInt("Montant"),resu.getInt("NombreVersement"), new Cotisation ()
                          ) )
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
     
     public ArrayList <Paye> selectRelationPayeParCotisation (int idCoti)
    {
        ArrayList <Paye> myList = new ArrayList();
        String request = "Select * from Paye where idCotisation = '"+idCoti+"' ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new Paye ( new Eleve(resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  )  ),
                       new Cotisation(resu.getInt("IdCotisation"), resu.getInt("Accompte"), resu.getInt("TotalAnnuel"),
                    resu.getInt("Rabais"), resu.getDate("DatePayement"),resu.getString("AnneeCotisation"), 
                    new PayementEnPlusieursParties(resu.getInt("IdPayement"),
                    resu.getInt("Montant"),resu.getInt("NombreVersement"), new Cotisation ()
                          ) )
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
    
        /* Efface la relationPaye (Eleve-Cotisation) dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteRelationPaye (int idElv,int idCoti)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from Paye where IdEleve = '" +
        idElv +  "' And idCotisation = '" + idCoti + "' ");
        
        return ok;
    }
    
     /* Insère une relation Paye (Eleve-Cotisation) passée en paramètre dans la table Paye. Renvoie true si 
     ça s'est bien passé, false sinon */
    public boolean insertRelPaye (Paye  relPay)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into Paye ( IdEleve, IdCotisation)" +
        " values ('" + relPay.getIdEleve() + "','" + relPay.getIdCotisation() +
        ")");
        
        return ok;
    }
    
}
