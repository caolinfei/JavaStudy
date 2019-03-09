package com.study.exceptionDemo;

import java.io.PrintStream;

public class MyRuntimeException extends RuntimeException {

    public MyRuntimeException() {
        super("message");
    }
}
