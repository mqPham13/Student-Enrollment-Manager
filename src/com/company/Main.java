package com.company;
import com.company.Course.Course;
import com.company.Course.CourseFactory;
import com.company.Enrollment.*;
import com.company.Lists.CourseList;
import com.company.Enrollment.Printer.*;
import com.company.DuplicatedChecker.CheckDuplicatedVisitor;
import com.company.DuplicatedChecker.Pair;
import com.company.Misc.Utils;
import com.company.Student.Student;
import com.company.Student.StudentBuilder;
import com.company.Lists.StudentList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Utils utilities = new Utils();

        //sample students which are held in a student list, created using Builder Pattern
        StudentBuilder stdBuilder1 = new StudentBuilder();
        StudentBuilder stdBuilder2 = new StudentBuilder();
        StudentBuilder stdBuilder3 = new StudentBuilder();
        StudentBuilder stdBuilder4 = new StudentBuilder();

        Student stu1 = stdBuilder1.addId("1111111").addName("Tyrion Lannister").addBirthdate("20/10/1997").buildStudent();
        Student stu2 = stdBuilder2.addId("2222222").addName("John Snow").addBirthdate("30/11/1999").buildStudent();
        Student stu3 = stdBuilder3.addId("3333333").addName("Danni Tagaryen").addBirthdate("24/12/1992").buildStudent();
        Student stu4 = stdBuilder4.addId("4444444").addName("Arya Stark").addBirthdate("10/05/1993").buildStudent();

        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(stu1,stu2,stu3,stu4));

        StudentList studentList = new StudentList();
        studentList.setStudents(students);


        //sample courses which are held in a course list, created using Factory Pattern
        Course course1 = CourseFactory.createCourse("COSC1111", "SADI", 12);
        Course course2 = CourseFactory.createCourse("COSC2222", "UCD", 12);
        Course course3 = CourseFactory.createCourse("COSC3333", "BITS", 12);
        Course course4 = CourseFactory.createCourse("COSC4444", "P1", 12);

        List<Course> courses = new ArrayList<>();
        courses.addAll(Arrays.asList(course1,course2,course3,course4));

        CourseList courseList = new CourseList();
        courseList.setCourses(courses);

        //Chain Of Responsibility Pattern
        Chain link1 = new PrintAllEnrollments();
        Chain link2 = new PrintSemesterEnrollments();
        Chain link3 = new PrintStudentEnrollment();
        Chain link4 = new PrintCourseEnrollment();

        link1.setNextChain(link2);
        link2.setNextChain(link3);
        link3.setNextChain(link4);

        //Visitor Pattern
        CheckDuplicatedVisitor checkDuplicate = new CheckDuplicatedVisitor();

        //Singleton Pattern
        MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();

        //menu loop
        boolean quit = false;
        while(!quit) {
            System.out.println("\nWelcome to the Enrollment System!\n" +
                               "1) Create an enrollment\n" +
                               "2) Update an enrollment\n" +
                               "3) Delete an enrollment\n" +
                               "4) Print all enrollments\n" +
                               "5) Print enrollments for a student\n" +
                               "6) Print enrollments for a semester\n" +
                               "7) Print enrollments for a course \n" +
                               "------------------------------------\n" +
                               "8) Show all students\n" +
                               "9) Show all courses\n" +
                               "0) Quit");

            Scanner scanner1 = new Scanner(System.in);
            String option = "";

            if (scanner1.hasNext()) {
                option = scanner1.next();
            }

            switch (option) {
                case "1":
                    System.out.println("Create new enrollment:\n");
                    //create enrollment
                    StudentEnrollment newEnrollment = utilities.formNewEnrollment(studentList ,courseList);
                    if (newEnrollment == null) break;

                    //check for duplicated enrollment
                    manager.setToBeCompared(newEnrollment);
                    boolean duplicatedEnrollment = ((Boolean)manager.invite(checkDuplicate).duplicated);

                    if (duplicatedEnrollment) {
                        System.out.println("\nEnrollment has already existed!");
                        break;
                    }

                    //Command Pattern
                    CreateNewEnrollmentCommand adder = new CreateNewEnrollmentCommand(newEnrollment);
                    adder.execute();
                    //provide the option of undo
                    String undo = utilities.getUndo();
                    if (undo.equals("y")) adder.undo();
                    break;

                case "2":
                    //check if any enrollment exists
                    boolean enrollmentExists = utilities.checkEmptyEnrollmentList();
                    if (!enrollmentExists) break;

                    System.out.println("Update an enrollment:\n");
                    StudentEnrollment toBeUpdated = utilities.formNewEnrollment(studentList, courseList);
                    if (toBeUpdated == null) break;

                    //check if needed enrollment exists
                    manager.setToBeCompared(toBeUpdated);
                    Pair<Boolean,Integer> resultPair  = manager.invite(checkDuplicate);
                    boolean duplicatedEn = resultPair.duplicated;
                    Integer indexOfDup = resultPair.index;

                    if ((!duplicatedEn) && (indexOfDup == null)) {
                        System.out.println("\nNo such enrollment was found!\n");
                        break;
                    }

                    System.out.println("Enrollment found. Enter info to update: ");
                    //Command Pattern
                    StudentEnrollment update = utilities.formNewEnrollment(studentList,courseList);
                    UpdateEnrollmentCommand updater = new UpdateEnrollmentCommand(update, indexOfDup);
                    updater.execute();
                    String undo1 = utilities.getUndo();
                    if (undo1.equals("y")) updater.undo();

                    break;


                case "3":
                    //check if any enrollment exists
                    boolean enrollmentExists1 = utilities.checkEmptyEnrollmentList();
                    if (!enrollmentExists1) break;

                    System.out.println("Delete an enrollment:\n");
                    StudentEnrollment toBeDeleted = utilities.formNewEnrollment(studentList,courseList);
                    if (toBeDeleted == null) break;

                    manager.setToBeCompared(toBeDeleted);
                    boolean duplicated = ((Boolean)manager.invite(checkDuplicate).duplicated);;
                    if (!duplicated) {
                        System.out.println("\nNo such enrollment was found! Nothing was deleted.\n");
                        break;
                    }

                    //more Command Pattern
                    DeleteEnrollmentCommand remover = new DeleteEnrollmentCommand(toBeDeleted);
                    remover.execute();
                    String undo2 = utilities.getUndo();
                    if (undo2.equals("y")) remover.undo();

                    break;

                case "4":
                    //check if any enrollment exists
                    boolean enrollmentExists2 = utilities.checkEmptyEnrollmentList();
                    if (!enrollmentExists2) break;

                    PrintRequest req1 = new PrintRequest("print all");
                    link1.print(req1);
                    break;

                case "5":
                    //check if any enrollment exists
                    boolean enrollmentExists3 = utilities.checkEmptyEnrollmentList();
                    if (!enrollmentExists3) break;

                    PrintRequest req2 = new PrintRequest("print student");
                    link1.print(req2);
                    break;

                case "6":
                    //check if any enrollment exists
                    boolean enrollmentExists4 = utilities.checkEmptyEnrollmentList();
                    if (!enrollmentExists4) break;

                    PrintRequest req3 = new PrintRequest("print semester");
                    link1.print(req3);
                    break;

                case "7":
                    //check if any enrollment exists
                    boolean enrollmentExists5 = utilities.checkEmptyEnrollmentList();
                    if (!enrollmentExists5) break;

                    PrintRequest req4 = new PrintRequest("print course");
                    link1.print(req4);
                    break;

                case "8":
                    studentList.showAllStudents();
                    break;

                case "9":
                    courseList.showAllCourses();
                    break;

                case "0":
                    System.out.println("Goodbye!");
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }
}
