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

//Moniteur participe a Stage
public class Participe {
   private Moniteur idMoniteur;
   private Stage idStage;

    public Participe() {
    }

    public Participe(Moniteur idMoniteur, Stage idStage) {
        this.idMoniteur = idMoniteur;
        this.idStage = idStage;
    }

    public Moniteur getIdMoniteur() {
        return idMoniteur;
    }

    public void setIdMoniteur(Moniteur idMoniteur) {
        this.idMoniteur = idMoniteur;
    }

    public Stage getIdStage() {
        return idStage;
    }

    public void setIdStage(Stage idStage) {
        this.idStage = idStage;
    }
   
}
