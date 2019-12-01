package exercises11;

import Utils.InOutUtils;

public class InterestCalculator {
    private int _investment = 500;
    private double _annualRate = 10.0;
    
    private int _monthPeriods = 3;
    private final int MONTHYEARS = 12;
    
    public void run() {
        _annualRate = InOutUtils.readInt("What is the annual rate?");
        _investment = InOutUtils.readInt("What is the initial investment?");
        int years = InOutUtils.readInt("How many years?");
        int periods = years * 12 / _monthPeriods;
        
        double total = compoundOverPeriods(_investment, _annualRate, periods);
        System.out.println(total);
    }
    
    private double compoundOverPeriods(double amt, double rate, double periods) {
        double periodCompound = compoundingPerYear(rate);
        for(int i = 0; i < periods;i++){
            amt = compound(amt, periodCompound);
            System.out.println(amt);
        }
        return amt;
    }
    
    private double compound(double amt, double periodCompound){
        return amt * (1 + periodCompound / 100);
    }

    private double compoundingPerYear(double _rate) {
        return _rate / (MONTHYEARS / _monthPeriods);
    }
}
