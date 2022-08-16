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

// Eleve est inscrit dans Groupe
public class EstInscrit {
    private Eleve idEleve;
    private Groupe idGroupe;

    public EstInscrit() {
    }

    public EstInscrit(Eleve idEleve, Groupe idGroupe) {
        this.idEleve = idEleve;
        this.idGroupe = idGroupe;
    }

    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    public Groupe getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Groupe idGroupe) {
        this.idGroupe = idGroupe;
    }
    
}
