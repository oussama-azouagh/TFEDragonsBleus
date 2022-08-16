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
public class PayementEnPlusieursParties {
    
    private int idPayement;
    private int montant;
    private int nombreVersement;
    private Cotisation idCotisation;

    public PayementEnPlusieursParties(int idPayement, int montant, int nombreVersement,Cotisation idCotisation) {
        this.idPayement = idPayement;
        this.montant = montant;
        this.nombreVersement = nombreVersement;
        this.idCotisation = idCotisation;
    }
    
    public PayementEnPlusieursParties(int idPayement, int montant, int nombreVersement) {
        this.idPayement = idPayement;
        this.montant = montant;
        this.nombreVersement = nombreVersement;
    }

    public int getIdPayement() {
        return idPayement;
    }

    public void setIdPayement(int idPayement) {
        this.idPayement = idPayement;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getNombreVersement() {
        return nombreVersement;
    }

    public void setNombreVersement(int nombreVersement) {
        this.nombreVersement = nombreVersement;
    }

    public Cotisation getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(Cotisation idCotisation) {
        this.idCotisation = idCotisation;
    }
    
    
    
}
