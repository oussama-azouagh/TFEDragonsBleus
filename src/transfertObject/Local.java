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
public class Local {
    private int idLocal; // identifiant du local
    private String nomLocal; // nom du local utilisé

    public Local(int idLocal, String nomLocal) {
        this.idLocal = idLocal;
        this.nomLocal = nomLocal;
    }

    public Local() {
        super();
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getNomLocal() {
        return nomLocal;
    }

    public void setNomLocal(String nomLocal) {
        this.nomLocal = nomLocal;
    }
    
    
}
