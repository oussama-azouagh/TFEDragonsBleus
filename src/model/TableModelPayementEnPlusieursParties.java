package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelPayementEnPlusieursParties extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Payement","Montant","Nombre de Versement","Ident Cotisation",
        "Accompte","Total Annuel","Rabais","Date Du Payement","Année de Cotisation"};
    private ArrayList <PayementEnPlusieursParties> myList;

    public TableModelPayementEnPlusieursParties(ArrayList myList)
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
        
        PayementEnPlusieursParties pepp = myList.get(row);
        switch (col)
        {
            case 0 :    return pepp.getIdPayement();
            case 1 :    return pepp.getMontant();
            case 2 :    return pepp.getNombreVersement();
            case 3 :    return pepp.getIdCotisation().getIdCotisation();
            case 4 :    return pepp.getIdCotisation().getAccompte();
            case 5 :    return pepp.getIdCotisation().getTotalAnnuel();
            case 6 :    return pepp.getIdCotisation().getRabais();
            case 7 :    return pepp.getIdCotisation().getDatePayementBE();
            case 8 :    return pepp.getIdCotisation().getAnneeCotisation();
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
    
    public ArrayList <PayementEnPlusieursParties> getMyList ()
    {
        return myList;
    }
    
    public PayementEnPlusieursParties getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

