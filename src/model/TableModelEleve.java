package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelEleve extends javax.swing.table.AbstractTableModel {
    
   // private String[] columnNames = {"Ident Eleve","Nom","Prénom","Année de Naissance","Numero de tél.","Num Affilié Fédération","Assurance",
   // "Grade","Adresse E-mail","Categorie","Adresse","Numero","Boite","Code Postal","Ville"};
    
    
    private String[] columnNames = {"Ident Eleve","Nom","Prénom","Année de Naissance","Numero de tél.","Num Affilié Fédération","Assurance",
   "Grade","Adresse E-mail","Categorie","Adresse","Numero","Boite"};
    private ArrayList <Eleve> myList;

    public TableModelEleve(ArrayList myList)
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
     
       Eleve elv = myList.get(row);
        switch (col)
        {
            case 0 :    return elv.getIdEleve();
            case 1 :    return elv.getNom();
            case 2 :    return elv.getPrenom();
            case 3 :    return elv.getAnneeNaissance();
            case 4 :    return elv.getTelephone();
            case 5 :    return elv.getNumAffilieFederation();
            case 6 :    return elv.isAssurance();
            case 7 :    return elv.getGrade();
            case 8 :    return elv.getMail();
            case 9 :    return elv.getIdCategorie().getDescription();
            case 10 :   return elv.getIdAdresse().getNomAdresse();
            case 11 :   return elv.getIdAdresse().getNumero();
            case 12 :   return elv.getIdAdresse().getBoite();
           // case 13 :   return elv.getIdAdresse().getCodePostal();
           // case 14 :   return elv.getIdAdresse().getIdVille().getIdVille();
               
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
    
    public ArrayList <Eleve> getMyList ()
    {
        return myList;
    }
    
    public Eleve getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

