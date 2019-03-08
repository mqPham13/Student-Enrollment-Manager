package com.company.Enrollment.Printer;

import com.company.Enrollment.MemoryStudentEnrollmentManager;
import com.company.Enrollment.StudentEnrollment;

public class PrintAllEnrollments implements Chain {

    private Chain nextInChain;
    MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void print(PrintRequest request) {
        if (request.getPrintType().equals("print all")) {
            System.out.println("All available enrollments:");
            for(StudentEnrollment se : manager.getAllEnrollments()) {
                System.out.println(se.toString());
            }
        } else {
            nextInChain.print(request);
        }
    }
}
