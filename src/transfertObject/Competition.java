/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfertObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MediaMonster
 */
public class Competition {
 
private int idCompetition;
private String nom;
private Date dateEvenement;//Date de l'évènement  + java.util.Date car on ne peut pas parser un String en java.sql.Date !
private Date dateLimiteInscription;//Date limite de l'inscription pour cet évènement + java.util.Date car on ne peut pas parser un String en java.sql.Date !
private TypeCompetition idTypeCompetition;
private int prixInscription;
private String lieu;
private int duree;

    public Competition() {
    }

    public Competition(int idCompetition, String nom, Date dateEvenement, Date dateLimiteInscription, TypeCompetition idTypeCompetition, int prixInscription, String lieu, int duree) {
        this.idCompetition = idCompetition;
        this.nom = nom;
        this.dateEvenement = dateEvenement;
        this.dateLimiteInscription = dateLimiteInscription;
        this.idTypeCompetition = idTypeCompetition;
        this.prixInscription = prixInscription;
        this.lieu = lieu;
        this.duree = duree;
    }

    public int getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public Date getDateLimiteInscription() {
        return dateLimiteInscription;
    }

    public void setDateLimiteInscription(Date dateLimiteInscription) {
        this.dateLimiteInscription = dateLimiteInscription;
    }

    public TypeCompetition getidTypeCompetition() {
        return idTypeCompetition;
    }

    public void setidTypeCompetition(TypeCompetition idTypeCompetition) {
        this.idTypeCompetition = idTypeCompetition;
    }

    public int getPrixInscription() {
        return prixInscription;
    }

    public void setPrixInscription(int prixInscription) {
        this.prixInscription = prixInscription;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
 public String getDateEvenementBE() {
        String tmp;

        if (this.dateEvenement == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
          tmp = dateParser.format(this.dateEvenement);
          }
        return tmp;
    }

    public void setDateEvenementBE(String dateEve) {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dateEvenement = dateParser.parse(dateEve);
        } catch (ParseException ex) {
            Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getDateLimiteInscriptionBE() {
        String tmp;

        if (this.dateEvenement == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
          tmp = dateParser.format(this.dateEvenement);
          }
        return tmp;
    }

    public void setDateLimiteInscriptionBE(String dateLim) {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dateEvenement = dateParser.parse(dateLim);
        } catch (ParseException ex) {
            Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDateEvenementSQL() {
        String tmp;

        if (this.dateEvenement == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
          tmp = "'" + dateParser.format(this.dateEvenement) + "'";
          }
        return tmp;
    }
     public String getDateLimiteInscriptionSQL() {
        String tmp;

        if (this.dateLimiteInscription == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
          tmp = "'" + dateParser.format(this.dateLimiteInscription) + "'";
          }
        return tmp;
    }
  


}
