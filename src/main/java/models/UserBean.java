package models;

import java.io.Serializable;

public class UserBean implements Serializable {

    private String myVar = "";

    public UserBean(){}

    public String getMyVar() {
        return myVar;
    }

    public void setMyVar(String myVar) {
        this.myVar = myVar;
    }
}
