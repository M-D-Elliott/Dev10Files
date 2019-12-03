package Grid;

import com.sg.findthecheesev2.game.pieces.IPiece;
import java.util.ArrayList;
import java.util.Random;

public class Grid {
    private ArrayList<IPiece> pieces;
    private int width;
    
    public Grid(ArrayList<IPiece> pieces, int width) {
        this.pieces = pieces;
        this.width = width;
        placeAllObjects();
    }
    
    public void print() {
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < width; col++) {
                boolean found = false;
                for (IPiece piece : pieces) {
                    if(piece.getX() == col && piece.getY() == row){
                        found = true;
                        System.out.print(piece.getSymbol());
                    }
                }
                
                if(!found){
                    System.out.print("_");
                }
            }
            System.out.println("");
        }
    }

    private void placeAllObjects() {
        Random r = new Random();
        int x = 0;
        int y = 0;
        
        for (IPiece piece : pieces) {
            do{
                x = r.nextInt(width);
                y = r.nextInt(width);
            } while(this.intersects(x, y));
                piece.setX(x);
                piece.setY(y);
        }
    }
    
    private boolean intersects(int x, int y) {
        if (pieces.stream().anyMatch((piece) -> 
                (piece.getX() == x || piece.getY() == y))) {
            return true;
        }
         return false;
    }

    public ArrayList<IPiece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<IPiece> pieces) {
        this.pieces = pieces;
    }
}
