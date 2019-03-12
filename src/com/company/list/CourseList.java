package com.company.list;

import com.company.course.Course;
import com.company.duplicatedchecker.Pair;
import com.company.duplicatedchecker.Visitable;
import com.company.duplicatedchecker.Visitor;

import java.util.ArrayList;
import java.util.List;

public class CourseList implements MyIterator, Visitable {

    List<Course> courses = new ArrayList<>();
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
        if (currentItem >= courses.size()) {
            reset();
            return false;
        }
        return true;
    }

    @Override
    public Course next() {
        return courses.get(currentItem++);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Pair invite(Visitor visitor) {
        return visitor.visit(this, toBeCompared);
    }

    public void showAllCourses() {
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }
}
