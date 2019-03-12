package com.company.enrollment.printer;

import com.company.enrollment.MemoryStudentEnrollmentManager;
import com.company.enrollment.StudentEnrollment;
import com.company.misc.Utils;

public class PrintSemesterEnrollments implements Chain {

    private Chain nextInChain;
    MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();
    private Utils utils = new Utils();

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void print(PrintRequest request) {
        if (request.getPrintType().equals("print semester")) {
            int count = 0;
            System.out.println("Input semester: ");
            String semester = utils.getInput();
            for(StudentEnrollment se : manager.getAllEnrollments()) {
                if (se.getSemester().equals(semester)) {
                    System.out.println(se.toString());
                    count+=1;
                }
            }
            System.out.println("Found (" + count + ") enrollments with the provided semester");
        } else {
            nextInChain.print(request);
        }
    }
}
