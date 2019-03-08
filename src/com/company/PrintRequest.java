package com.company;

public class PrintRequest {

    private String printType;

    PrintRequest(String printType) {
        this.printType = printType;
    }

    public String getPrintType() {
        return printType;
    }
}
