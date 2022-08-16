package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelAdresse extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Adresse","Nom Adresse","Numero","Code Postal","Ident Ville"," Nom Ville"};
    private ArrayList <Adresse> myList;

    public TableModelAdresse (ArrayList myList)
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
        Adresse adr = myList.get(row);
        switch (col)
        {
            case 0 :    return adr.getIdAdresse();
            case 1 :    return adr.getNomAdresse();
            case 2 :    return adr.getNumero();
            case 3 :    return adr.getCodePostal();
            case 4 :    return adr.getIdVille().getIdVille();
            case 5 :    return adr.getIdVille().getNom();
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
    
    public ArrayList <Adresse> getMyList ()
    {
        return myList;
    }
    
    public Adresse getMyList (int index)
    {
        return myList.get(index);
    }
    
   
  
}

