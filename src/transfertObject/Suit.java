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

//Eleve est inscrit a Stage
public class Suit {
    private Eleve idEleve;
    private Stage idStage;

    public Suit() {
    }

    public Suit(Eleve idEleve, Stage idStage) {
        this.idEleve = idEleve;
        this.idStage = idStage;
    }

    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    public Stage getIdStage() {
        return idStage;
    }

    public void setIdStage(Stage idStage) {
        this.idStage = idStage;
    }
    
}
