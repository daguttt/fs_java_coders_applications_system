package com.riwi.entities;

import com.riwi.enums.Status;

import java.sql.Timestamp;

public class Vacancy {
    private int id;
    private String title;
    private String description;
    private Timestamp postAt;
    private double salary;
    private Status status;
    private int companiesId;

    public Vacancy(int id, String title, String description, Timestamp postAt, double salary, Status status, int companiesId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postAt = postAt;
        this.salary = salary;
        this.status = status;
        this.companiesId = companiesId;
    }

    public Vacancy(String title, String description, Timestamp postAt, double salary, Status status, int companiesId) {
        this.title = title;
        this.description = description;
        this.postAt = postAt;
        this.salary = salary;
        this.status = status;
        this.companiesId = companiesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getPostAt() {
        return postAt;
    }

    public void setPostAt(Timestamp postAt) {
        this.postAt = postAt;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCompaniesId() {
        return companiesId;
    }

    public void setCompaniesId(int companiesId) {
        this.companiesId = companiesId;
    }

    @Override
    public String toString() {
        var lines = new String[] {
                String.format("id: %d", getId()),
                String.format("title: %s", getTitle()),
                String.format("description: %s", getDescription()),
                String.format("postAt: %1$Te/%1$Tm/%1$TY %1$Tr", getPostAt()),
                String.format("id: %f", getSalary()),
                String.format("status: %s", getStatus()),
                String.format("companiesId: %d", getCompaniesId()),
        };
        return String.join("\n", lines);

    }

}
