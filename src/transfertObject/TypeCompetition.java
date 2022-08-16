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
public class TypeCompetition {
    private int idTypeCompetition;
    private String nomType;

    public TypeCompetition() {
    }

    public TypeCompetition(int idTypeCompetition, String nomType) {
        this.idTypeCompetition = idTypeCompetition;
        this.nomType = nomType;
    }

    public int getIdTypeCompetition() {
        return idTypeCompetition;
    }

    public void setIdTypeCompetition(int idTypeCompetition) {
        this.idTypeCompetition = idTypeCompetition;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
    
    
}
