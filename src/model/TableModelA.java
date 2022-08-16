package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelA extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Groupe","Nom Groupe","Ident Cours","Nom Cours","Heure Debut","Heure Fin", "Jour"};
    private ArrayList <A> myList;

    public TableModelA (ArrayList myList)
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
        /*System.out.println ("getValueAt");
        System.out.println (" row: " + row + " col: " + col);*/
        A a = myList.get(row);
        switch (col)
        {
            case 0 :    return a.getIdGroupe().getIdGroupe();
            case 1 :    return a.getIdGroupe().getNom();
            case 2 :    return a.getIdCours().getIdCours();
            case 3 :    return a.getIdCours().getNom();
            case 4 :    return a.getIdCours().getHeureDebut();
            case 5 :    return a.getIdCours().getHeureFin();
            case 6 :    return a.getIdCours().getJours();
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
    
    public ArrayList <A> getMyList ()
    {
        return myList;
    }
    
    public A getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

