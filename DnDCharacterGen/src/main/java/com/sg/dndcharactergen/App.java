package com.sg.dndcharactergen;

import com.sg.charactergen.objects.Generator;
import com.sg.charactergen.ui.ConsoleIO;

public class App {
    public static void main(String[] args) {
        Generator generator = new Generator(new ConsoleIO());
        
        boolean continueRunning = true;
        
        while(continueRunning){
            generator.generate();
            continueRunning = false;
        }
    }
}
