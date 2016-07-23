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
public class SecurityLevel {
    private String lblLevel;
    private SecurityLevel upLevel;
    private SecurityLevel downLevel;
    public SecurityLevel(String lblLevel,SecurityLevel downLevel){
        this.lblLevel = lblLevel;
        //this.upLevel = upLevel;
        this.downLevel = downLevel;
    }

    /**
     * @return the lblLevel
     */
    public String getLblLevel() {
        return lblLevel;
    }

    /**
     * @param lblLevel the lblLevel to set
     */
    public void setLblLevel(String lblLevel) {
        this.lblLevel = lblLevel;
    }

    /**
     * @return the upLevel
     */
    public SecurityLevel getUpLevel() {
        return upLevel;
    }

    /**
     * @param upLevel the upLevel to set
     */
    public void setUpLevel(SecurityLevel upLevel) {
        this.upLevel = upLevel;
    }

    /**
     * @return the downLevel
     */
    public SecurityLevel getDownLevel() {
        return downLevel;
    }

    /**
     * @param downLevel the downLevel to set
     */
    public void setDownLevel(SecurityLevel downLevel) {
        this.downLevel = downLevel;
    }
}
