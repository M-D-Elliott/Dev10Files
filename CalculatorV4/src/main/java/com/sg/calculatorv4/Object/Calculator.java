package com.sg.calculatorv4.Object;

import com.sg.calculatorv4.Utils.ArrayUtils;
import com.sg.calculatorv4.Utils.CharUtils;
import com.sg.calculatorv4.Utils.IntUtils;
import com.sg.calculatorv4.Utils.StringUtils;
import java.util.Arrays;

public class Calculator {

    private boolean isError = false;

    private String input;
    private String out;

    private double lastValue;

    private boolean isDecimalInOut;
    
    private Character[] operations;
    private Character[] nonBlockingOperations = new Character[]{'+', '-',};
    private Character[] blockingOperations = new Character[]{'/', '*', '.', '^'};

    public Calculator() {
        clearBoth();
        reset();
        this.operations = ArrayUtils.concat(nonBlockingOperations, blockingOperations);
    }

    //interprets expression as char array.
    // recursive, will call itself on expression to
    // the right of each operator.
    private int interpretExpression(char[] expression) {
        int index = 0;
//        int lastOpenParenIndex = index;
        int leftValue = 0;
        int totalDigits = 0;
        int totalDecimals = 0;
        boolean isDecimalInThisExpression = false;

        for (char inputItem : expression) {

            if (isError) {
                break;
            }
            char[] rightExpression;
             // This switch routes the value and remaining
             // expression to the correct calculator function.
            switch (inputItem) {
                case '+': // Add Function
                    rightExpression = 
                            Arrays.copyOfRange(expression, index + 1, expression.length);
                    return add(leftValue, interpretExpression(rightExpression));
                case '-': // Subtract Function
                    rightExpression = 
                            Arrays.copyOfRange(expression, index + 1, expression.length);
                    return subtract(leftValue, interpretExpression(rightExpression));
                case '*': // Multiply Function
                    rightExpression = 
                            Arrays.copyOfRange(expression, index + 1, expression.length);
                    return multiply(leftValue, interpretExpression(rightExpression));
                case '/': // Divide Function
                    rightExpression = 
                            Arrays.copyOfRange(expression, index + 1, expression.length);
                    return divide(leftValue, interpretExpression(rightExpression));
                case '^': // Exponential Function
                    rightExpression = 
                            Arrays.copyOfRange(expression, index + 1, expression.length);
                    return exponential(leftValue, interpretExpression(rightExpression));
                case '.':
                    totalDecimals = 1;
                    isDecimalInThisExpression = isDecimalInOut = true;
                    break;
//                case '(':
//                    lastOpenParenIndex = index;
//                    break;
//                case ')':
//                    rightExpression = Arrays.copyOfRange(expression, lastOpenParenIndex + 1, index);
//                    return interpretExpression(rightExpression);
                default:
                    if (CharUtils.isDigit(inputItem)) {
                        int allDigits = totalDigits + totalDecimals;
                        leftValue *= exponential(10, IntUtils.filter(allDigits, 0, 1));
                        leftValue += Character.getNumericValue(inputItem);
                        
                        if (index >= expression.length - 1) {
                            // left value is the rightmost 
                            // value in calculator expression
                            return leftValue;
                        }
                        totalDigits++;
                        totalDecimals = (isDecimalInThisExpression) ? totalDecimals + 1 : 0;
                    }
            }
            index++;
        }
        callError("Input");
        return 0;
    }

    // **************Operations:***********
    private int divide(int dividend, int divisor) {
        if (divisor == 0) {
            callError("Divide by zero");
            return 0;
        }
        return (dividend / divisor);
    }

    private int multiply(int first, int second) {
        return first * second;
    }

    private int add(int first, int second) {
        return first + second;
    }

    private int subtract(int first, int second) {
        return first - second;
    }

    private int exponential(int base, int power) {
        if(power == 0){
            return 1;
        }
        int ret = base;
        for (int i = 1; i < power; i++) {
            ret *= base;
        }
        return ret;
    }

    private boolean isOperator(char operator) {
        for (char operation : operations) {
            if (operator == operation) {
                return true;
            }
        }
        return false;
    }

//    ***Controlling the input and output strings the calculator holds
    private void clearOut() {
        out = "";
    }

    private void clearIn() {
        input = "";
    }

    private void clearBoth() {
        out = input = "";
    }
    
    private void reset(){
        isError = false;
        isDecimalInOut = false;
    }

    private boolean callError() {
        return callError("");
    }

    private boolean callError(String message) {
        isError = true;
        clearBoth();
        out = message + " Error";
        return true;
    }
    
    // entry point for calculator.
    public void calculate() {
        reset();
        input = StringUtils.crunch(input);

        String tryOut = "";
        if (input.length() >= 0) {
            if(isDecimalInOut){
                tryOut = Double.toString(interpretExpression(input.toCharArray()));
            } else {
                tryOut = Integer.toString(interpretExpression(input.toCharArray()));
            }
        }

        if(!isError){
            out = tryOut;
        }
    }

    public void printOut() {
        System.out.println("= " + out);
        clearBoth();
    }

    public void showOperations() {
        System.out.println("Operations: ");
        System.out.print(CharUtils.toString(operations));
        System.out.println("");
    }

    //getters and setters
    public String getOut() {
        return out;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
