package com.company.enrollment.printer;

import com.company.enrollment.MemoryStudentEnrollmentManager;
import com.company.enrollment.StudentEnrollment;
import com.company.misc.Utils;

public class PrintStudentEnrollment implements Chain {
    private Chain nextInChain;
    MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();
    private Utils utils = new Utils();

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void print(PrintRequest request) {
        if (request.getPrintType().equals("print student")) {
            int count = 0;
            System.out.println("Input student id: ");
            String id = utils.getInput();
            for (StudentEnrollment se : manager.getAllEnrollments()) {
                if (se.getStudentId().equals(id)) {
                    System.out.println(se.toString());
                    count +=1;
                }
            }
            System.out.println("Found (" + count + ") enrollments with student id " + id);
        } else {
            nextInChain.print(request);
        }

    }
}

