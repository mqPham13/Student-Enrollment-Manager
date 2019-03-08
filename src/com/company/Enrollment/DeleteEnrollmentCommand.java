package com.company.Enrollment;

public class DeleteEnrollmentCommand implements Command {

    StudentEnrollment toBeDeleted;
    MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();

    public DeleteEnrollmentCommand(StudentEnrollment enrollment) {
        this.toBeDeleted = enrollment;
    }

    @Override
    public void execute() {
        manager.deleteStudentEnrollment(toBeDeleted);
    }

    @Override
    public void undo() {
        manager.createStudentEnrollment(toBeDeleted);
        System.out.println("Undo completed!");
    }
}
