package com.company.Enrollment.Printer;

public class PrintRequest {

    private String printType;

    public PrintRequest(String printType) {
        this.printType = printType;
    }

    public String getPrintType() {
        return printType;
    }
}
