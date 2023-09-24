package main;

import java.util.ArrayList;

public class Fields {
    public enum Operation {
        ADD,
        SUB,
        DIV,
        MUL,
        SUM
    }

    public float a;

    public float b;

    public ArrayList<Float> numbers;

    public Operation op;

    public String error;

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public ArrayList<Float> getNumbers() {
        return numbers;
    }

    public void setNumbers(String[] strings) {
        ArrayList<Float> givenNumbers = new ArrayList<Float>();
        for (int i = 1; i < strings.length; i++) {
            givenNumbers.add(Float.parseFloat(strings[i]));
        }
        this.numbers = givenNumbers;
    }

    public Operation getOp() {
        return op;
    }

    public void setOp(Operation op) {
        this.op = op;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Fields(String line) {
        String[] strings = line.split(" ");

        String error = ErrorHandling.getErrorMessage(strings);
        if (error != null) {
            this.setError(error);
            return;
        }

        this.setOp(Fields.Operation.valueOf(strings[0].toUpperCase()));
        if (this.getOp().equals(Operation.SUM)) {
            this.setNumbers(strings);
        } else {
            this.setA(Float.parseFloat(strings[1]));
            this.setB(Float.parseFloat(strings[2]));
        }
    }
}
