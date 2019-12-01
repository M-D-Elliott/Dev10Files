package Challenges;

import Utils.InOutUtils;

public class ThomasProgram {
    public void run() {
        int age = InOutUtils.readInt("How old are you?");
        
        int fiveXAgeXTen = age * 5 * 10;
        
        int day = InOutUtils.readInt("What is the date?");
        
        int fiveXAgeXTenPlusDateX2 = (fiveXAgeXTen + day) * 2;
        
        int size = InOutUtils.readInt("What is your shoe size?");
        
        int last = fiveXAgeXTenPlusDateX2 + size;
        
        last -= 2 * day;
        
        System.out.println(last);
    }
}
