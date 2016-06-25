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
public class ClSubject {
    private String subjectName;
    private SecurityLevel currentSecLvl;
    private SecurityLevel maxSecLvl;

    public ClSubject(String subjectName,SecurityLevel currentSecLvl,SecurityLevel maxSecLvl){
        this.subjectName=subjectName;
        this.currentSecLvl=currentSecLvl;
        this.maxSecLvl=maxSecLvl;
    }
    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    /**
     * @return the maxSecLvl
     */
    public SecurityLevel getMaxSecLvl() {
        return maxSecLvl;
    }

    /**
     * @param maxSecLvl the maxSecLvl to set
     */
    public void setMaxSecLvl(SecurityLevel maxSecLvl) {
        this.maxSecLvl = maxSecLvl;
    }
}
