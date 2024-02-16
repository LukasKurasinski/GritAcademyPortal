package models;

import java.io.Serializable;

/**
 * User bean represents the user connected to the Grit Academy Portal
 */
public class UserBean implements Serializable {

    private USER_TYPE userType;
    private PRIVILAGE_TYPE userPrivilage = PRIVILAGE_TYPE.user;
    private STATE_TYPE stateType = STATE_TYPE.anonymous;

    public UserBean(){}

    public void setStateType(STATE_TYPE stateType) {
        this.stateType = stateType;
    }

    public void setUserPrivilage(PRIVILAGE_TYPE userPrivilage) {
        this.userPrivilage = userPrivilage;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }

    public PRIVILAGE_TYPE getUserPrivilage() {
        return userPrivilage;
    }

    public STATE_TYPE getStateType() {
        return stateType;
    }

    public USER_TYPE getUserType() {
        return userType;
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
enum STATE_TYPE {
    anonymous,
    confirmed
}
