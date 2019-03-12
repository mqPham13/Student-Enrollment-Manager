package com.company.student;

public class Student {
    private String id;
    private String name;
    private String birthdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "id: " + id + " " +
                "| name: " + name + " " +
                "| birthdate: " + birthdate;
    }
}
