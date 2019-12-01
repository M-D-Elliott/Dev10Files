package exercises2;

import Utils.ArrayUtils;
import Utils.CharUtils;
import Utils.IntUtils;
import Utils.StringUtils;

public class AdvancedCalc {
    private int totalMemory;
    private int currentMemory;
    
    private boolean isCalculating = false;
    private boolean isError = false;
    
    private String input;
    private String out;
    
    private String errorMessage = "Err";
    
    private double lastValue;
    
    private Character[] allOperations;
    
    private Character[] nonBlockingOperations = new Character[]{'+', '-', };
    private Character[] blockingOperations = new Character[]{'/', '*', '.'};


    public AdvancedCalc(int totalMemory) {
        this.totalMemory = totalMemory;
        this.currentMemory = totalMemory;
        this.out = "";
        allOperations = ArrayUtils.concat(nonBlockingOperations, blockingOperations);
    }
    
    public void calculate(){
        input = StringUtils.crunch(input);
        
        String tryOut = "";
        if(input.length() >= 0){
            tryOut = Double.toString(interpretExpression(input));
        }

        out = (isError) ? "error" : tryOut;
    }
    
    public int interpretExpression(String expression){
        int index = 0;
        int lastOpenParen = index;
        String interprettingValue = "";
        
        int expressionLength = expression.length();
        
        for (char inputItem : expression.toCharArray()) {
            
            if(isError) { break; }
            
            if(CharUtils.isDigit(inputItem)){
                interprettingValue += inputItem;
                if(index >= expressionLength - 1) {
                    int rightMostValue = Integer.parseInt(interprettingValue);
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
                
                return calculateExpression(inputItem, leftValue, interpretExpression(rightExpression));
            }
            index++;
        }
        callError();
        return 0;
    }
    
    private int calculateExpression(char operator, int value1, int value2){
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

    public int divide(int dividend, int divisor){
        int memory = 1;
        if(hasEnoughMemory(memory)){
            allocateMemory(memory);
            isCalculating = true;
            int value = (dividend / divisor);
            isCalculating = false;
            deAllocateMemory(memory);
            return value;
        }
        return 0;
    }

    public int multiply(int first, int second){
        int memory = 1;
        if(hasEnoughMemory(memory)){
            allocateMemory(memory);
            isCalculating = true;
            int value = first * second;
            isCalculating = false;
            deAllocateMemory(memory);
            return value;
        }
        return 0;
    }
    
    public int add(int first, int second){
        int memory = 1;
        if(hasEnoughMemory(memory)){
            allocateMemory(memory);
            isCalculating = true;
            int value = (first + second);
            isCalculating = false;
            deAllocateMemory(memory);
            return value;
        }
        return 0;
    }
    
    public int subtract(int first, int second){
        int memory = 1;
        if(hasEnoughMemory(memory)){
            allocateMemory(memory);
            isCalculating = true;
            int value = (first - second);
            out += first + " - " + second + " = " + value;
            isCalculating = false;
            deAllocateMemory(memory);
            return value;
        }
        return 0;
    }
    
    public boolean isOperator(char operator){
        for (char operation : allOperations) {
            if(operator == operation){
                return true;
            }
        }
        return false;
    }
    
    
    // **************Storage(for fun)************
    private void allocateMemory(int allocatedMemory){
        currentMemory -= allocatedMemory;
    }
    
    private void deAllocateMemory(int restoredMemory){
        currentMemory += restoredMemory;
        if(currentMemory > totalMemory){
            restore();
        }
    }
    
    private boolean hasEnoughMemory(int memoryToAllocate){
        return currentMemory - memoryToAllocate > 0;
    }
    
    private boolean clearOut(){
        if(restore()){
            out = "";
            return true;
        }
        return false;
    }
    
    private boolean clearIn(){
        if(restore()){
            input = "";
            return true;
        }
        return false;
    }
    
    private boolean clearBoth(){
        if(restore()){
            out = input = "";
            return true;
        }
        return false;
    }
    
    private boolean restore(){
        if(isCalculating){
            return false;
        }
        currentMemory = totalMemory;
        return true;
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
    public int getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

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
