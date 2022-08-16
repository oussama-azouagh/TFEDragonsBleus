package model;

import java.util.*; // pour ArrayList
import transfertObject.*;

public class TableModelOccupe extends javax.swing.table.AbstractTableModel {
     // Moniteur Cours Title
    private String[] columnNames = {"Ident Moniteur","Nom Moniteur","Prénom Moniteur","Grade",
        "Jour ","Heure de début","Heure de fin","Nom Local"};  
    private ArrayList <Occupe> myList;

    public TableModelOccupe(ArrayList myList)
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
        
        Occupe ocp = myList.get(row);
        switch (col)
        {
            case 0 :    return ocp.getIdMoniteur().getIdMoniteur();
            case 1 :    return ocp.getIdMoniteur().getNom();
            case 2 :    return ocp.getIdMoniteur().getPrenom();
            case 3 :    return ocp.getIdMoniteur().getGrade();
            case 4 :    return ocp.getIdCours().getJours();
            case 5 :    return ocp.getIdCours().getHeureDebut();
            case 6 :    return ocp.getIdCours().getHeureFin();
            case 7 :    return ocp.getIdCours().getIdLocal().getNomLocal();
 
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
    
    public ArrayList <Occupe> getMyList ()
    {
        return myList;
    }
    
    public Occupe getMyList (int index)
    {
        return myList.get(index);
    }
    
 
}

