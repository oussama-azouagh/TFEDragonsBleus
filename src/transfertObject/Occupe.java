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

// Moniteur occupe Cours
public class Occupe {
    private Moniteur idMoniteur;
    private Cours idCours;

    public Occupe() {
    }

    public Occupe(Moniteur idMoniteur, Cours idCours) {
        this.idMoniteur = idMoniteur;
        this.idCours = idCours;
    }

    public Moniteur getIdMoniteur() {
        return idMoniteur;
    }

    public void setIdMoniteur(Moniteur idMoniteur) {
        this.idMoniteur = idMoniteur;
    }

    public Cours getIdCours() {
        return idCours;
    }

    public void setIdCours(Cours idCours) {
        this.idCours = idCours;
    }
    
    
}
