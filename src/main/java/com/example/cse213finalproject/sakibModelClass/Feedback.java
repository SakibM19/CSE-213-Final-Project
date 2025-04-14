package com.example.cse213finalproject.sakibModelClass;

public class Feedback {
    public int vehicleCondition, cleanliness, comfort;
    public String additionalComment;

    public Feedback(int vehicleCondition, int cleanliness, int comfort, String additionalComment) {
        this.vehicleCondition = vehicleCondition;
        this.cleanliness = cleanliness;
        this.comfort = comfort;
        this.additionalComment = additionalComment;
    }

    public Feedback() {
    }

    public int getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(int vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getComfort() {
        return comfort;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "vehicleCondition=" + vehicleCondition +
                ", cleanliness=" + cleanliness +
                ", comfort=" + comfort +
                ", additionalComment='" + additionalComment + '\'' +
                '}';
    }
}
