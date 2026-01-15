package com.example.cse213finalproject.sakibModelClass;

import java.io.Serializable;
import java.time.LocalDate;

public class Maintenance implements Serializable {
    private String vehicleID;
    private String crewNo;
    private String maintenanceType;
    private LocalDate expCompleteDate;

    public Maintenance(String vehicleID, String crewNo, String maintenanceType, LocalDate expCompleteDate) {
        this.vehicleID = vehicleID;
        this.crewNo = crewNo;
        this.maintenanceType = maintenanceType;
        this.expCompleteDate = expCompleteDate;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getCrewNo() {
        return crewNo;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public LocalDate getExpCompleteDate() {
        return expCompleteDate;
    }
}
