package com.example.cse213finalproject.sakibModelClass;

import java.io.Serializable;
import java.time.LocalDate;

public class InspectionVehicle implements Serializable {

    private String vehicleID, status, information, comment;
    private LocalDate inspectionDate;

    public InspectionVehicle(String vehicleID, String status, String information, String comment, LocalDate inspectionDate) {
        this.vehicleID = vehicleID;
        this.status = status;
        this.information = information;
        this.comment = "N/A";
        this.inspectionDate = inspectionDate;
    }

    @Override
    public String toString() {
        return "InspectionVehicle{" +
                "vehicleID='" + vehicleID + '\'' +

                ", status='" + status + '\'' +
                ", information='" + information + '\'' +
                ", comment='" + comment + '\'' +
                ", inspectionDate=" + inspectionDate +
                '}';
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public InspectionVehicle() {
    }
}
