package main;
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
        this.setA(Float.parseFloat(strings[1]));
        this.setB(Float.parseFloat(strings[2]));
    }
}
