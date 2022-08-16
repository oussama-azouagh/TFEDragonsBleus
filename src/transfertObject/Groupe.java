/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfertObject;

/**
 *
 * @author MediaMonster
 */
public class Groupe {
    private int idGroupe;
    private String nom;
    private String année;
    private int ageMin;
    private int ageMax;

    public Groupe() {
    }

    public Groupe(int idGroupe, String nom, String année, int ageMin, int ageMax) {
        this.idGroupe = idGroupe;
        this.nom = nom;
        this.année = année;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAnnée() {
        return année;
    }

    public void setAnnée(String année) {
        this.année = année;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }
    
    
}
