/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfertObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MediaMonster
 */
public class Eleve {
    private int idEleve;
    private String nom;
    private String prenom;
    private Date anneeNaissance; //Date de Naissance de l'eleve + java.util.Date car on ne peut pas parser un String en java.sql.Date !
    private int telephone;
    private int numAffilieFederation; // numero unique creer par la federation au moment de la 1er inscription
    private boolean assurance; // permet de savoir si l'eleve est assuré ou pas 
    private String grade; // couleur de la ceinture
    private String mail;  
    private Categorie idCategorie;
    private  Adresse idAdresse;

    public Eleve() {
    }
    
    public Eleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public Eleve(int idEleve, String nom, String prenom, Date anneeNaissance, int telephone, int numAffilieFederation, boolean assurance, String grade, String mail, Categorie idCategorie, Adresse idAdresse) {
        this.idEleve = idEleve;
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.telephone = telephone;
        this.numAffilieFederation = numAffilieFederation;
        this.assurance = assurance;
        this.grade = grade;
        this.mail = mail;
        this.idCategorie = idCategorie;
        this.idAdresse = idAdresse;
    }

 

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(Date anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }
    
    public String getAnneeNaissanceSQL() {
        String tmp;

        if (this.anneeNaissance == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
          tmp = "'" + dateParser.format(this.anneeNaissance) + "'";
          }
        return tmp;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getNumAffilieFederation() {
        return numAffilieFederation;
    }

    public void setNumAffilieFederation(int numAffilieFederation) {
        this.numAffilieFederation = numAffilieFederation;
    }

    public boolean isAssurance() {
        return assurance;
    }

    public void setAssurance(boolean assurance) {
        this.assurance = assurance;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public Adresse getIdAdresse() {
        return idAdresse;
    }
    
    
    
}


