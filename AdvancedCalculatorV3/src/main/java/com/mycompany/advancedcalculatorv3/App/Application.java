package com.mycompany.advancedcalculatorv3.App;

import com.mycompany.advancedcalculatorv3.Objects.Calculator;
import com.mycompany.advancedcalculatorv3.UserIO.UserIOImplementation;

public class Application {
    private Calculator calculator;
    
    private boolean continueRunning;
    
    private int operationId = 0;
            
    private boolean acceptingUserInput;
    
    private UserIOImplementation io;
    
    public Application() {
        continueRunning = true;
        
        io = new UserIOImplementation();
        this.calculator = new Calculator(10000);
        this.acceptingUserInput = true;
    }
    
    public void start(){
        setUp();
        
        menuLoop();
    }
    
    public void setUp(){
        //Not impled.
    }
    
    public void menuLoop(){
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
            input = io.readString(prompt).toLowerCase();
            if(io.quit(input)){
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
