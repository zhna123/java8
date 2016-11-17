package com.nz.java;

/**
 * default method implementation in interface
 */
public class TestFormula {

    public static void main(String[] args) {

        // formula is implemented as an anonymous object
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));  // 100.0
        System.out.println(formula.sqrt(16));  // 4.0


        // Default methods CANNOT be accessed from within lambda expressions
        // So the line below is WRONG!
        // Formula formula1 = (a) -> sqrt(a * 100);
        // This is the correct way
        Formula formula1 = (a) -> Math.sqrt(a * 100);
        System.out.println(formula1.calculate(100));  // 100

        Formula formula2 = (a) -> Math.abs(a);
        System.out.println(formula2.callCalculate(-100));  // 99
    }
}


