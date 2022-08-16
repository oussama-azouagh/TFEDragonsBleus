package model;

import java.util.*; // pour ArrayList
import transfertObject.Ville;

public class ListModelVille extends javax.swing.AbstractListModel {
    
    private ArrayList <Ville> myList;

    public ListModelVille (ArrayList myList)
    {
        this.myList = myList;
    }
    
    public Object getElementAt (int index)
    {
        return myList.get(index).getNom();
    }

    public int getSize()
    {
        return myList.size();
    }
    
    public void setMyList (ArrayList <Ville> myList)
    {
        this.myList = myList;
        this.fireContentsChanged(this, 0, getSize());
    }
    
    public ArrayList <Ville> getMyList ()
    {
        return myList;
    }
    
    public Ville getMyList (int index)
    {
        return myList.get(index);
    }
}

