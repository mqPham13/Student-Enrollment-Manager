package com.company;

public class UpdateEnrollmentCommand implements Command {

    StudentEnrollment update;
    MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();
    Student beforeStudent;
    Course beforeCourse;
    String beforeSemester;
    int indexOfToBeUpdated;

    public UpdateEnrollmentCommand(StudentEnrollment enrollment, int index) {
        this.update = enrollment;
        this.indexOfToBeUpdated = index;
        this.beforeStudent = manager.getAllEnrollments().get(indexOfToBeUpdated).getStudent();
        this.beforeCourse = manager.getAllEnrollments().get(indexOfToBeUpdated).getCourse();
        this.beforeSemester = manager.getAllEnrollments().get(indexOfToBeUpdated).getSemester();
    }

    @Override
    public void execute() {
        StudentEnrollment toBeUpdated = manager.getAllEnrollments().get(indexOfToBeUpdated);
        manager.updateStudentEnrollment(toBeUpdated, update);
    }

    @Override
    public void undo() {
        StudentEnrollment toBeReverted = manager.getAllEnrollments().get(indexOfToBeUpdated);
        //Revert info to old info
        toBeReverted.setStudent(this.beforeStudent);
        toBeReverted.setCourse(this.beforeCourse);
        toBeReverted.setSemester(this.beforeSemester);
        System.out.println("Undo completed!");
    }
}
