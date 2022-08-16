package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelParticipe extends javax.swing.table.AbstractTableModel {
     // corrige par Stage
    private String[] columnNames = {"Ident Moniteur","Nom Moniteur","Prénom Moniteur","Date de Naissance","Grade",
        "Ident Stage","Nom Stage","Date stage","Date limite inscription","prix inscription","lieu","Nombre max de participants",
    "Duree(Jours)"}; // pour stage 
    private ArrayList <Participe> myList;

    public TableModelParticipe(ArrayList myList)
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
        
        Participe parti = myList.get(row);
        switch (col)
        {// pour stage
            case 0 :    return parti.getIdMoniteur().getIdMoniteur();
            case 1 :    return parti.getIdMoniteur().getNom();
            case 2 :    return parti.getIdMoniteur().getPrenom();
            case 3 :    return parti.getIdMoniteur().getAnneeNaissance();
            case 4 :    return parti.getIdMoniteur().getGrade();
            case 5 :    return parti.getIdStage().getIdStage();
            case 6 :    return parti.getIdStage().getNom();
            case 7 :    return parti.getIdStage().getDateEvenementBE();
            case 8 :    return parti.getIdStage().getDateLimiteInscriptionBE();
            case 9 :    return parti.getIdStage().getPrixInscription();
            case 10 :   return parti.getIdStage().getLieu();
            case 11 :   return parti.getIdStage().getNbreMax();
            case 12 :   return parti.getIdStage().getDuree();
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
    
    public ArrayList <Participe> getMyList ()
    {
        return myList;
    }
    
    public Participe getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

