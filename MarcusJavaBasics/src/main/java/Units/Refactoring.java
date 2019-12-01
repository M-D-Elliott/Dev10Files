package Units;

import java.util.Scanner;

public class Refactoring {
    public void run() {
        Scanner sc = new Scanner(System.in);
        do {
            printGrid(5, 6,  '-', '*');
            System.out.println("Play again?");
        }while(sc.nextLine().equalsIgnoreCase("y"));
    }

    private void printGrid(int rows, int cols, char inner, char outer) {
        for(int row = 0; row < rows; row++) {
            printLine(row, rows, cols, outer, inner);
            System.out.println("");
        }
    }

    private void printLine(int row, int maxRows, int maxCols, char outer, char inner) {
        char toPrint;
        for(int col = 0; col < maxCols; col++) {
            if(row == 0 || row == 3) {
                toPrint = outer;
            } else {
                toPrint = inner;
            }
            System.out.print(toPrint);
        }
    }
}
