package com.example.cred_shashank;

import java.io.Serializable;

/**
 * <b></b>
 * <p>This class is used to </p>
 * Created by Rohit.
 */
class ChildDataItem implements Serializable {
    private String childName;
    private String creditCard;
    private String amount;
    private String approve;

    public ChildDataItem(String childName, String creditCard, String amount, String approve) {
        this.childName = childName;
        this.creditCard = creditCard;
        this.amount = amount;
        this.approve = approve;
    }

    public ChildDataItem(String childName, String creditCard) {
        this.childName = childName;
        this.creditCard = creditCard;
    }


    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }
}
