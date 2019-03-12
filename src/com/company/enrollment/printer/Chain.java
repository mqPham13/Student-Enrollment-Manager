package com.company.enrollment.printer;

public interface Chain {
    public void setNextChain(Chain nextChain);
    public void print(PrintRequest request);
}
