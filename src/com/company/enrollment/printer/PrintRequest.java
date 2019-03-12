package com.company.enrollment.printer;

public class PrintRequest {

    private String printType;

    public PrintRequest(String printType) {
        this.printType = printType;
    }

    public String getPrintType() {
        return printType;
    }
}
