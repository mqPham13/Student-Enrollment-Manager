package com.company;
import java.util.ArrayList;
import java.util.List;

public class MemoryStudentEnrollmentManager implements StudentEnrollmentManager, Visitable {

    //Composite Pattern
    private List<StudentEnrollment> studentEnrollmentList = new ArrayList<>();
    private StudentEnrollment toBeCompared;


    //Singleton pattern used to ensure creation of only 1 MemoryStudentEnrollmentManager instance
    private static MemoryStudentEnrollmentManager instance = new MemoryStudentEnrollmentManager();

    private MemoryStudentEnrollmentManager(){
    }

    public static MemoryStudentEnrollmentManager getInstance() {
        return instance;
    }

    public void setToBeCompared(StudentEnrollment toBeCompared) {
        this.toBeCompared = toBeCompared;
    }

    @Override
    public void createStudentEnrollment(StudentEnrollment newEnrollment) {
        studentEnrollmentList.add(newEnrollment);
        System.out.println("\nEnrollment created!\n" + newEnrollment.toString());
    }

    @Override
    public void updateStudentEnrollment(StudentEnrollment toBeUpdated, StudentEnrollment update) {
        toBeUpdated.setStudent(update.getStudent());
        toBeUpdated.setCourse(update.getCourse());
        toBeUpdated.setSemester(update.getSemester());
        System.out.println("Updated 1 enrollment:\n" + toBeUpdated.toString());
    }

    @Override
    public void deleteStudentEnrollment(StudentEnrollment enrollment) {
        studentEnrollmentList.remove(enrollment);
        System.out.println("\nDeleted 1 enrollment\n");
    }


    @Override
    public List<StudentEnrollment> getAllEnrollments() {
        return this.studentEnrollmentList;
    }

    @Override
    public Pair invite(Visitor visitor) {
        return visitor.visit(this.studentEnrollmentList, toBeCompared);
    }
}
