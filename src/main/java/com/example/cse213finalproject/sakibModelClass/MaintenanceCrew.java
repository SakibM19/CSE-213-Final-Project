package com.example.cse213finalproject.sakibModelClass;

public class MaintenanceCrew {
    protected String crewName;


    public MaintenanceCrew() {
    }

    public MaintenanceCrew(String crewName) {
        this.crewName = crewName;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    @Override
    public String toString() {
        return "MaintenanceCrew{" +
                "crewName='" + crewName + '\'' +
                '}';
    }
}
