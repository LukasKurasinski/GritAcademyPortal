package models;

import java.io.Serializable;

/**
 * User bean represents the user connected to the Grit Academy Portal
 */
public class UserBean implements Serializable {

    private USER_TYPE userType;
    private PRIVILAGE_TYPE privilageType = PRIVILAGE_TYPE.user;
    private STATE_TYPE stateType = models.STATE_TYPE.anonymous;

    public UserBean(){}

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
        return userType + " " + privilageType + " "  + stateType;
    }
}

enum USER_TYPE {
    student,
    teacher
}
enum PRIVILAGE_TYPE {
    user,
    admin,
    superAdmin
}

