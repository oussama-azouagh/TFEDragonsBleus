package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelParticipation extends javax.swing.table.AbstractTableModel {
     // Eleve Competition Title
    private String[] columnNames = {"Ident Eleve","Nom Eleve","Prénom Eleve","Grade",
        "Ident Competition ","Nom Competition","Date Competition","Date limite inscription","Lieu","Durée(Jours)","Prix Inscription",
    "Type de Competition"};  
    private ArrayList <Participation> myList;

    public TableModelParticipation(ArrayList myList)
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
        
        Participation parti = myList.get(row);
        switch (col)
        {
            case 0 :    return parti.getIdEleve().getIdEleve();
            case 1 :    return parti.getIdEleve().getNom();
            case 2 :    return parti.getIdEleve().getPrenom();
            case 3 :    return parti.getIdEleve().getGrade();
            case 4 :    return parti.getIdCompetition().getIdCompetition();
            case 5 :    return parti.getIdCompetition().getNom();
            case 6 :    return parti.getIdCompetition().getDateEvenementBE();
            case 7 :    return parti.getIdCompetition().getDateLimiteInscriptionBE();
            case 8 :    return parti.getIdCompetition().getLieu();
            case 9 :    return parti.getIdCompetition().getDuree();
            case 10:    return parti.getIdCompetition().getPrixInscription();
            case 11:    return parti.getIdCompetition().getidTypeCompetition().getNomType();
 
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
    
    public ArrayList <Participation> getMyList ()
    {
        return myList;
    }
    
    public Participation getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

