package com.riwi.entities;

public class Company {
    private int id;
    private String name;
    private String location;

    public Company(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Company(String name, String location) {
        this.name = name;
        this.location = location;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        var lines = new String[] {
                String.format("id: %d", getId()),
                String.format("name: %s", getName()),
                String.format("location: %s", getLocation()),
        };
        return String.join("\n", lines);

    }
}
