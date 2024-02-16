package models;

import java.io.Serializable;

/**
 * User bean represents the user connected to the Grit Academy Portal
 */
public class UserBean implements Serializable {

    //shoudl be set to the same is it is in the DB
    private int id;
    private USER_TYPE userType;
    private PRIVILAGE_TYPE privilageType = PRIVILAGE_TYPE.user;
    private STATE_TYPE stateType = STATE_TYPE.anonymous;

    public UserBean(){}
    public UserBean(int id, USER_TYPE userType, PRIVILAGE_TYPE privilageType, STATE_TYPE stateType){
        this.id=id;
        this.userType=userType;
        this.privilageType=privilageType;
        this.stateType=stateType;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setStateType(STATE_TYPE stateType) {
        this.stateType = stateType;
    }

    public void setprivilageType(PRIVILAGE_TYPE privilageType) {
        this.privilageType = privilageType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }

    public PRIVILAGE_TYPE getprivilageType() {
        return privilageType;
    }

    public STATE_TYPE getStateType() {
        return stateType;
    }

    public USER_TYPE getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "userType: "+userType + " privilageType: " + privilageType + " stateType: "  + stateType;
    }
}




