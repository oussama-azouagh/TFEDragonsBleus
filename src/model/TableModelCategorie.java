package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelCategorie extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Categorie","Description","Tarif de Cotisation"};
    private ArrayList <Categorie> myList;

    public TableModelCategorie (ArrayList myList)
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
        Categorie cat = myList.get(row);
        switch (col)
        {
            case 0 :    return cat.getIdCategorie();
            case 1 :    return cat.getDescription();
            case 2 :    return cat.getTarifCotisation();
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
    
    public ArrayList <Categorie> getMyList ()
    {
        return myList;
    }
    
    public Categorie getMyList (int index)
    {
        return myList.get(index);
    }
    
   
  
}

