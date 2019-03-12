package com.company.duplicatedchecker;
import com.company.course.Course;
import com.company.list.CourseList;
import com.company.enrollment.MemoryStudentEnrollmentManager;
import com.company.enrollment.StudentEnrollment;
import com.company.student.Student;
import com.company.list.StudentList;

import java.util.List;

public class CheckDuplicatedVisitor implements Visitor {

    MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();

    @Override
    public Pair visit(StudentList studentList, String studentId) {
        while (studentList.hasNext()) {
            Student currentStudent = studentList.next();
            if (currentStudent.getId().equals(studentId)) {
                Pair found = new Pair(true, studentList.getStudents().indexOf(currentStudent));
                studentList.reset();
                return found;
            }
        }
        System.out.println("Cannot find student with such student id!");
        Pair unfound = new Pair(false, null);
        return unfound;
    }

    @Override
    public Pair visit(CourseList courseList, String courseId) {
        while (courseList.hasNext()) {
            Course currentCourse = courseList.next();
            if (currentCourse.getId().equals(courseId)) {
                Pair found = new Pair(true, courseList.getCourses().indexOf(currentCourse));
                courseList.reset();
                return found;
            }
        }
        System.out.println("Cannot find course with such course id!");
        Pair unfound = new Pair(false, null);
        return unfound;
    }

    @Override
    public Pair visit(List<StudentEnrollment> studentEnrollmentList, StudentEnrollment toBeCompared) {

        for (StudentEnrollment enrollment : manager.getAllEnrollments()){
            if (toBeCompared.equals(enrollment)){
                Pair found = new Pair(true, manager.getAllEnrollments().indexOf(enrollment));
                return found;
            }
        }
        Pair unfound = new Pair(false, null);
        return unfound;

    }
}
