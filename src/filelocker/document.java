/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filelocker;

import accessControl.ClUser;
import security.ClObject;
import security.SecurityLevel;

/**
 *
 * @author kanchanaR
 */

public class document extends ClObject{

    private String documentPath;
    private String documentName;
    private String documentType;
    private ClUser uploadedBy;
    public document(String objectName, SecurityLevel currentSecLvl,String documentPath,String documentName,String documentType,ClUser uploadedBy) {
        super(objectName, currentSecLvl);
        this.documentPath=documentPath;
        this.documentName=documentName;
        this.documentType=documentType;
        this.uploadedBy=uploadedBy;
    }   

    /**
     * @return the documentPath
     */
    public String getDocumentPath() {
        return documentPath;
    }

    /**
     * @param documentPath the documentPath to set
     */
    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    /**
     * @return the documentName
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * @param documentName the documentName to set
     */
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    /**
     * @return the documentType
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * @param documentType the documentType to set
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * @return the uploadedBy
     */
    public ClUser getUploadedBy() {
        return uploadedBy;
    }
    
}
