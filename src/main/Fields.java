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

    public Fields(String line) {
        String[] strings = line.split(" ");

        String error = ErrorHandling.getErrorMessage(strings);
        if (error != null) {
            this.setError(error);
            return;
        }

        this.setOp(Fields.Operation.valueOf(strings[0].toUpperCase()));
        this.setA(Integer.parseInt(strings[1]));
        this.setB(Integer.parseInt(strings[2]));
    }
}
