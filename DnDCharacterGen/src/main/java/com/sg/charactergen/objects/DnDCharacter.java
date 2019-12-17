package com.sg.charactergen.objects;

public class DnDCharacter {
    private int STR;
    private int DEX;
    private int CON;
    private int INT;
    private int WIS;
    private int CHR;

    public DnDCharacter() {
        STR = DEX = CON = INT = WIS = CHR = 0;
    }
    
    public DnDCharacter(int STR, int DEX, int CON, int INT, int WIS, int CHR) {
        this.STR = STR;
        this.DEX = DEX;
        this.CON = CON;
        this.INT = INT;
        this.WIS = WIS;
        this.CHR = CHR;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getCON() {
        return CON;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public int getWIS() {
        return WIS;
    }

    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    public int getCHR() {
        return CHR;
    }

    public void setCHR(int CHR) {
        this.CHR = CHR;
    }
    
    
}
