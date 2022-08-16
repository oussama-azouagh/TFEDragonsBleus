package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelCompetition extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Competition","Nom Competition","Date Evenement","Date Limite","Type Competition"," Prix inscription","Lieu","Durée"};
    private ArrayList <Competition> myList;

    public TableModelCompetition (ArrayList myList)
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
        
        Competition comp = myList.get(row);
        switch (col)
        {
            case 0 :    return comp.getIdCompetition();
            case 1 :    return comp.getNom();
            case 2 :    return comp.getDateEvenement();
            case 3 :    return comp.getDateLimiteInscription();
            case 4 :    return comp.getidTypeCompetition().getNomType();
            case 5 :    return comp.getPrixInscription();
            case 6 :    return comp.getLieu();
            case 7 :    return comp.getDuree();
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
    
    public ArrayList <Competition> getMyList ()
    {
        return myList;
    }
    
    public Competition getMyList (int index)
    {
        return myList.get(index);
    }
    
   
  
}

