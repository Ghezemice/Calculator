import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Give the operation and the numbers separated by space please.\n Possible operations: ADD, SUB, DIV, MUL.\n Example: ADD 1 2");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        Fields field = parseLine(line);

        if (field.getError() != null) {
            System.out.println("Error, reason: " + field.getError());
        }

        float rc = 0;
        switch (field.getOp()) {
            case ADD:
                rc = BasicMathOperations.add(field.getA(), field.getB());
                break;
            case SUB:
                rc = BasicMathOperations.sub(field.getA(), field.getB());
                break;
            case DIV:
                rc = BasicMathOperations.div(field.getA(), field.getB());
                break;
            case MUL:
                rc = BasicMathOperations.mul(field.getA(), field.getB());
                break;
            default:
                break;
        }

        System.out.println("Result: " + rc);
    }

    public static Fields parseLine(String line) {
        Fields fields = new Fields();
        String[] strings = line.split(" ");

        if (strings.length < 3) {
            fields.setError("Not enough parameter, expected 3, received: " + strings.length);
            return fields;
        }

        if (strings[0].toUpperCase().equals(Fields.Operation.DIV.toString()) && strings[2].equals("0")) {
            fields.setError("Division by zero is not allowed.");
            return fields;
        }

        fields.setOp(Fields.Operation.valueOf(strings[0].toUpperCase()));
        fields.setA(Integer.parseInt(strings[1]));
        fields.setB(Integer.parseInt(strings[2]));
        return fields;
    }
}