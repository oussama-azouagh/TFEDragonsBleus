package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelEst extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Competition","Nom Competition","Date Evenement","Date Max Inscription","prixInscription",
        "Lieu","Duree","Ident Type De Competition","Nom Type Competition" };
    private ArrayList <Est> myList;

    public TableModelEst(ArrayList myList)
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
        
        Est est = myList.get(row);
        switch (col)
        {
            case 0 :    return est.getIdCompetition().getIdCompetition();
            case 1 :    return est.getIdCompetition().getNom();
            case 2 :    return est.getIdCompetition().getDateEvenementBE();
            case 3 :    return est.getIdCompetition().getDateLimiteInscriptionBE();
            case 4 :    return est.getIdCompetition().getPrixInscription();
            case 5 :    return est.getIdCompetition().getLieu();
            case 6 :    return est.getIdCompetition().getDuree();
            case 7 :    return est.getIdTypeCompetition().getIdTypeCompetition();
            case 8 :    return est.getIdTypeCompetition().getNomType();
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
    
    public ArrayList <Est> getMyList ()
    {
        return myList;
    }
    
    public Est getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

