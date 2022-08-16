package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelInscritPour extends javax.swing.table.AbstractTableModel {
     // Moniteur et competition => title
    private String[] columnNames = {"Ident Moniteur","Nom Moniteur","Prénom Moniteur","Date de Naissance","En ordre d'Assurance","Grade",
        "Ident Competition","Nom Competition","Date Competition","Date limite inscription","Lieu","Durée(Jours)","Prix Inscription",
    "Type de Competition"}; // pour stage 
    private ArrayList <InscritPour> myList;

    public TableModelInscritPour(ArrayList myList)
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
        
        InscritPour inscrP = myList.get(row);
        switch (col)
        {
            case 0 :    return inscrP.getIdMoniteur().getIdMoniteur();
            case 1 :    return inscrP.getIdMoniteur().getNom();
            case 2 :    return inscrP.getIdMoniteur().getPrenom();
            case 3 :    return inscrP.getIdMoniteur().getAnneeNaissance();
            case 4 :    return inscrP.getIdMoniteur().isAssurance();
            case 5 :    return inscrP.getIdMoniteur().getGrade();
            case 6 :    return inscrP.getIdCompetition().getIdCompetition();
            case 7 :    return inscrP.getIdCompetition().getNom();
            case 8 :    return inscrP.getIdCompetition().getDateEvenementBE();
            case 9 :   return inscrP.getIdCompetition().getDateLimiteInscriptionBE();
            case 10 :   return inscrP.getIdCompetition().getLieu();
            case 11 :   return inscrP.getIdCompetition().getDuree();
            case 12 :   return inscrP.getIdCompetition().getPrixInscription();
            case 13:    return inscrP.getIdCompetition().getidTypeCompetition().getNomType();
             
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
    
    public ArrayList <InscritPour> getMyList ()
    {
        return myList;
    }
    
    public InscritPour getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

