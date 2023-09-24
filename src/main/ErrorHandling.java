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
        if (isTooLessParameters(strings)) {
            errorMessage =  notEnoughParametersError + strings.length;
        }
        else if (isTooManyParameters(strings)) {
            errorMessage =  tooManyParametersError + strings.length;
        }
        else if (isOperationInvalid(strings)) {
            errorMessage = strings[0] + wrongOperation;
        }
        else if (isParametersNumbers(strings)) {
            errorMessage = wrongNumberError;
        }
        else if (isDivisionByZero(strings)) {
            errorMessage = divisionByZeroError;
        }
        return errorMessage;
    }

    private static boolean isTooLessParameters(String[] strings) {
        if (strings.length < 3) {
            return true;
        }
        return false;
    }

    private static boolean isTooManyParameters(String[] strings) {
        if (3 < strings.length && !(strings[0].toUpperCase()).equals(Fields.Operation.SUM.toString())) {
            return true;
        }
        return false;
    }

    private static boolean isOperationInvalid(String[] strings) {
        if (!checkOperationValidity(strings[0].toUpperCase())) {
            return true;
        }
        return false;
    }

    private static boolean isParametersNumbers(String[] strings) {
        boolean allTheNumbersAreFloat = true;
        for (int i = 1; i < strings.length; i++) {
            if (!isFloat(strings[i])) {
                allTheNumbersAreFloat = false;
            }
        }
        if (!allTheNumbersAreFloat) {
            return true;
        }
        return false;
    }

    private static boolean isDivisionByZero(String[] strings) {
        if (strings[0].toUpperCase().equals(Fields.Operation.DIV.toString()) && strings[2].equals("0")) {
            return true;
        }
        return false;
    }
}
