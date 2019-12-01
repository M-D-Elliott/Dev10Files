package exercises2;

import Utils.InOutUtils;

public class SimpleCalcApp {
    private SimpleCalculator calculator;
    
    private boolean continueRunning = true;
    
    private int operationId = 0;
            
    private boolean acceptingUserInput;
    
    public SimpleCalcApp() {
        this.calculator = new SimpleCalculator(10000);
        acceptingUserInput = true;
    }
    
    public void run(){
        while(continueRunning){
            reset();
            
//            showOperations();
            
            int operand1 = InOutUtils.tryReadInt(": ");
            char operator = InOutUtils.readChar(": ");
            int operand2 = InOutUtils.tryReadInt(": ");
            
            
            operationId = calculator.getOperatorID(operator);
            switch(operationId){
                case 1:
                    calculator.add(operand1, operand2);
                    break;
                case 2:
                    calculator.subtract(operand1, operand2);
                    break;
                case 3:
                    calculator.multiply(operand1, operand2);
                    break;
                case 4:
                    calculator.divide(operand1, operand2);
                    break;
            }
            
            calculator.printOut();

            if(acceptingUserInput){ getAndParseUserInput(); }
        }
    }

    public SimpleCalculator getCalculator() {
        return calculator;
    }

    public void setCalculator(SimpleCalculator calculator) {
        this.calculator = calculator;
    }
    
    public void stop() {
        continueRunning = false;
    }
    
    public void reset(){
        continueRunning = true;
        acceptingUserInput = true;
    }
    
    private void getAndParseUserInput() {
        if(continueRunning) {
            String input = InOutUtils.read("Still want to calculate? 'q' or 'quit' to stop.").toLowerCase();
            if(InOutUtils.quit(input)){
                System.out.println("Thanks for playing!");
                stop();
            } else if(input.contains("show") || input.contains("moves")) {
                getAndParseUserInput();
            } else if(input.contains("rules") || input.contains("how")) {
                getAndParseUserInput();
            } else {
                reset();
            }
        }
    }

//    private boolean showOperations(){
//        System.out.println(StringUtils.arrayToString(operations));
//        return true;
//    }
}
