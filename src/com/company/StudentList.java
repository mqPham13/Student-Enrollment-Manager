package com.company;
import java.util.ArrayList;
import java.util.List;

public class StudentList implements MyIterator, Visitable {

    List<Student> students = new ArrayList<>();
    int currentItem = 0;
    String toBeCompared;

    public void setToBeCompared(String toBeCompared) {
        this.toBeCompared = toBeCompared;
    }

    @Override
    public void reset() {
        currentItem = 0;
    }

    @Override
    public boolean hasNext() {
        if (currentItem >= students.size()) {
            reset();
            return false;
        }
        return true;
    }

    @Override
    public Student next() {
        return students.get(currentItem++);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public Pair invite(Visitor visitor) {
        return visitor.visit(this, toBeCompared);
    }

    public void showAllStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}