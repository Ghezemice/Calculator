package main;
public class Fields {
    public enum Operation {
        ADD,
        SUB,
        DIV,
        MUL
    }

    public int a;

    public int b;

    public Operation op;

    public String error;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
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
}
