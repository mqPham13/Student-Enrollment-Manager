package com.company;

public class CreateNewEnrollmentCommand implements Command {

    StudentEnrollment enrollment;

    MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();

    public CreateNewEnrollmentCommand(StudentEnrollment enrollment) {
        this.enrollment = enrollment;
    }

    @Override
    public void execute() {
        manager.createStudentEnrollment(enrollment);
    }

    @Override
    public void undo() {
        manager.getAllEnrollments().remove(enrollment);
        System.out.println("Undo completed!");
    }
}
