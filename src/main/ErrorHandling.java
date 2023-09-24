package main;
public class ErrorHandling {

    public static String 
        notEnoughParametersError = "Not enough parameters, expected 3, received: ",
        tooManyParametersError = "Too many parameters, expected 3, received: ",
        wrongOperation = " is not an acceptable operation. Please use ADD, SUB, DIV or MUL instead.",
        wrongNumberError = "At least one of the given numbers cannot be processed. Please give another one and try again.",
        divisionByZeroError = "Division by zero is not allowed.";


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
            errorMessage =  notEnoughParametersError + strings.length;
        }
        else if (3 < strings.length && !strings[0].equals(Fields.Operation.SUM.toString())) {
            errorMessage =  tooManyParametersError + strings.length;
        }
        else if (!checkOperationValidity(strings[0].toUpperCase())) {
            errorMessage = strings[0] + wrongOperation;
        }
        else if (!isFloat(strings[1]) || !isFloat(strings[2])) {
            errorMessage = wrongNumberError;
        }
        else if (strings[0].toUpperCase().equals(Fields.Operation.DIV.toString()) && strings[2].equals("0")) {
            errorMessage = divisionByZeroError;
        }
        return errorMessage;
    }
}
