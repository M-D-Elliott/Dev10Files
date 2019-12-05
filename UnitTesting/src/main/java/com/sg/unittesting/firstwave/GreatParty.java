package com.sg.unittesting.firstwave;

public class GreatParty {
    public boolean greatParty(int cigars, boolean isWeekend){
        return cigars >= 40 && (isWeekend || cigars <= 60);
    }
}
