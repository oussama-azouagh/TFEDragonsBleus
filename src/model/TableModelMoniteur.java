package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelMoniteur extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Moniteur","Nom","Prénom","Année de Naissance","Numero de tél.","Num Affilié Fédération","Assurance",
    "Grade","Adresse E-mail","Adresse"};
    private ArrayList <Moniteur> myList;

    public TableModelMoniteur(ArrayList myList)
    {
        this.myList = myList;
        //this.fireTableDataChanged();
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
        
       Moniteur moni = myList.get(row);
      
        switch (col)
        {
            case 0 :    return moni.getIdMoniteur();
            case 1 :    return moni.getNom();
            case 2 :    return moni.getPrenom();
            case 3 :    return moni.getAnneeNaissance();
            case 4 :    return moni.getTelephone();
            case 5 :    return moni.getNumAffilieFederation();
            case 6 :    return moni.isAssurance();
            case 7 :    return moni.getGrade();
            case 8 :    return moni.getMail();
            case 9 :    return moni.getIdAdresse().getNomAdresse().toString();
            //case 10 :   return moni.getIdAdresse().getNumero();
           // case 11 :   return moni.getIdAdresse().getBoite();
           // case 12 :   return moni.getIdAdresse().getCodePostal();
           // case 13 :   return moni.getIdAdresse().getIdVille().getNom();
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
    
    public ArrayList <Moniteur> getMyList ()
    {
        return myList;
    }
    
    public Moniteur getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

