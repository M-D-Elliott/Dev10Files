package com.sg.tictactoe.data;

import com.sg.tictactoe.model.Board;
import com.sg.tictactoe.model.Play;
import java.awt.Point;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
        
@Service
public class PlayService {

    private final List<Play> moves = new ArrayList<>();
    
    private static final int SIZE = 3;
    
    private Board board = new Board(SIZE);
    
    public PlayService() {
    }
    
    public List<Play> findAll() {
        return new ArrayList<>(moves);
    }

    public boolean add(Play play) {
        
        Point pos = play.getPosition();
        // input validation
        if(play == null || pos.x >= SIZE || pos.y >= SIZE){
            return false;
        }
        
        boolean positionFilled = moves.stream()
                                    .anyMatch(p -> p.getPosition().equals(play.getPosition()));
        if (!positionFilled){
            board.incTurn();
            moves.add(play);
            Point position = play.getPosition();
            Character[][] grid = board.getGrid();
            grid[position.x][position.y] = play.getSide();
            board.setGrid(grid);
            return true;
        }

        return false;
    }

    public Board getBoard() {
        return board;
    }
}
