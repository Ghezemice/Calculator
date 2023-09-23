package main;
public class BasicMathOperations {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static float div(float a, float b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return Float.NaN;
        }
    }

    public static int mul(int a, int b) {
        return a * b;
    }
}
