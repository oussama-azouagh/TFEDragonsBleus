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

// Eleve paye une cotisation
public class Paye {
    private Eleve idEleve;
    private Cotisation idCotisation;

    public Paye() {
    }
    

    public Paye(Eleve idEleve, Cotisation idCotisation) {
        this.idEleve = idEleve;
        this.idCotisation = idCotisation;
    }

    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    public Cotisation getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(Cotisation idCotisation) {
        this.idCotisation = idCotisation;
    }
    
    
    
}
