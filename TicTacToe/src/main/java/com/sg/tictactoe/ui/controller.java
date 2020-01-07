package com.sg.tictactoe.ui;

import com.sg.tictactoe.data.PlayService;
import com.sg.tictactoe.model.Board;
import com.sg.tictactoe.model.Play;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    private PlayService service = new PlayService();
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/play")
    public ResponseEntity<Board> addPlay(@RequestBody Play play) {
        boolean success = service.add(play);
        
        Board board = service.getBoard();
        
        if (!success) {
            return new ResponseEntity<>(board, HttpStatus.I_AM_A_TEAPOT);
        }
        
        return new ResponseEntity<>(board, HttpStatus.CONTINUE);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/getAllMoves")
    public List<Play> showMoves() {
        List<Play> all = service.findAll();
        return all;
    }
}
