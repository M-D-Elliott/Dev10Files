
package com.mycompany.studentquizscores.UserIO;

public interface UserIO {

    void print(String message);

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
    
    void encaseInBanner(String... inner);
    
    void encaseInBanner(boolean print, String... inner);
    
    void encaseInBanner(boolean print, boolean whiteSpace, String... inner);
}
