package exercises2;

import Utils.InOutUtils;

public class SimpleCalculator {
    private int totalMemory;
    private int currentMemory;
    
    private boolean isCalculating = false;
    
    private String out;
    
    private double lastValue;
    
    private char[] operations = new char[]{'+', '-', '/', '*',};


    public SimpleCalculator(int totalMemory) {
        this.totalMemory = totalMemory;
        this.currentMemory = totalMemory;
        this.out = "";
    }
    
    public int getOperatorID(char operator) {
        boolean goodInput = false;
        while(!goodInput){
            for (char symbol : operations) {

                if(operator == symbol){

                    switch (symbol) {
                        case '+':
                            return 1;
                        case '-':
                            return 2;
                        case '*':
                            return 3;
                        case '/':
                            return 4;
                        default:
                            System.out.println("Bad operator.");
                            goodInput = false;
                    }
                }
             }
        }
        return 0;
    }
    
    public boolean divideWithRemainder(int divisor, boolean isRemainder){
        return divideWithRemainder(lastValue, divisor, isRemainder);
    }
    
    public boolean divideWithRemainder(int dividend, int divisor, boolean isRemainder){
        return divideWithRemainder((double)dividend, (double)divisor, isRemainder);
    }
    
    public boolean divideWithRemainder(double divisor, boolean isRemainder){
        return divideWithRemainder(lastValue, divisor, isRemainder);
    }
    
    public boolean divideWithRemainder(double dividend, double divisor, boolean isRemainder){
        int memory = 1;
        if(hasEnoughMemory(memory)){
            allocateMemory(memory);
            isCalculating = true;
            double remainder = (isRemainder) ? dividend % divisor : 0;
            double value = dividend / divisor;
            out += dividend + " / " + divisor + " = " + value + " R" + remainder;
            isCalculating = false;
            deAllocateMemory(memory);
            return true;
        }
        return false;
    }
    
    public boolean divide(int divisor){
        return divide(lastValue, divisor);
    }
    
    public boolean divide(int dividend, int divisor){
        return divide((double)dividend, (double)divisor);
    }
    
    public boolean divide(double divisor){
        return divide(lastValue, divisor);
    }
    
    public boolean divide(double dividend, double divisor){
        int memory = 1;
        if(hasEnoughMemory(memory)){
            allocateMemory(memory);
            isCalculating = true;
            double value = (dividend / divisor);
            out += dividend + " / " + divisor + " = " + value;
            isCalculating = false;
            deAllocateMemory(memory);
            return true;
        }
        return false;
    }
    
    public boolean multiply(int value){
        return multiply(lastValue, value);
    }
    
    public boolean multiply(int value1, int value2){
        return multiply((double)value1, (double)value2);
    }

    public boolean multiply(double first, double second){
        int memory = 1;
        if(hasEnoughMemory(memory)){
            allocateMemory(memory);
            isCalculating = true;
            double value = first * second;
            out += first + " * " + second + " = " + value;
            isCalculating = false;
            deAllocateMemory(memory);
            return true;
        }
        return false;
    }
    
    public boolean add(int value){
        return add(lastValue, value);
    }
        
    public boolean add(int value1, int value2){
        return add((double)value1, (double)value2);
    }
    
    public boolean add(double value){
        return add(lastValue, value);
    }
    
    public boolean add(double first, double second){
        int memory = 1;
        if(hasEnoughMemory(memory)){
            allocateMemory(memory);
            isCalculating = true;
            double value = (first + second);
            out += first + " + " + second + " = " + value;
            isCalculating = false;
            deAllocateMemory(memory);
            return true;
        }
        return false;
    }
    
    public boolean subtract(int value){
        return subtract(lastValue, value);
    }
        
    public boolean subtract(int value1, int value2){
        return subtract((double)value1, (double)value2);
    }
    
    public boolean subtract(double value) {
        return subtract(lastValue, value);
    }
    
    public boolean subtract(double first, double second){
        int memory = 1;
        if(hasEnoughMemory(memory)){
            allocateMemory(memory);
            isCalculating = true;
            double value = (first - second);
            out += first + " - " + second + " = " + value;
            isCalculating = false;
            deAllocateMemory(memory);
            return true;
        }
        return false;
    }
    
    public boolean clear() {
        return clearOut();
    }

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
    
    private boolean restore(){
        if(isCalculating){
            return false;
        }
        currentMemory = totalMemory;
        return true;
    }
    
    public int getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getOut() {
        return out;
    }
    
    public void printOut(){
        System.out.println(out);
        out = "";
    }
}
