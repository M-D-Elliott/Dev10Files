
package com.sg.keyboardmusic.UserIO;

public interface UserIO {

    void print();
    
    void print(String message);
    
    void print(int value);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);
    
    String readString(String prompt, boolean newLine);
    
    boolean quit(String keyWord);
    
    String encaseInBanner(String inner);
    
    String encaseInBanner(String inner, String banner);
    
    String encaseInBanner(boolean whiteSpace, String inner, String banner);
    
    String encaseInBanner(boolean print, boolean whiteSpace, String inner, String banner);
    
    String multilineBanner(String... inner);
    
    String multilineBanner(boolean print, String... inner);
    
    String multilineBanner(boolean print, boolean whiteSpace, String... inner);
}
