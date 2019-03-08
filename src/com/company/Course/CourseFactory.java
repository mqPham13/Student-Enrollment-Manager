package com.company.Course;

import com.company.Course.Course;

public class CourseFactory {
    public static Course createCourse(String id, String name, int noCredits) {
        return new Course(id, name, noCredits);
    }
}
