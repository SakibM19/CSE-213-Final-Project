package com.example.cse213finalproject.sakibModelClass;

import java.time.LocalDate;

public class Maintenance {

    protected String maintenanceStatus, maintenanceType;
    protected LocalDate nextDate, lastDate;

    public Maintenance() {
    }

    public Maintenance(String maintenanceStatus, String maintenanceType, LocalDate nextDate, LocalDate lastDate) {
        this.maintenanceStatus = maintenanceStatus;
        this.maintenanceType = maintenanceType;
        this.nextDate = nextDate;
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceStatus='" + maintenanceStatus + '\'' +
                ", maintenanceType='" + maintenanceType + '\'' +
                ", nextDate=" + nextDate +
                ", lastDate=" + lastDate +
                '}';
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public LocalDate getNextDate() {
        return nextDate;
    }

    public void setNextDate(LocalDate nextDate) {
        this.nextDate = nextDate;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }
}
