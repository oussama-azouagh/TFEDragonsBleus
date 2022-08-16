package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelCotisation extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Cotisation","Accompte","Total Annuel","Rabais","Date de Payement","Année de Cotisation", "Nombre de Versement"};
    private ArrayList <Cotisation> myList;

    public TableModelCotisation(ArrayList myList)
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
        
        Cotisation cot = myList.get(row);
        switch (col)
        {
            case 0 :    return cot.getIdCotisation();
            case 1 :    return cot.getAccompte();
            case 2 :    return cot.getTotalAnnuel();
            case 3 :    return cot.getRabais();
            case 4 :    return cot.getDatePayementBE();
            case 5 :    return cot.getAnneeCotisation();
            case 6 :    return cot.getIdPayement().getNombreVersement();
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
    
    public ArrayList <Cotisation> getMyList ()
    {
        return myList;
    }
    
    public Cotisation getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

