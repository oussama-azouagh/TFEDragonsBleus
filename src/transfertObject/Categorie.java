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
public class Categorie {
    // explique a quelle categorie appartient l'eleve et permet ainsi de calculer la cotisation annuel
    private int idCategorie;
    private String description;
    private int tarifCotisation;

    public Categorie() {
    }

    public Categorie(int idCategorie, String description, int tarifCotisation) {
        this.idCategorie = idCategorie;
        this.description = description;
        this.tarifCotisation = tarifCotisation;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTarifCotisation() {
        return tarifCotisation;
    }

    public void setTarifCotisation(int tarifCotisation) {
        this.tarifCotisation = tarifCotisation;
    }
    
    
}
