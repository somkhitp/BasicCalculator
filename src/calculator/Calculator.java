package calculator;

import java.util.*;

public class Calculator {

    // Global Variables

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return Math.abs(a - b);
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by Zero");
            return Double.NaN;
        }
        if (a < b) {
            double temp = a;
            a = b;
            b = temp;
        }
        return a / b;
    }

    public static void simpleCalculator() {
        Scanner scanner = new Scanner(System.in); //Calling Scanner

//        //Variables
        double results = 0, num1 = 0, num2 = 0;
        int operator;

// Selecting Which Operator To Use
        System.out.println("Calculator Menu:");
        System.out.println("1: Addition");
        System.out.println("2: Subtraction");
        System.out.println("3: Multiplication");
        System.out.println("4: Division");
        System.out.println("Please select a Math Operator (1 | 2 | 3 | 4)");

        while (true) {
            try {
                operator = scanner.nextInt();

                if (operator >= 1 && operator <= 4) {
                    break;
                } else {
                    System.out.println("Must be between 1 - 4");
                    scanner.nextLine();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid selection! Please select a number between 1 - 4");
                scanner.nextLine();
            }
        }


        // Entering First Number
        while (true) {
            boolean validInput = false;
            try {
                System.out.println("Enter a number: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Must Be A Number!");
                    scanner.next();
                    System.out.println("Enter a number: ");
                }
                num1 = scanner.nextDouble();
                scanner.nextLine();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Must Be a Number!!");
                scanner.nextLine();
            }
            if (validInput) {
                break; //Break the loop only if valid input was obtained
            }
        }


        // Entering Second Number
        while (true) {
            boolean validInput = false;
            try {
                System.out.println("Enter second number: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Must Be A Number!");
                    scanner.next();
                    System.out.println("Enter a second number: ");
                }
                num2 = scanner.nextDouble();
                scanner.nextLine();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Must Be a Number!!");
                scanner.nextLine();
            }
            if (validInput) {
                break; // Break the loop only if valid input has been obtained
            }
        }

        // Switch Statements
        switch (operator) {
            case 1:
                results = add(num1, num2);
                break;
            case 2:
                results = subtract(num1, num2);
                break;
            case 3:
                results = multiply(num1, num2);
                break;
            case 4:
                results = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid Selection!");
        }

        // Printing Out Final Answer
        System.out.println("Answer: " + results);

        // Closing Scanner
        scanner.close();


    }

    public static void main(String args[]) {
        simpleCalculator();
    }
}
