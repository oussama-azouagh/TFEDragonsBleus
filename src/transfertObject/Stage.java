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
public class Stage {
private int idStage;
private String nom;
private Date dateEvenement;
private Date dateLimiteInscription;
private int prixInscription;
private String lieu;
private int nbreMax;
private int duree; // duree de l'evenement

    public Stage() {
    }

    public Stage(int idStage, String nom, Date dateEvenement, Date dateLimiteInscription, int prixInscription, String lieu, int nbreMax, int duree) {
        this.idStage = idStage;
        this.nom = nom;
        this.dateEvenement = dateEvenement;
        this.dateLimiteInscription = dateLimiteInscription;
        this.prixInscription = prixInscription;
        this.lieu = lieu;
        this.nbreMax = nbreMax;
        this.duree = duree;
    }


    public int getIdStage() {
        return idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
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
    
     public String getDateEvenementSQL() {
        String tmp;

        if (this.dateEvenement == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
         // tmp = "'" + dateParser.format(this.dateEvenement) + "'";
         tmp =dateParser.format(this.dateEvenement);
          }
        return tmp;
    }

    public void setDateEvenement(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
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

    public Date getDateLimiteInscription() {
        return dateLimiteInscription;
    }

    public void setDateLimiteInscription(Date dateLimiteInscription) {
        this.dateLimiteInscription = dateLimiteInscription;
    }
    
     public String getDateLimiteInscriptionSQL() {
        String tmp;

        if (this.dateLimiteInscription == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
          //tmp = "'" + dateParser.format(this.dateLimiteInscription) + "'";
          tmp =dateParser.format(this.dateLimiteInscription);
          }
        return tmp;
    }
     
      public String getDateLimiteInscriptionBE() {
        String tmp;

        if (this.dateLimiteInscription == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
          tmp = dateParser.format(this.dateLimiteInscription);
          }
        return tmp;
    }

    public void setDateLimiteInscriptionBE(String dateEve) {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dateLimiteInscription = dateParser.parse(dateEve);
        } catch (ParseException ex) {
            Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public int getNbreMax() {
        return nbreMax;
    }

    public void setNbreMax(int nbreMax) {
        this.nbreMax = nbreMax;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    

}
