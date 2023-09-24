package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

import main.ErrorHandling;
import main.Main;

public class e2e {
    String errorPrefix = "Error, reason: ";

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

        String expectedResult = errorPrefix + ErrorHandling.numbersOfParametersError + "2";
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void firstParameterNotNumberTest() {
        String actualResult = runMainFunctionAndGetResult("ADD f 1");

        String expectedResult = errorPrefix + ErrorHandling.wrongNumberError;
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void secondParameterNotNumberTest() {
        String actualResult = runMainFunctionAndGetResult("ADD 1 f");

        String expectedResult = errorPrefix + ErrorHandling.wrongNumberError;
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void incorrectOperatorTest() {
        String actualResult = runMainFunctionAndGetResult("NOT 1 2");

        String expectedResult = errorPrefix + "NOT" + ErrorHandling.wrongOperation;
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void divisionByZeroTest() {
        String actualResult = runMainFunctionAndGetResult("DIV 1 0");

        String expectedResult = errorPrefix + ErrorHandling.divisionByZeroError;
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