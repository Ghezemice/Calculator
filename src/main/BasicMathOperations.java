package main;
public class BasicMathOperations {
    public static float add(float a, float b) {
        return a + b;
    }

    public static float sub(float a, float b) {
        return a - b;
    }

    public static float div(float a, float b) {
        if (b == 0) {
            return Float.NaN;
        }
        return a / b;
    }

    public static float mul(float a, float b) {
        return a * b;
    }

    public static float sum(float[] numbers) {
        float result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }
}
