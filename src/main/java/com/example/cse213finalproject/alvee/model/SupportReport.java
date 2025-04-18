package com.example.cse213finalproject.alvee.model;

import java.time.LocalDate;

public class SupportReport {
    private int totalTickets;
    private int resolvedTickets;
    private double averageResolutionDays;
    private String mostCommonIssue;
    private LocalDate startDate;
    private LocalDate endDate;

    public SupportReport(int totalTickets, int resolvedTickets, double averageResolutionDays, String mostCommonIssue, LocalDate startDate, LocalDate endDate) {
        this.totalTickets = totalTickets;
        this.resolvedTickets = resolvedTickets;
        this.averageResolutionDays = averageResolutionDays;
        this.mostCommonIssue = mostCommonIssue;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SupportReport(int totalTickets, int resolvedTickets, double averageResolutionDays, String mostCommonIssue) {
        this.totalTickets = totalTickets;
        this.resolvedTickets = resolvedTickets;
        this.averageResolutionDays = averageResolutionDays;
        this.mostCommonIssue = mostCommonIssue;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getResolvedTickets() {
        return resolvedTickets;
    }

    public double getAverageResolutionDays() {
        return averageResolutionDays;
    }

    public String getMostCommonIssue() {
        return mostCommonIssue;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void setResolvedTickets(int resolvedTickets) {
        this.resolvedTickets = resolvedTickets;
    }

    public void setAverageResolutionDays(double averageResolutionDays) {
        this.averageResolutionDays = averageResolutionDays;
    }

    public void setMostCommonIssue(String mostCommonIssue) {
        this.mostCommonIssue = mostCommonIssue;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "SupportReport{" +
                "totalTickets=" + totalTickets +
                ", resolvedTickets=" + resolvedTickets +
                ", averageResolutionDays=" + averageResolutionDays +
                ", mostCommonIssue='" + mostCommonIssue + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
