package com.company;

public class PrintCourseEnrollment implements Chain{
    private Chain nextInChain;
    MemoryStudentEnrollmentManager manager = MemoryStudentEnrollmentManager.getInstance();
    private Utils utils = new Utils();

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void print(PrintRequest request) {
        if (request.getPrintType().equals("print course")) {
            int count = 0;
            System.out.println("Input course: ");
            String id = utils.getInput();
            for (StudentEnrollment se : manager.getAllEnrollments()) {
                if (se.getCourseId().equals(id)) {
                    System.out.println(se.toString());
                    count +=1;
                }
            }
            System.out.println("Found (" + count + ") enrollments with course id " + id);
        } else {
            System.out.println("End of chain");
        }

    }
}
