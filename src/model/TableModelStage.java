package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelStage extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Stage","Nom Stage","Date Evenement","Date Limite","Prix inscription","Lieu","Participant max","Durée"};
    private ArrayList <Stage> myList;

    public TableModelStage(ArrayList myList)
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
        
        Stage sta = myList.get(row);
        switch (col)
        {
            case 0 :    return sta.getIdStage();
            case 1 :    return sta.getNom();
            case 2 :    return sta.getDateEvenementBE();
            case 3 :    return sta.getDateLimiteInscriptionBE();
            case 4 :    return sta.getPrixInscription();
            case 5 :    return sta.getLieu();
            case 6 :    return sta.getNbreMax();
            case 7 :    return sta.getDuree();
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
    
    public ArrayList <Stage> getMyList ()
    {
        return myList;
    }
    
    public Stage getMyList (int index)
    {
        return myList.get(index);
        
    }
    
 
}

