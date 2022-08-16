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
public class PassageDeGrade {
private int idPassageDeGrade;
private Date datePassage;
private int cotePartie1;
private int cotePartie2;
private int cotePartie3;
private int  coteRandori;
private int  coteTotal;
private String gradeDesire;
private Eleve idEleve;
private Moniteur idMoniteur;

    public PassageDeGrade() {
    }

    public PassageDeGrade(int idPassageDeGrade, Date datePassage, int cotePartie1, int cotePartie2, int cotePartie3, int coteRandori, int coteTotal, String gradeDesire, Eleve idEleve, Moniteur idMoniteur) {
        this.idPassageDeGrade = idPassageDeGrade;
        this.datePassage = datePassage;
        this.cotePartie1 = cotePartie1;
        this.cotePartie2 = cotePartie2;
        this.cotePartie3 = cotePartie3;
        this.coteRandori = coteRandori;
        this.coteTotal = coteTotal;
        this.gradeDesire = gradeDesire;
        this.idEleve = idEleve;
        this.idMoniteur = idMoniteur;
    }

  

    public int getIdPassageDeGrade() {
        return idPassageDeGrade;
    }

    public void setIdPassageDeGrade(int idPassageDeGrade) {
        this.idPassageDeGrade = idPassageDeGrade;
    }

    public Date getDatePassage() {
        return datePassage;
    }

    public void setDatePassage(Date datePassage) {
        this.datePassage = datePassage;
    }
    
     public String getDatePassageSQL() {
        String tmp;

        if (this.datePassage == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
          tmp = "'" + dateParser.format(this.datePassage) + "'";
          }
        return tmp;
    }
     
      public String getDatePassageBE() {
        String tmp;

        if (this.datePassage == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
          tmp = dateParser.format(this.datePassage);
          }
        return tmp;
    }

    public void setDatePassageBE(String datePass) {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.datePassage = dateParser.parse(datePass);
        } catch (ParseException ex) {
            Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCotePartie1() {
        return cotePartie1;
    }

    public void setCotePartie1(int cotePartie1) {
        this.cotePartie1 = cotePartie1;
    }

    public int getCotePartie2() {
        return cotePartie2;
    }

    public void setCotePartie2(int cotePartie2) {
        this.cotePartie2 = cotePartie2;
    }

    public int getCotePartie3() {
        return cotePartie3;
    }

    public void setCotePartie3(int cotePartie3) {
        this.cotePartie3 = cotePartie3;
    }

    public int getCoteRandori() {
        return coteRandori;
    }

    public void setCoteRandori(int coteRandori) {
        this.coteRandori = coteRandori;
    }

    public int getCoteTotal() {
        return coteTotal;
    }

    public void setCoteTotal(int coteTotal) {
        this.coteTotal = coteTotal;
    }

    public String getGradeDesire() {
        return gradeDesire;
    }

    public void setGradeDesire(String gradeDesire) {
        this.gradeDesire = gradeDesire;
    }

    
    
    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    public Moniteur getIdMoniteur() {
        return idMoniteur;
    }

    public void setIdMoniteur(Moniteur idMoniteur) {
        this.idMoniteur = idMoniteur;
    }


}
