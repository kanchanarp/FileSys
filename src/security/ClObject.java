/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

/**
 *
 * @author kanchanaR
 */
public class ClObject {
    private String objectName;
    private SecurityLevel currentSecLvl;

    public ClObject(String objectName,SecurityLevel currentSecLvl){
        this.objectName=objectName;
        this.currentSecLvl=currentSecLvl;
    }
    /**
     * @return the subjectName
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /**
     * @return the currentSecLvl
     */
    public SecurityLevel getCurrentSecLvl() {
        return currentSecLvl;
    }

    /**
     * @param currentSecLvl the currentSecLvl to set
     */
    public void setCurrentSecLvl(SecurityLevel currentSecLvl) {
        this.currentSecLvl = currentSecLvl;
    }

}
