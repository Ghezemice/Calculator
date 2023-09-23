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