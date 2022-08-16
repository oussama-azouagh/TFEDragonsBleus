package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelEstInscrit extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Eleve","Nom Eleve","Prénom Eleve","Date de Naissance","Grade",
        "Ident Groupe","Nom Groupe","Année du Groupe" };
    private ArrayList <EstInscrit> myList;

    public TableModelEstInscrit(ArrayList myList)
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
        
        EstInscrit estins = myList.get(row);
        switch (col)
        {
            case 0 :    return estins.getIdEleve().getIdEleve();
            case 1 :    return estins.getIdEleve().getNom();
            case 2 :    return estins.getIdEleve().getPrenom();
            case 3 :    return estins.getIdEleve().getAnneeNaissance();
            case 4 :    return estins.getIdEleve().getGrade();
            case 5 :    return estins.getIdGroupe().getIdGroupe();
            case 6 :    return estins.getIdGroupe().getNom();
            case 7 :    return estins.getIdGroupe().getAnnée();
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
    
    public ArrayList <EstInscrit> getMyList ()
    {
        return myList;
    }
    
    public EstInscrit getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

