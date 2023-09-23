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

    public static boolean isFloat(String string) {
        try {
            Float.parseFloat(string);
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
        else if (!isFloat(strings[1]) || !isFloat(strings[2])) {
            errorMessage = "At least one of the given numbers cannot be processed. Please give another one and try again.";
        }
        else if (strings[0].toUpperCase().equals(Fields.Operation.DIV.toString()) && strings[2].equals("0")) {
            errorMessage = "Division by zero is not allowed.";
        }
        return errorMessage;
    }
}
