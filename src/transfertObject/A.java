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

// Groupe a Cours
public class A {
    private Groupe idGroupe;
    private Cours idCours;

    public A() {
    }

    public A(Groupe idGroupe, Cours idCours) {
        this.idGroupe = idGroupe;
        this.idCours = idCours;
    }

    public Groupe getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Groupe idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Cours getIdCours() {
        return idCours;
    }

    public void setIdCours(Cours idCours) {
        this.idCours = idCours;
    }
    
    
}
