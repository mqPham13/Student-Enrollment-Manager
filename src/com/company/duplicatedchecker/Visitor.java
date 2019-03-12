package com.company.duplicatedchecker;

import com.company.course.Course;
import com.company.enrollment.StudentEnrollment;
import com.company.list.StudentList;

import java.util.List;

public interface Visitor {
    public Pair visit(StudentList studentList, String studentId);
    public Pair visit(List<Course> courseList, String courseId);
    public Pair visit(List<StudentEnrollment> studentEnrollmentList, StudentEnrollment enrollment);
}
