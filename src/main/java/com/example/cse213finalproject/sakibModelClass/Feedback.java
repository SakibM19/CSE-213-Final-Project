package com.example.cse213finalproject.sakibModelClass;

public class Feedback {

    public String feedbackId;
    public int vehicleCondition;
    public int cleanliness;
    public int comfort;
    public String additionalComment;

    public Feedback(String feedbackId, int vehicleCondition, int cleanliness, int comfort, String additionalComment, String csrReply) {
        this.feedbackId = feedbackId;
        this.vehicleCondition = vehicleCondition;
        this.cleanliness = cleanliness;
        this.comfort = comfort;
        this.additionalComment = additionalComment;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
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

    public double getAverageRating() {
        return (vehicleCondition + cleanliness + comfort) / 3.0;
    }
}

