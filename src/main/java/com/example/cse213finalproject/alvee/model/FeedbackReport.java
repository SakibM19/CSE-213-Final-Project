package com.example.cse213finalproject.alvee.model;

import java.io.Serializable;

public class FeedbackReport implements Serializable {
    private String reportType;
    private String reportText;

    public FeedbackReport(String reportType, String reportText) {
        this.reportType = reportType;
        this.reportText = reportText;
    }

    public FeedbackReport() {
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    @Override
    public String toString() {
        return "FeedbackReport{" +
                "reportType='" + reportType + '\'' +
                ", reportText='" + reportText + '\'' +
                '}';
    }
}
