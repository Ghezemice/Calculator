package main;
public class ErrorHandling {

    public static Boolean checkOperationValidity(String examinedText) {
        for (Fields.Operation op : Fields.Operation.values()) {
            if (op.toString().equals(examinedText)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    public static String getErrorMessage(String[] strings) {
        String errorMessage = null;
        if (strings.length < 3) {
            errorMessage = "Not enough parameter, expected 3, received: " + strings.length;
        }
        else if (!checkOperationValidity(strings[0].toUpperCase())) {
            errorMessage = strings[0] + " is not an acceptable operation. Please use ADD, SUB, DIV or MUL instead.";
        }
        else if (!isInteger(strings[1]) || !isInteger(strings[2])) {
            errorMessage = "At least one of the given numbers is cannot be processed. Please give only numbers!";
        }
        else if (strings[0].toUpperCase().equals(Fields.Operation.DIV.toString()) && strings[2].equals("0")) {
            errorMessage = "Division by zero is not allowed.";
        }
        return errorMessage;
    }
}
