package exercises4;

import java.util.Scanner;

public class Birthstones {
    private Scanner sc = new Scanner(System.in);
    public void run() {
        int month = readIntInput("What month were you born in? By number, please!");
        String name = "";
        String stone = "";
        switch(month){
            case 1:
                name = "January";
                stone = "garnet";
                break;
            case 2:
                name = "February";
                stone = "Amethyst";
                break;
            case 3:
                name = "March";
                stone = "Aquamarine";
                break;
            case 4:
                name = "April";
                stone = "Diamond";
                break;
            case 5:
                name = "May";
                stone = "Emerald";
                break;
            case 6:
                name = "June";
                stone = "Pearl";
                break;
            case 7:
                name = "July";
                stone = "Ruby";
                break;
            case 8:
                name = "August";
                stone = "Peridot";
                break;
            case 9:
                name = "September";
                stone = "Sapphire";
                break;
            case 10:
                name = "October";
                stone = "Opal";
                break;
            case 11:
                name = "November";
                stone = "Topaz";
                break;
            case 12:
                name = "December";
                stone = "Turquoise";
                break;
            default: break;
        } 
        System.out.println("The stone for " + name + " is " + stone);
    }
    
    public int readIntInput(String prompt) {
        System.out.println(prompt + " ");
        return sc.nextInt();
    }
}
