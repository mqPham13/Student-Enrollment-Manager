package com.company;
import java.util.Objects;

public class StudentEnrollment {

    private Student student;
    private Course course;
    private String semester;


    //Dependency injection with constructor
    public StudentEnrollment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    //Facade Pattern
    public String getStudentId(){
        return student.getId();
    }

    public String getCourseId(){
        return  course.getId();
    }

    //Dependency injection with setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    //Method to check for duplicated enrollments
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEnrollment that = (StudentEnrollment) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course) &&
                Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course, semester);
    }

    @Override
    public String toString() {
        return "Student: " + student.getId() + " " + student.getName() +
                " | Course: " + course.getId() + " " + course.getName() +
                " | Semester: " + semester;
    }
}
