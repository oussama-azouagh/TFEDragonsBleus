/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfertObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MediaMonster
 */
public class Cotisation {
    private int idCotisation;
    private int accompte;
    private int totalAnnuel;
    private int rabais;
    private Date datePayement; //date a laquelle la totalité a ete payer + java.util.Date car on ne peut pas parser un String en java.sql.Date !  
    private String anneeCotisation; // année à laquelle se rapporte la cotisation
    private PayementEnPlusieursParties idPayement;

    public Cotisation() {
    }

    public Cotisation(int idCotisation, int accompte, int totalAnnuel, int rabais, Date datePayement, String anneeCotisation, PayementEnPlusieursParties idPayement) {
        this.idCotisation = idCotisation;
        this.accompte = accompte;
        this.totalAnnuel = totalAnnuel;
        this.rabais = rabais;
        this.datePayement = datePayement;
        this.anneeCotisation = anneeCotisation;
        this.idPayement = idPayement;
    }

  
    public int getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(int idCotisation) {
        this.idCotisation = idCotisation;
    }

    public int getAccompte() {
        return accompte;
    }

    public void setAccompte(int accompte) {
        this.accompte = accompte;
    }

    public PayementEnPlusieursParties getIdPayement() {
        return idPayement;
    }

    public void setIdPayement(PayementEnPlusieursParties idPayement) {
        this.idPayement = idPayement;
    }


    public int getTotalAnnuel() {
        return totalAnnuel;
    }

    public void setTotalAnnuel(int totalAnnuel) {
        this.totalAnnuel = totalAnnuel;
    }

    public int getRabais() {
        return rabais;
    }

    public void setRabais(int rabais) {
        this.rabais = rabais;
    }

    public Date getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Date datePayement) {
        this.datePayement = datePayement;
    }

    public String getAnneeCotisation() {
        return anneeCotisation;
    }

    public void setAnneeCotisation(String anneeCotisation) {
        this.anneeCotisation = anneeCotisation;
    }
    
        public String getDatePayementBE() {
        String tmp;

        if (this.datePayement == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
          tmp = dateParser.format(this.datePayement);
          }
        return tmp;
    }

    public void setDatePayementBE(String datePayementBe) {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.datePayement = dateParser.parse(datePayementBe);
        } catch (ParseException ex) {
            Logger.getLogger(Cotisation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDatePayementSQL() {
        String tmp;

        if (this.datePayement == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
          tmp = "'" + dateParser.format(this.datePayement) + "'";
          }
        return tmp;
    }
    
}
