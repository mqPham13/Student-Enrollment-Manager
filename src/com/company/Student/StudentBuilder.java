package com.company.Student;

public class StudentBuilder {

    Student student = new Student();

    public StudentBuilder addId(String id){
        student.setId(id);
        return this;
    }

    public StudentBuilder addName(String name){
        student.setName(name);
        return this;
    }

    public StudentBuilder addBirthdate(String dob){
        student.setBirthdate(dob);
        return this;
    }

    public Student buildStudent(){
        return student;
    }
}
