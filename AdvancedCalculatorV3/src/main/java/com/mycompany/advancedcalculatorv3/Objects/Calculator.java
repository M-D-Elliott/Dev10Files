package com.mycompany.advancedcalculatorv3.Objects;

import com.mycompany.advancedcalculatorv3.Utils.ArrayUtils;
import com.mycompany.advancedcalculatorv3.Utils.CharUtils;
import com.mycompany.advancedcalculatorv3.Utils.StringUtils;

public class Calculator {

    private boolean isError = false;
    
    private String input;
    private String out;
    
    private String errorMessage = "Err";
    
    private double lastValue;
    
    private Character[] allOperations;
    
    private Character[] nonBlockingOperations = new Character[]{'+', '-', };
    private Character[] blockingOperations = new Character[]{'/', '*', '.'};


    public Calculator(int totalMemory) {
        this.out = "";
        allOperations = ArrayUtils.concat(nonBlockingOperations, blockingOperations);
    }
    
    // entry points for calculator.
    public void calculate(){
        input = StringUtils.crunch(input);
        
        String tryOut = "";
        if(input.length() >= 0){
            tryOut = Double.toString(interpretExpression(input));
        }

        out = (isError) ? "error" : tryOut;
    }
    
    private int interpretExpression(String expression){
        int index = 0;
        int lastOpenParenIndex = index;
        String interprettingValue = "";
        
        int expressionLength = expression.length();
        
        for (char inputItem : expression.toCharArray()) {
            
            if(isError) { break; }
            
            if(CharUtils.isDigit(inputItem)){
                interprettingValue += inputItem;
                if(index >= expressionLength - 1) {
                    int rightMostValue = Integer.parseInt(interprettingValue);
                    
                    //test
                    System.out.println(rightMostValue);
                    
                    return rightMostValue;
                }
//            } else if(inputItem == '('){
//                lastOpenParen = index;
//            } else if(inputItem == ')') {
//                String internalExpression = expression.substring(lastOpenParen + 1, index);
//                leftValue += interpretExpression(internalExpression);
            } else if(isOperator(inputItem)){
                int leftValue = Integer.parseInt(interprettingValue);
                
                String rightExpression = expression.substring(index + 1, expressionLength);
                
                //test
                System.out.println(leftValue);
                
                return routeExpression(inputItem, leftValue, interpretExpression(rightExpression));
            }
            index++;
        }
        callError();
        return 0;
    }
    
    private int routeExpression(char operator, int value1, int value2){
        switch (operator) {
            case '+':
                return add(value1, value2);
            case '-':
                return subtract(value1, value2);
            case '*':
                return multiply(value1, value2);
            case '/':
               return divide(value1, value2);
            default:
                callError();
                return 0;
        }
    }
    
    
   // **************Operations:***********
    private int divide(int dividend, int divisor){
        return (dividend / divisor);
    }

    private int multiply(int first, int second){
        return first * second;
    }
    
    private int add(int first, int second){
        return first + second;
    }
    
    private int subtract(int first, int second){
        return first - second;
    }
    
    private boolean isOperator(char operator){
        for (char operation : allOperations) {
            if(operator == operation){
                return true;
            }
        }
        return false;
    }

//    ***Controlling the input and output strings the calculator holds
    private void clearOut(){
        out = "";
    }
    
    private void clearIn(){
        input = "";
    }
    
    private void clearBoth(){
        out = input = "";
    }
    
    private boolean callError(){
        System.out.println("error");
        isError = true;
        clearBoth();
        out = errorMessage;
        return true;
    }
    
    public void printOut(){
        System.out.println(out);
        out = "";
    }
    
    public void showOperations(){
        System.out.println("Operations: ");
        System.out.print(CharUtils.toString(allOperations));
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
