package com.pgs.BugMonitor.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.sql.Date;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @Column(name = "ProjectID")
    private int projectId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "STARTDATE")
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "PROJECTMANAGER", referencedColumnName = "userID")
    private Users projectManager;

    // No-argument constructor
    public Project() {
    }

    // Parameterized constructor
    public Project(int projectId, String name, String description, Users projectManager, Date startDate) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.projectManager = projectManager;
        this.startDate = startDate;
    }

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Users projectManager) {
        this.projectManager = projectManager;
    }

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }
}

