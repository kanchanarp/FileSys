/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accessControl;

import security.ClSubject;
import security.SecurityLevel;

/**
 *
 * @author kanchanaR
 */
public class ClUser extends ClSubject{

    public ClUser(String subjectName, SecurityLevel currentSecLvl, SecurityLevel maxSecLvl) {
        super(subjectName, currentSecLvl, maxSecLvl);
    }
    
}
