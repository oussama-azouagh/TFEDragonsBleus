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

// Eleve participe a Competition 
public class Participation {
    private Eleve idEleve;
    private Competition idCompetition;

    public Participation() {
    }

    public Participation(Eleve idEleve, Competition idCompetition) {
        this.idEleve = idEleve;
        this.idCompetition = idCompetition;
    }

    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    public Competition getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(Competition idCompetition) {
        this.idCompetition = idCompetition;
    }
    
    
    
}
