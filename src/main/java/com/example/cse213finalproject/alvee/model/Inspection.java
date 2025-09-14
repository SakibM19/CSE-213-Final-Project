package com.example.cse213finalproject.alvee.model;

import com.example.cse213finalproject.util.OrderIdGenerator;

import java.io.Serializable;
import java.time.LocalDate;

public class Inspection implements Serializable {
    private String inspectionId;
    private String carId;
    private LocalDate inspectionDate;
    private String damages;
    private String isClean;
    private double fuelLevel;
    private String isAvailableAfterInspection;
    private String extraNote;
    private String status;


    public Inspection(String carId, LocalDate inspectionDate, String damages, String isClean, double fuelLevel, String isAvailableAfterInspection, String extraNote) {
        this.inspectionId = OrderIdGenerator.generateInspectionId();
        this.carId = carId;
        this.inspectionDate = inspectionDate;
        this.damages = damages;
        this.isClean = isClean;
        this.fuelLevel = fuelLevel;
        this.isAvailableAfterInspection = isAvailableAfterInspection;
        this.extraNote = extraNote;
        this.status = "Incomplete";
    }

    public Inspection() {
    }

    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExtraNote() {
        return extraNote;
    }

    public void setExtraNote(String extraNote) {
        this.extraNote = extraNote;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getDamages() {
        return damages;
    }

    public void setDamages(String damages) {
        this.damages = damages;
    }





    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public String getIsClean() {
        return isClean;
    }

    public void setIsClean(String isClean) {
        this.isClean = isClean;
    }

    public String getIsAvailableAfterInspection() {
        return isAvailableAfterInspection;
    }

    public void setIsAvailableAfterInspection(String isAvailableAfterInspection) {
        this.isAvailableAfterInspection = isAvailableAfterInspection;
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "inspectionId='" + inspectionId + '\'' +
                ", carId='" + carId + '\'' +
                ", inspectionDate=" + inspectionDate +
                ", damages='" + damages + '\'' +
                ", isClean='" + isClean + '\'' +
                ", fuelLevel=" + fuelLevel +
                ", isAvailableAfterInspection='" + isAvailableAfterInspection + '\'' +
                ", extraNote='" + extraNote + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

