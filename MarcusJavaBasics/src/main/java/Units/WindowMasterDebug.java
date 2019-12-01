package Units;

import java.util.Scanner;

public class WindowMasterDebug {
    private Scanner sc = new Scanner(System.in);
    public void run() {
         // Declare variables for height and width
        float height;
        float width;

        // Declare other variables
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;

        // Get input from user
        height = readValue("Please enter window height:");
        width = readValue("Please enter window width:");

        // Calculate area of window
        areaOfWindow = height * width;

        // Calculate the perimeter of the window
        perimeterOfWindow = 2 * (height + width);

        // Calculate total cost - use hard coded for material cost
        cost = ((3.50f * areaOfWindow) + (2.25f * perimeterOfWindow));

        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost = " + cost);
    }
    
    private float readValue(String prompt) {
    // print prompt to Console
    System.out.println(prompt);
    // read value into String data type
    String input = sc.nextLine();
    // convert the String to a float
    float floatVal = Float.parseFloat(input);
    // return the float value
    return floatVal;
}
}
