package com.example.cse213finalproject.alvee.model;

import java.io.Serializable;
import java.time.LocalDate;

public class InspectionHistory extends History implements Serializable {
    private String inspectionId;
    private String inspectorId;

    public InspectionHistory(String historyId, String type, LocalDate date, String inspectionId, String inspectorId) {
        super(historyId, type, date);
        this.inspectionId = inspectionId;
        this.inspectorId = inspectorId;
    }

    public InspectionHistory(String inspectionId, String inspectorId) {
        this.inspectionId = inspectionId;
        this.inspectorId = inspectorId;
    }

    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(String inspectorId) {
        this.inspectorId = inspectorId;
    }

    @Override
    public String toString() {
        return "InspectionHistory{" +
                "inspectionId='" + inspectionId + '\'' +
                ", inspectorId='" + inspectorId + '\'' +
                '}';
    }
}
