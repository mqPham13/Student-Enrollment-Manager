package com.company;

public class CourseFactory {
    public static Course createCourse(String id, String name, int noCredits) {
        return new Course(id, name, noCredits);
    }
}
