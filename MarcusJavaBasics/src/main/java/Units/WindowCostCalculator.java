package Units;

import java.util.Scanner;

public class WindowCostCalculator {
    private float height;
    private float width;

    // declare other variables
    private float areaOfWindow;
    private float cost;
    private float perimeterOfWindow;
    
    public void run() {
        // declare and initialize the Scanner
        Scanner myScanner = new Scanner(System.in);

        // get input from the user
        System.out.println("Please enter window height:");
        height = stringToFloat(myScanner.nextLine());
        System.out.println("Please enter window width:");
        width = stringToFloat(myScanner.nextLine());

        // calculate the area of the window
        areaOfWindow = height * width;

        // calculate the perimeter of the window
        perimeterOfWindow = 2 * (height + width);

        // calculate the total cost - use a hard-coded value
        // for material cost
        cost = ((3.50f * areaOfWindow) + (2.25f * perimeterOfWindow));

        // display the results to the user
        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost =  " + cost);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
    
    public float stringToFloat(String s) {
        return Float.parseFloat(s);
    }
}
