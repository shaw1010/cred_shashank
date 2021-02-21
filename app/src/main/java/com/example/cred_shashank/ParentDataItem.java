package com.example.cred_shashank;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <b></b>
 * <p>This class is used to </p>
 * Created by Rohit.
 */
class ParentDataItem implements Serializable {
    private String parentName;
    private ArrayList<ChildDataItem> childDataItems;

    public ParentDataItem(String parentName, ArrayList<ChildDataItem> childDataItems) {
        this.parentName = parentName;
        this.childDataItems = childDataItems;
    }


    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public ArrayList<ChildDataItem> getChildDataItems() {
        return childDataItems;
    }

    public void setChildDataItems(ArrayList<ChildDataItem> childDataItems) {
        this.childDataItems = childDataItems;
    }
}
