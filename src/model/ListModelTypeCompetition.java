package model;

import java.util.*; // pour ArrayList
import transfertObject.TypeCompetition;

public class ListModelTypeCompetition extends javax.swing.AbstractListModel {
    
    private ArrayList <TypeCompetition> myList;

    public ListModelTypeCompetition (ArrayList myList)
    {
        this.myList = myList;
    }
    
    public Object getElementAt (int index)
    {
        return myList.get(index).getNomType();
    }

    public int getSize()
    {
        return myList.size();
    }
    
    public void setMyList (ArrayList <TypeCompetition> myList)
    {
        this.myList = myList;
        this.fireContentsChanged(this, 0, getSize());
    }
    
    public ArrayList <TypeCompetition> getMyList ()
    {
        return myList;
    }
    
    public TypeCompetition getMyList (int index)
    {
        return myList.get(index);
    }
}

