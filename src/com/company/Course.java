package com.company;


public class Course {
    private String id;
    private String name;
    private int noCredits;

    public Course(String id, String name, int noCredits) {
        this.id = id;
        this.name = name;
        this.noCredits = noCredits;
    }

    public Course(){}

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "id: " + id + " " +
                "| name: " + name + " " +
                "| noCredits: " + noCredits;
    }
}
