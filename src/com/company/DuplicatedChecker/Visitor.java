package com.company.DuplicatedChecker;

import com.company.Lists.CourseList;
import com.company.Enrollment.StudentEnrollment;
import com.company.Lists.StudentList;

import java.util.List;

public interface Visitor {
    public Pair visit(StudentList studentList, String studentId);
    public Pair visit(CourseList courseList, String courseId);
    public Pair visit(List<StudentEnrollment> studentEnrollmentList, StudentEnrollment enrollment);
}
