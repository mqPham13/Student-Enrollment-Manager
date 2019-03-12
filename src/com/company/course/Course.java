package com.company.course;


import com.company.duplicatedchecker.Pair;
import com.company.duplicatedchecker.Visitable;
import com.company.duplicatedchecker.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Course implements Visitable {
    private String id;
    private String name;
    private int noCredits;

    //Composite Pattern
    private List<Course> courseList = new ArrayList<>();
    private String toBeCompared;

    public Course(String id, String name, int noCredits) {
        this.id = id;
        this.name = name;
        this.noCredits = noCredits;
    }

    public Course(){}

    public void setToBeCompared(String toBeCompared) {
        this.toBeCompared = toBeCompared;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public String toString() {
        return "id: " + id + " " +
                "| name: " + name + " " +
                "| noCredits: " + noCredits;
    }

    public void getAllCourses() {
        for (Course course : courseList) {
            System.out.println(course.toString());
        }
    }

    @Override
    public Pair invite(Visitor visitor) {
        return visitor.visit(this.courseList, toBeCompared);
    }
}
