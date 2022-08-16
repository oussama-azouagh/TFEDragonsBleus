package model;

import java.util.*; // pour ArrayList
import transfertObject.Local;

public class ListModelLocal extends javax.swing.AbstractListModel {
    
    private ArrayList <Local> myList;

    public ListModelLocal (ArrayList myList)
    {
        this.myList = myList;
    }
    
    public Object getElementAt (int index)
    {
        return myList.get(index).getNomLocal();
    }

    public int getSize()
    {
        return myList.size();
    }
    
    public void setMyList (ArrayList <Local> myList)
    {
        this.myList = myList;
        this.fireContentsChanged(this, 0, getSize());
    }
    
    public ArrayList <Local> getMyList ()
    {
        return myList;
    }
    
    public Local getMyList (int index)
    {
        return myList.get(index);
    }
}

