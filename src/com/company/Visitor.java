package com.company;

import java.util.List;

public interface Visitor {
    public Pair visit(StudentList studentList, String studentId);
    public Pair visit(CourseList courseList, String courseId);
    public Pair visit(List<StudentEnrollment> studentEnrollmentList, StudentEnrollment enrollment);
}
