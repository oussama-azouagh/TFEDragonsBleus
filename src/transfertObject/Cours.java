/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfertObject;

import java.util.ArrayList;




/**
 *
 * @author MediaMonster
 */
public class Cours {
    private int idCours;
    private String nom;
    private String heureDebut; //heure à laquelle debute le cours 
    private String heureFin; //heure à laquelle finis le cours 
    private String jours;  // jours ou se deroule les cours
    private Local idLocal;

    public Cours() {
    }

 
    public Cours(int idCours, String nom, String heureDebut, String heureFin, String jours, Local idLocal) {
        this.idCours = idCours;
        this.nom = nom;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.jours = jours;
        this.idLocal = idLocal;
    }
    
    

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Local getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Local idLocal) {
        this.idLocal = idLocal;
    }

  

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public String getJours() {
        return jours;
    }

    public void setJours(String jours) {
        this.jours = jours;
    }

  
    
    
}
