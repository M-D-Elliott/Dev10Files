package exercises2;


import Utils.InOutUtils;

import Utils.InOutUtils;

public class AdvancedCalcAppV2 {
    private AdvancedCalcV2 calculator;
    
    private boolean continueRunning = true;
    
    private int operationId = 0;
            
    private boolean acceptingUserInput;
    
    public AdvancedCalcAppV2() {
        this.calculator = new AdvancedCalcV2(10000);
        this.acceptingUserInput = true;
    }
    
    public void run(){
        while(continueRunning){
            reset();
            
            String expression = "";
            
            if(acceptingUserInput){ 
                expression = getAndInterpretUserInput(": "); 
            }
            
            calculator.setInput(expression);
            
            calculator.calculate();
            
            calculator.printOut();
        }
    }

    public void stop() {
        continueRunning = false;
    }
    
    public void reset(){
        continueRunning = true;
        acceptingUserInput = true;
    }
    
    private String getAndInterpretUserInput() {
        return getAndInterpretUserInput("Still want to calculate? 'q' or 'quit' to stop.");
    }
    
    private String getAndInterpretUserInput(String prompt) {
        String input = "";
        if(continueRunning) {
            input = InOutUtils.read(prompt).toLowerCase();
            if(InOutUtils.quit(input)){
                System.out.println("Thanks for calculating!");
                stop();
            } else if(input.contains("show") || input.contains("how")) {
                calculator.showOperations();
                return getAndInterpretUserInput();
            }
        }
        return input;
    }
}
