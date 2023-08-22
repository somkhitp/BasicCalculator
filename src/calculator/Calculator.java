package calculator;

import java.util.*;
import java.io.*;

public class Calculator {
    public static void simpleCalculator() {
        Scanner scanner = new Scanner(System.in); //Calling Scanner

        //Variables
        double results = 0, num1, num2;
        int operator = 0;

// Selecting Which Operator To Use
        while (true) {
            System.out.println("Calculator Menu:");
            System.out.println("1: Addition");
            System.out.println("2: Subtraction");
            System.out.println("3: Multiplication");
            System.out.println("4: Division");
            System.out.println("Please select a Math Operator (1 | 2 | 3 | 4 |");

            try {
                operator = scanner.nextInt();
                if (operator >= 1 && operator <= 4) {
                    break;
                } else {
                    System.out.println("Must be between 1 - 4");
                    scanner.nextLine();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid selection!");
                scanner.nextLine();
            }
        }


        // Entering First Number
        while (true) {
            try {
                System.out.println("Enter a number: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Must Be A Number!");
                    scanner.next();
                    System.out.println("Enter a number: ");
                }
                num1 = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Must Be a Number!!");
                scanner.nextLine();
                return;
            }
        }


        // Entering Second Number
        while (true) {
            try {
                System.out.println("Enter second number: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Must Be A Number!");
                    scanner.next();
                    System.out.println("Enter a second number: ");
                }
                num2 = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Must Be a Number!!");
                scanner.nextLine();
                return;
            }
        }

        // Switch Statements
        switch (operator) {
            case 1:
                results = num1 + num2;
                break;
            case 2:
                if (num1 < num2) {
                    results = num2 - num1;
                }
                else {
                    results = num1 - num2;
                }
                break;
            case 3:
                results = num1 * num2;
                break;
            case 4:
                if (num1 > num2) {
                    results = num1 / num2;
                } else if (num1 < num2) {
                    results = num2 / num1;
                } else if (num2 != 0) {
                    results = num1 / num2;
                } else {
                    System.out.println("Cannot divide by Zero");
                }
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