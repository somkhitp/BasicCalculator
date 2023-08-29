package basicCalculator;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    @BeforeEach
    public void setUpScanner() {
        scanner = new Scanner(System.in);
    }


    @Test
    public void testAddition() {
        String input = "1\n2\n3\n"; // Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // Redirecting System.in to the input stream
        redirectSystemOut();

        Calculator.simpleCalculator();

        restoreSystemOut();

        assertTrue(getConsoleOutput().contains("Answer: 5.0")); // 2 + 3 = 5
    }


    @Test
    public void testSubtraction() {
        String input = "2\n5\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        redirectSystemOut();

        Calculator.simpleCalculator();

        restoreSystemOut();

        assertTrue(getConsoleOutput().contains("Answer: 2.0")); // 5 - 3 = 2
    }

    @Test
    public void testMultiply() {
        String input = "3\n2\n3\n"; // Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // Redirecting System.in to the input stream
        redirectSystemOut();

        Calculator.simpleCalculator();

        restoreSystemOut();

        assertTrue(getConsoleOutput().contains("Answer: 6.0")); // 2 * 3 = 6
    }

    @Test
    public void testDivide() {
        String input = "4\n12\n3\n"; // Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // Redirecting System.in to the input stream
        redirectSystemOut();

        Calculator.simpleCalculator();

        restoreSystemOut();

        assertTrue(getConsoleOutput().contains("Answer: 4.0")); // 12 / 3 = 4
    }

    // Edge Cases
    @Test
    public void testDivisionByZero() {
        String input = "4\n5\n0\n"; // Simulating user input: division by zero
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        redirectSystemOut();

        Calculator.simpleCalculator();

        restoreSystemOut();

        assertTrue(getConsoleOutput().contains("Cannot divide by Zero")); // 5 / 0 = Cannot divide by Zero
    }

    @Test
    public void testInvalidOperator() {
        String input = "A\n1\n2\n3\n"; // Simulating user input: invalid operator
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
//        scanner = new Scanner(System.in);
        redirectSystemOut();

        Calculator.simpleCalculator();

        restoreSystemOut();

        assertTrue(getConsoleOutput().contains("Invalid selection! Please select a number between 1 - 4"));
    }

    @Test
    public void testNonNumericInput() {
        String input = "1\nabc\n2\n3\n"; // Simulating user input: non-numeric input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        redirectSystemOut();

        Calculator.simpleCalculator();

        restoreSystemOut();

        assertTrue(getConsoleOutput().contains("Must Be A Number!"));
    }

    // Helper method to capture console output
    private String getConsoleOutput() {
        return outContent.toString().trim();
    }

//    private double extractResultFromConsoleOutput(String consoleOutput) {
//        String prefix = "Answer: ";
//        int startIndex = consoleOutput.indexOf(prefix) + prefix.length();
//        int endIndex = consoleOutput.indexOf('\n', startIndex);
//        String resultString = consoleOutput.substring(startIndex, endIndex).trim();
//
//        return Double.parseDouble(resultString);
//    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalSystemOut);
        System.setIn(originalSystemIn);
        scanner.close();
    }

    private void redirectSystemOut() {
        System.setOut(new PrintStream(outContent));
    }

    private void restoreSystemOut() {
        System.setOut(originalOut);
    }


    //Variables
    private Scanner scanner;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalSystemOut = System.out;
    private final InputStream originalSystemIn = System.in;
}
