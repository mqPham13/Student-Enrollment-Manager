package com.company.Misc;
import com.company.Course.Course;
import com.company.Lists.CourseList;
import com.company.Enrollment.MemoryStudentEnrollmentManager;
import com.company.Enrollment.StudentEnrollment;
import com.company.DuplicatedChecker.CheckDuplicatedVisitor;
import com.company.DuplicatedChecker.Pair;
import com.company.Student.Student;
import com.company.Lists.StudentList;

import java.util.Scanner;

public class Utils {

    MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();
    CheckDuplicatedVisitor checkDuplicate = new CheckDuplicatedVisitor();

    public boolean checkEmptyEnrollmentList(){
        if (manager.getAllEnrollments().size() == 0) {
            System.out.println("\nEnrollment list is empty!\n");
            return false;
        }
        return true;
    }

    public String getInput(){
        Scanner scanner1 = new Scanner(System.in);
        if (scanner1.hasNext()) {
            return scanner1.next();
        }   else return null;
    }


    public StudentEnrollment formNewEnrollment(StudentList studentList, CourseList courseList) {
        //get student from student id
        System.out.print("Input student id: ");
        String stuId = getInput();
        studentList.setToBeCompared(stuId);
        Pair resultStu = studentList.invite(checkDuplicate);
        if (!((Boolean)resultStu.duplicated)) return null;

        int indexStu = (Integer)resultStu.index;
        Student studentToEnroll = studentList.getStudents().get(indexStu);


        //get course from course name
        System.out.print("Input course id: ");
        String courseId = getInput();
        courseList.setToBeCompared(courseId);
        Pair resultCourse = courseList.invite(checkDuplicate);
        if (!((Boolean)resultCourse.duplicated)) return null;

        int indexCourse = (Integer)resultCourse.index;
        Course courseToEnroll = courseList.getCourses().get(indexCourse);

        //get semester
        System.out.print("Input semester: ");
        String semester = getInput();

        //create enrollment with Dependency Injection
        StudentEnrollment newEnrollment = new StudentEnrollment(studentToEnroll, courseToEnroll, semester);

        return  newEnrollment;
    }


    public String getUndo() {
        String undo = "";
        while (!(undo.toLowerCase().equals("y") || undo.toLowerCase().equals("n"))) {
            System.out.println("Do you want to undo? (y/n)");
            undo = getInput();
        }
        return undo.toLowerCase();
    }
}

