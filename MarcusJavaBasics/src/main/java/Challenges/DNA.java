package Challenges;

import Utils.InOutUtils;
import java.util.Scanner;

public class DNA {
    private boolean _continue = true;
    public void run() {
        while(_continue) {
            InOutUtils.encaseInBanner(true, true, new String[] {
                "Enter 'q' or 'quit' to quit",
                "Is it (DNA) or (RNA)?",
            });
            String type = InOutUtils.readInput("").toUpperCase();
            
            // check if quit was typed.
            _continue = !InOutUtils.quit(type);
            
            if(_continue) {
                boolean rna = type.equals("RNA");
                String strand = InOutUtils.readInput("Please enter the " + type + " strand").toUpperCase();
                
                //check again if quit was typed.
                _continue = !InOutUtils.quit(strand);
                
                if(_continue) {
                    InOutUtils.encaseInBanner(true, true, new String[] {
                        "Input " + type + " strand:",
                        strand,
                        "Complimentary " + type + " strand:",
                        transcribe(strand, rna),
                    });
                }
            } 
        }
    }
    
    public String transcribe(String strand) {
        return transcribe(strand, false);
    }
    
    public String transcribe(String strand, boolean rna) {
        int len = strand.length();
        String compStrand = "";
        char[] strandAsChar = strand.toCharArray();
        for(int i = 0; i < len; i++) {
            switch(strandAsChar[i]) {
                case 'A':
                    if(rna) {
                        compStrand += "U";
                    } else {
                        compStrand += "T";
                    }
                    break;
                case 'T':
                    compStrand += "A";
                    break;
                case 'G':
                    compStrand += "C";
                    break;
                case 'C':
                    compStrand += "G";
                    break;
                default:
                    compStrand += "?";
                    break;
            }
        }
        return compStrand;
    }
}
