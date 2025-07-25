package com.incident;

import java.sql.Timestamp;

public class Incident {
    private int id;
    private String name, email, issue, description, imageFilename, status, assignedTo;
    private Timestamp submittedAt;

    public Incident(int id, String name, String email, String issue, String description, String imageFilename, String status, String assignedTo, Timestamp submittedAt) {
        this.setId(id); this.setName(name); this.setEmail(email); this.setIssue(issue); this.setDescription(description);
        this.setImageFilename(imageFilename); this.setStatus(status); this.setAssignedTo(assignedTo); this.setSubmittedAt(submittedAt);
    }
    
    // Getters and setters...
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Timestamp getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(Timestamp submittedAt) {
		this.submittedAt = submittedAt;
	}
}
