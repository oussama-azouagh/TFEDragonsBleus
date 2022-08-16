package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelGroupe extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Groupe","Nom Groupe","Année","Age Min Groupe","Age Max Groupe"};
    private ArrayList <Groupe> myList;

    public TableModelGroupe(ArrayList myList)
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
        
        Groupe grp = myList.get(row);
        switch (col)
        {
            case 0 :    return grp.getIdGroupe();
            case 1 :    return grp.getNom();
            case 2 :    return grp.getAnnée();
            case 3 :    return grp.getAgeMin();
            case 4 :    return grp.getAgeMax();
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
    
    public ArrayList <Groupe> getMyList ()
    {
        return myList;
    }
    
    public Groupe getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

