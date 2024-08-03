package com.riwi.entities;

import com.riwi.enums.Technology;

public class Coder {
    private int id;
    private String dni;
    private String name;
    private String lastnames;
    private String clan;
    private String cohort;
    private Technology techProfile;

    public Coder(int id, String dni, String name, String lastnames, String clan, String cohort, Technology techProfile) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastnames = lastnames;
        this.clan = clan;
        this.cohort = cohort;
        this.techProfile = techProfile;
    }

    public Coder(String dni, String name, String lastnames, String clan, String cohort, Technology techProfile) {
        this.dni = dni;
        this.name = name;
        this.lastnames = lastnames;
        this.clan = clan;
        this.cohort = cohort;
        this.techProfile = techProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    public Technology getTechProfile() {
        return techProfile;
    }

    public void setTechProfile(Technology techProfile) {
        this.techProfile = techProfile;
    }

    @Override
    public String toString() {
        var lines = new String[] {
                String.format("id: %d", getId()),
                String.format("dni: %s", getDni()),
                String.format("name: %s", getName()),
                String.format("lastnames: %s", getLastnames()),
                String.format("clan: %s", getClan()),
                String.format("cohort: %s", getCohort()),
                String.format("profile: %s", getTechProfile())
        };
        return String.join("\n", lines);
    }
}
