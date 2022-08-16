package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelPaye extends javax.swing.table.AbstractTableModel {
     //Eleve Cotisation => title
    private String[] columnNames = {"Ident Eleve","Nom Eleve","Prénom Eleve","Date de Naissance","Grade",
        "Ident Cotisation","Accompte ","Total Annuel","Rabais","Date Payement","Année de la Cotisation","Nb Payement "}; 
    private ArrayList <Paye> myList;

    public TableModelPaye(ArrayList myList)
    {
        this.myList = myList;
    }
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return myList.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        
        Paye parti = myList.get(row);
        switch (col)
        {
            case 0 :    return parti.getIdEleve().getIdEleve();
            case 1 :    return parti.getIdEleve().getNom();
            case 2 :    return parti.getIdEleve().getPrenom();
            case 3 :    return parti.getIdEleve().getAnneeNaissance();
            case 4 :    return parti.getIdEleve().getGrade();
            case 5 :    return parti.getIdCotisation().getIdCotisation();
            case 6 :    return parti.getIdCotisation().getAccompte();
            case 7 :    return parti.getIdCotisation().getTotalAnnuel();
            case 8 :    return parti.getIdCotisation().getRabais();
            case 9 :    return parti.getIdCotisation().getDatePayementBE();
            case 10 :   return parti.getIdCotisation().getAnneeCotisation();
            case 11 :   return parti.getIdCotisation().getIdPayement().getNombreVersement();
            
            
            default :   return null;
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    public void setMyList (ArrayList myList)
    {
        this.myList = myList;
        this.fireTableDataChanged();
    }
    
    public ArrayList <Paye> getMyList ()
    {
        return myList;
    }
    
    public Paye getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

