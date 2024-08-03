package com.riwi.entities;

import com.riwi.enums.Status;

import java.sql.Timestamp;

public class Application {
    private int id;
    private Timestamp date;
    private Status status;
    private int vacanciesId;
    private int codersId;

    public Application(int id, Timestamp date, Status status, int vacanciesId, int codersId) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.vacanciesId = vacanciesId;
        this.codersId = codersId;
    }

    public Application(Timestamp date, Status status, int vacanciesId, int codersId) {
        this.date = date;
        this.status = status;
        this.vacanciesId = vacanciesId;
        this.codersId = codersId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getVacanciesId() {
        return vacanciesId;
    }

    public void setVacanciesId(int vacanciesId) {
        this.vacanciesId = vacanciesId;
    }

    public int getCodersId() {
        return codersId;
    }

    public void setCodersId(int codersId) {
        this.codersId = codersId;
    }

    @Override
    public String toString() {
        var lines = new String[] {
                String.format("id: %d", getId()),
                String.format("status: %s", getStatus()),
                String.format("date: %1$Te/%1$Tm/%1$TY %1$Tr", getDate()),
                String.format("vacanciesId: %d", getVacanciesId()),
                String.format("codersId: %d", getCodersId()),

        };
        return String.join("\n", lines);

    }
}
