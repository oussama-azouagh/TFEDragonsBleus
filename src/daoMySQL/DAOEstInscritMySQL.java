/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMySQL;

import dao.DAOEstInscrit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transfertObject.Adresse;
import transfertObject.Categorie;
import transfertObject.Eleve;
import transfertObject.EstInscrit;
import transfertObject.Groupe;
import transfertObject.Ville;

/**
 *
 * @author MediaMonster
 */
public class DAOEstInscritMySQL implements DAOEstInscrit{
    
    private static DAOEstInscritMySQL uniqueInstance = new DAOEstInscritMySQL();
    
    public static DAOEstInscritMySQL getInstance()
    {
        return uniqueInstance;
    }
    
       /* Sélectionne toutes les relationEstInscrit (Eleve-Groupe) et les renvoie dans une liste chaînée */
    public ArrayList <EstInscrit> selectRelationEstInscrit ()
    {
        ArrayList <EstInscrit> myList = new ArrayList();
        String request = "Select I.IdEleve,I.IdGroupe, E.IdEleve, E.Nom, E.Prenom, E.AnneeNaissance, E.Telephone, E.NumAffilieFederation, E.Assurance, E.Grade, "
                + "E.Mail, E.IdCategorie, E.IdAdresse, C.IdCategorie, C.Description, C.TarifCotisation, A.IdAdresse, A.NomAdresse, "
                + "A.Numero, A.Boite, A.CodePostal, A.IdVille, V.IdVille, V.Nom, "
                +"G.IdGroupe, G.Nom, G.Année, G.AgeMin, G.AgeMax, "
                + "From I.EstInscrit, E.Eleve, C.Categorie, A.Adresse, V.Ville, G.Groupe "
                + "Where E.idAdresse = A.idAdresse And E.IdCategorie = C.IdCategorie And A.idVille = V.idVille "
                + "And I.IdEleve = E.IdEleve And I.IdGroupe = G.IdGroupe ";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new EstInscrit ( new Eleve( resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                       new Groupe( resu.getInt("IdGroupe"), resu.getString("Nom"), resu.getString("Année"),
                    resu.getInt("AgeMin"), resu.getInt("AgeMax") )
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
    
    
    public ArrayList <EstInscrit> selectRelationEstInscritParEleve (int idElv)
    {
        ArrayList <EstInscrit> myList = new ArrayList();
        String request = "Select * from EstInscrit where IdEleve = '"+idElv+"'";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new EstInscrit ( new Eleve( resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                       new Groupe( resu.getInt("IdGroupe"), resu.getString("Nom"), resu.getString("Année"),
                    resu.getInt("AgeMin"), resu.getInt("AgeMax") )
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
    
    public ArrayList <EstInscrit> selectRelationEstInscritParGroupe (int idGrp)
    {
        ArrayList <EstInscrit> myList = new ArrayList();
        String request = "Select * from EstInscrit where IdGroupe = '"+idGrp+"'";
        ResultSet resu = DAOConnexionMySQL.getInstance().selectQuery (request);
        try {
            while (resu.next())
            {
                myList.add (new EstInscrit ( new Eleve( resu.getInt("IdEleve"), resu.getString("Nom"), resu.getString("Prenom"),
                    resu.getDate("AnneeNaissance"), resu.getInt("Telephone"),resu.getInt("NumAffilieFederation"), 
                    resu.getBoolean("Assurance"),resu.getString("Grade"), resu.getString("Mail"),new Categorie(resu.getInt("IdCategorie"),
                    resu.getString("Description"),resu.getInt("TarifCotisation")) ,new Adresse(resu.getInt("IdAdresse")
                    ,resu.getString("NomAdresse"),resu.getInt("Numero"),resu.getString("Boite"),resu.getInt("CodePostal"),
                    new Ville(resu.getInt("IdVille"),resu.getString("Nom") )  ) ),
                       new Groupe( resu.getInt("IdGroupe"), resu.getString("Nom"), resu.getString("Année"),
                    resu.getInt("AgeMin"), resu.getInt("AgeMax") )
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
    
        /* Efface la relationEstInscrit (Eleve-Groupe) dont l'identifiant est passé en paramètre. Renvoie  true si 
     cela s'est bien passé, false sinon */
    public boolean deleteRelationEstInscrit (int idElv,int idGrp)
    {
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Delete from EstInscrit where IdEleve = '" +
        idElv +  "' And idGroupe = '" + idGrp + "' ");
        
        return ok;
    }
    

    
    /* Modifie une relationEst (Competition-TypeCompetition). On passe en paramètre l'objet Cotisation contenant les 
     modifications (l'identifiant lui, ne peut pas être modifié). Renvoie  true si 
     cela s'est bien passé, false sinon */
   // public boolean updateRelationEst (Competition comp,TypeCompetition typeComp )
   // {
   // }
   // pas besoin car Relation a des id en table uniquement
    
    
    
      /* Insère une relation EstInscrit (Eleve-Groupe) passée en paramètre dans la table EstInscrit. Renvoie true si 
     cela s'est bien passé, false sinon */
    public boolean insertEstInscrit (EstInscrit relEstIns)
    {
        
        boolean ok = DAOConnexionMySQL.getInstance().actionQuery("Insert into EstInscrit (IdEleve, IdGroupe " +
                " )values ('" + relEstIns.getIdEleve() + "','" + relEstIns.getIdGroupe() + 
                ")");
        
        return ok;
    }
}
