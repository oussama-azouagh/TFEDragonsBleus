package model;

import dao.DAOEleve;
import dao.DAOMoniteur;
import factory.Factory;
import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelPassageDeGrade extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Ident Passage De Grade","Date Du Passage","Cote 1er Partie","Cote 2em Partie",
        "Cote 3em Partie","Cote Randori", "Total des Cotes","Grade Desiré", "Prenom Participant", "Prenom Moniteur"};
    private ArrayList <PassageDeGrade> myList;
    

    public TableModelPassageDeGrade(ArrayList myList)
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
        
        PassageDeGrade pass = myList.get(row);
        
        switch (col)
        {
            case 0 :    return pass.getIdPassageDeGrade();
            case 1 :    return pass.getDatePassageBE();
            case 2 :    return pass.getCotePartie1();
            case 3 :    return pass.getCotePartie2();
            case 4 :    return pass.getCotePartie3();
            case 5 :    return pass.getCoteRandori();
            case 6 :    return pass.getCoteTotal();
            case 7 :    return pass.getGradeDesire();
            case 8 :    return pass.getIdEleve().getIdEleve();
            case 9 :    return pass.getIdMoniteur().getIdMoniteur();
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
    
    public ArrayList <PassageDeGrade> getMyList ()
    {
        return myList;
    }
    
    public PassageDeGrade getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

