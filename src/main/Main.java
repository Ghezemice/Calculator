package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Give the operation and the numbers separated by space please.\n Possible operations: ADD, SUB, DIV, MUL.\n Example: ADD 1 2\n");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        Fields field = new Fields(line);

        if (field.getError() != null) {
            System.out.println("Error, reason: " + field.getError());
        } else {
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
                case SUM:
                    rc = BasicMathOperations.sum(field.getNumbers());
                    break;
                default:
                    break;
            }

            System.out.println("Result: " + rc);
        }
    }
}