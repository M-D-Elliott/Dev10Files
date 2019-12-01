package exercises2;

import Utils.ArrayUtils;
import Utils.CharUtils;
import Utils.IntUtils;
import Utils.StringUtils;
import java.util.Arrays;

public class AdvancedCalcV2 {
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


    public AdvancedCalcV2(int totalMemory) {
        this.totalMemory = totalMemory;
        this.currentMemory = totalMemory;
        this.out = "";
        allOperations = ArrayUtils.concat(nonBlockingOperations, blockingOperations);
    }
    
    public void calculate(){
        input = StringUtils.crunch(input);
        
        String tryOut = "";
        if(input.length() >= 0){
            tryOut = Arrays.toString(interpretExpression(input));
        }

        out = (isError) ? "error" : tryOut;
    }
    
    public int[] interpretExpression(String expression){
        int index = 0;
        int lastOpenParen = index;
        
        int interprettingIndex = 0;
        int interprettedValue = 0;
        int interprettedDecimal = 0;
        
        boolean interprettingDecimalNow = false;
        
        int expressionLength = expression.length();
        
        for (char inputItem : expression.toCharArray()) {
            
            if(isError) { break; }
            
            if(CharUtils.isDigit(inputItem)){
                interprettedValue += inputItem;
                if(index >= expressionLength - 1) {
                    int[] rightMostValue = { interprettedValue };
                    return rightMostValue;
                }
//            } else if(inputItem == '('){
//                lastOpenParen = index;
//            } else if(inputItem == ')') {
//                String internalExpression = expression.substring(lastOpenParen + 1, index);
//                leftValue += interpretExpression(internalExpression);
            } else if(isOperator(inputItem)){
                int leftValue[] = {
                    interprettedValue,
                    interprettedDecimal,
                };
                
                String rightExpression = expression.substring(index + 1, expressionLength);
                
                return calculateExpression(inputItem, leftValue, interpretExpression(rightExpression));
            }
            index++;
        }
        callError();
        return new int[]{0};
    }
    
    private int[] calculateExpression(char operator, int[] value1, int[] value2){

        int[] longerValue = (value1.length > value2.length) ? value1 : value2;
        int[] answer = new int[longerValue.length];
        
        int value1DecimalLen = IntUtils.countDigits(value1[1]);
        int value2DecimalLen = IntUtils.countDigits(value2[1]);
        
        int longestDecimalLength =  value1DecimalLen > value2DecimalLen  ? value1DecimalLen  : value2DecimalLen;
        
        for (int index = 0; index < longerValue.length; index++) {
            switch (operator) {
                case '+':
                    answer[index] = add(value1[index], value2[index]); break;
                case '-':
                    answer[index] = subtract(value1[index], value2[index]); break;
                case '*':
                    answer[index] = multiply(value1[index], value2[index]); break;
                case '/':
                    answer[index] = divide(value1[index], value2[index]); break;
                default:
                    callError();
            }
            index++;
        }

        return answer;
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

