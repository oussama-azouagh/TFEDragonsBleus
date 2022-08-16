package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelCours extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Cours","Nom","Heure de debut","Heure de fin","Jour","Nom du Local"};
    private ArrayList <Cours> myList;

    public TableModelCours(ArrayList myList)
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
        
        Cours cou = myList.get(row);
        switch (col)
        {
            case 0 :    return cou.getIdCours();
            case 1 :    return cou.getNom();
            case 2 :    return cou.getHeureDebut();
            case 3 :    return cou.getHeureFin();
            case 4 :    return cou.getJours();
            case 5 :    return cou.getIdLocal().getNomLocal();
            
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
    
    public ArrayList <Cours> getMyList ()
    {
        return myList;
    }
    
    public Cours getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

