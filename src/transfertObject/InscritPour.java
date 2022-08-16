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

// Moniteur inscrit pour Competition
public class InscritPour {
    private Moniteur idMoniteur;
    private Competition idCompetition;

    public InscritPour() {
    }

    public InscritPour(Moniteur idMoniteur, Competition idCompetition) {
        this.idMoniteur = idMoniteur;
        this.idCompetition = idCompetition;
    }

    public Moniteur getIdMoniteur() {
        return idMoniteur;
    }

    public void setIdMoniteur(Moniteur idMoniteur) {
        this.idMoniteur = idMoniteur;
    }

    public Competition getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(Competition idCompetition) {
        this.idCompetition = idCompetition;
    }
    
    
}
