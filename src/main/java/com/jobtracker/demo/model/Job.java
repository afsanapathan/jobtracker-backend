package com.jobtracker.demo.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")
public class Job {

    @Id
    private String id;

    private String companyName;
    private String role;
    private String status;
    private String appliedDate;
    private String followUpDate;
    private String notes;

    // ✅ No-args constructor (REQUIRED)
    public Job() {
    }

    // ✅ Parameterized constructor
    public Job(String companyName, String role, String status,
               String appliedDate, String followUpDate, String notes) {
        this.companyName = companyName;
        this.role = role;
        this.status = status;
        this.appliedDate = appliedDate;
        this.followUpDate = followUpDate;
        this.notes = notes;
    }

    // ✅ Getters

    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public String getFollowUpDate() {
        return followUpDate;
    }

    public String getNotes() {
        return notes;
    }
    // ✅ Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}