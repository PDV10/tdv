package org.example;

import org.junit.runner.JUnitCore;


public class TestRunner {

    public static void main(String args[]) {
        System.out.println("Test runner -> comienzo del Runner");
        JUnitCore.runClasses(TestSuite.class);
        System.out.println("Test runner -> Fin del Runner");
    }

}