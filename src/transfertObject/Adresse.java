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
public class Adresse {
    
    private int idAdresse;
    private String nomAdresse; //Adresse complète sans le numero ex: rue haute
    private int numero; // numero adresse
    private String boite; //boite appartement ou maison ex:12A
    private int codePostal;
    private Ville idVille;

    public Adresse(int idAdresse, String nomAdresse, int numero, String boite, int codePostal, Ville idVille) {
        this.idAdresse = idAdresse;
        this.nomAdresse = nomAdresse;
        this.numero = numero;
        this.boite = boite;
        this.codePostal = codePostal;
        this.idVille = idVille;
    }
    
    public Adresse(int idAdresse) {
        this.idAdresse = idAdresse;
        }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getNomAdresse() {
        return nomAdresse;
    }

    public void setNomAdresse(String nomAdresse) {
        this.nomAdresse = nomAdresse;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBoite() {
        return boite;
    }

    public void setBoite(String boite) {
        this.boite = boite;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public Ville getIdVille() {
        return idVille;
    }

    public void setIdVille(Ville idVille) {
        this.idVille = idVille;
    }
    
    
    
}
