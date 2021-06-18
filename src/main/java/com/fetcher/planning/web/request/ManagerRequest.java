package com.fetcher.planning.web.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ManagerRequest {

    @NotNull
    private int idHolidays;

    @NotNull
    private int status;

    @NotBlank
    private String nameManager;


    @NotBlank
    private String lastNameManager;

    private String documentId;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public int getIdHolidays() {
        return idHolidays;
    }

    public void setIdHolidays(int idHolidays) {
        this.idHolidays = idHolidays;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getLastNameManager() {
        return lastNameManager;
    }

    public void setLastNameManager(String lastNameManager) {
        this.lastNameManager = lastNameManager;
    }

    public String getDocumentManager() {
        return documentManager;
    }

    public void setDocumentManager(String documentManager) {
        this.documentManager = documentManager;
    }

    private String documentManager;
}
