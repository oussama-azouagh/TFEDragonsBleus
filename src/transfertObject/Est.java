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

//Competition d'un TypeCompetition
public class Est {
    private Competition idCompetition;
    private TypeCompetition idTypeCompetition;

    public Est() {
    }

    public Est(Competition idCompetition, TypeCompetition idTypeCompetition) {
        this.idCompetition = idCompetition;
        this.idTypeCompetition = idTypeCompetition;
    }

    public Competition getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(Competition idCompetition) {
        this.idCompetition = idCompetition;
    }

    public TypeCompetition getIdTypeCompetition() {
        return idTypeCompetition;
    }

    public void setIdTypeCompetition(TypeCompetition idTypeCompetition) {
        this.idTypeCompetition = idTypeCompetition;
    }
    
    
    
}
