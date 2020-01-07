package scoring;

import java.util.ArrayList;
import java.util.List;

public class Scorer {
    public void run(){
        // strike next two balls
        // spare next ball.
        // else just the frame itself.
        // 10th frame gets you extra ball if spare, two if strike.
        // sequence of ints bowling game.
    }
    
    public int scoreGame(List<Integer> scores){
        if(isValid(scores)){
            return scoring(scores, 0, 0);
        } else {
            return 0;
        }
    }
    
    private int scoring(List<Integer> scores, int score, int index){
        if(index + 1 >= scores.size()){
            score += scores.get(index);
            return score;
        }
        if(index == scores.size() - 3 && scores.get(index) == 10){
            return score += 10 + scores.get(index + 1) + scores.get(index + 2);
        }
        if(scores.get(index) == 10){
            if(index + 2 >= scores.size()){
                return score;
            }
            score += 10 + scores.get(index + 1) + scores.get(index + 2);
            return scoring(scores, score, index + 1);
        } else if(scores.get(index) + scores.get(index + 1) == 10) {
            if(index + 2 >= scores.size()){
                return score;
            }
            score += 10 + scores.get(index + 1);
            return scoring(scores, score, index + 2);
        }  else {
            score += scores.get(index);
            return scoring(scores, score, index + 1);
        }
    }
    
    private boolean isValid(List<Integer> scores){
        boolean isValid = true;
        if(scores.size() == 22){
            isValid = scores.get(20) == 10;
        } else if(scores.size() == 21){
            isValid = (scores.get(19) + scores.get(20) == 10);
        } else if(scores.size() == 20){
            isValid = true;
        }
//        if(isValid){
//            index = 0;
//            for (int i = 0; i < scores.size(); i+2) {
//                
//            }
//        }
        return isValid;
    }
}
