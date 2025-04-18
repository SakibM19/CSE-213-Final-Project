package com.example.cse213finalproject.alvee.model;

import java.util.ArrayList;
import java.util.List;

public class Complaint {
    private String id;
    private String customerName;
    private String customerEmail;
    private String bookingId;
    private String subject;
    private String description;
    private String status;
    private List<String> attachments;
    private List<String> internalNotes;

    // Constructor
    public Complaint(String id, String customerName, String customerEmail,
                     String bookingId, String subject, String description,
                     String status) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.bookingId = bookingId;
        this.subject = subject;
        this.description = description;
        this.status = status;
        this.attachments = new ArrayList<>();
        this.internalNotes = new ArrayList<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<String> getAttachments() { return attachments; }
    public void addAttachment(String attachmentPath) { attachments.add(attachmentPath); }

    public List<String> getInternalNotes() { return internalNotes; }
    public void addNote(String note) { internalNotes.add(note); }

    @Override
    public String toString() {
        return "Complaint{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", attachments=" + attachments +
                ", internalNotes=" + internalNotes +
                '}';
    }
}

