package main;
public class BasicMathOperations {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static float div(float a, float b) {
        if (b == 0) {
            return Float.NaN;
        }
        return a / b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }
}
