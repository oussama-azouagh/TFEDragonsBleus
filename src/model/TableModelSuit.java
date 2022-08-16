package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelSuit extends javax.swing.table.AbstractTableModel {
     // corrige par Stage
    private String[] columnNames = {"Ident Eleve","Nom Eleve","Prénom Eleve","Date de Naissance","Grade",
        "Ident Stage","Nom Stage","Date stage","Date limite inscription","prix inscription","lieu","Nombre max de participants",
    "Duree(Jours)"}; // pour stage 
    private ArrayList <Suit> myList;

    public TableModelSuit(ArrayList myList)
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
        
        Suit suit = myList.get(row);
        switch (col)
        {// pour stage
            case 0 :    return suit.getIdEleve().getIdEleve();
            case 1 :    return suit.getIdEleve().getNom();
            case 2 :    return suit.getIdEleve().getPrenom();
            case 3 :    return suit.getIdEleve().getAnneeNaissance();
            case 4 :    return suit.getIdEleve().getGrade();
            case 5 :    return suit.getIdStage().getIdStage();
            case 6 :    return suit.getIdStage().getNom();
            case 7 :    return suit.getIdStage().getDateEvenementBE();
            case 8 :    return suit.getIdStage().getDateLimiteInscriptionBE();
            case 9 :    return suit.getIdStage().getPrixInscription();
            case 10 :   return suit.getIdStage().getLieu();
            case 11 :   return suit.getIdStage().getNbreMax();
            case 12 :   return suit.getIdStage().getDuree();
            //continue 
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
    
    public ArrayList <Suit> getMyList ()
    {
        return myList;
    }
    
    public Suit getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

