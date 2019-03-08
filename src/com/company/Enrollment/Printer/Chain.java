package com.company.Enrollment.Printer;

public interface Chain {
    public void setNextChain(Chain nextChain);
    public void print(PrintRequest request);
}
