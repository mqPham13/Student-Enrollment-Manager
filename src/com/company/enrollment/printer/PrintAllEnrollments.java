package com.company.enrollment.printer;

import com.company.enrollment.MemoryStudentEnrollmentManager;
import com.company.enrollment.StudentEnrollment;

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
