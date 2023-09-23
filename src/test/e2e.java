package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

import main.Main;

public class e2e {
    @Test
    public void testAddPositive() {
        String actualResult = runMainFunctionAndGetResult("ADD 1 2");

        String expectedResult = "Result: 3.0";
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testSubPositive() {
        String actualResult = runMainFunctionAndGetResult("SUB 1 2");

        String expectedResult = "Result: -1.0";
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testDivPositive() {
        String actualResult = runMainFunctionAndGetResult("DIV 1 2");

        String expectedResult = "Result: 0.5";
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testMulPositive() {
        String actualResult = runMainFunctionAndGetResult("MUL 1 2");

        String expectedResult = "Result: 2.0";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void parameterErrorTest() {
        String actualResult = runMainFunctionAndGetResult("ADD 1");

        String expectedResult = "Error, reason: Not enough parameter, expected 3, received: 2";
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void firstParameterNotNumberTest() {
        String actualResult = runMainFunctionAndGetResult("ADD f 1");

        String expectedResult = "Error, reason: At least one of the given numbers cannot be processed. Please give another one and try again.";
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void secondParameterNotNumberTest() {
        String actualResult = runMainFunctionAndGetResult("ADD 1 f");

        String expectedResult = "Error, reason: At least one of the given numbers cannot be processed. Please give another one and try again.";
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void incorrectOperatorTest() {
        String actualResult = runMainFunctionAndGetResult("NOT 1 2");

        String expectedResult = "Error, reason: NOT is not an acceptable operation. Please use ADD, SUB, DIV or MUL instead.";
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void divisionByZeroTest() {
        String actualResult = runMainFunctionAndGetResult("DIV 1 0");

        String expectedResult = "Error, reason: Division by zero is not allowed.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    public static String runMainFunctionAndGetResult(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Main.main(null);

        String programOutput = outputStream.toString();
        System.out.println(programOutput);
        String actualResult = programOutput.replaceAll("(.*\\n)|(\\r)", "");

        System.setIn(System.in);
        System.setOut(System.out);

        return actualResult;
    }
}