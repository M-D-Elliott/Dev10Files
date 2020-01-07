package com.sg.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import scoring.Scorer;

public class App {
    public static void main(String[] args) {
//        List<Integer> input = new ArrayList<>();
//        Random r = new Random();
        Scorer scorer = new Scorer();
//        int length = 0;
//        while(length < 11){
//            length = r.nextInt(21 + 1);
//        }
        List<Integer> input = new ArrayList<>(){{
            add(0);
            add(10);
            add(7);
            add(0);
            add(2);
            add(2);
            add(3);
            add(4);
            add(8);
            add(0);
            add(3);
            add(1);
            add(4);
            add(1);
            add(0);
            add(0);
            add(0);
            add(8);
            add(2);
            add(0);
            add(1);
        }};
        int firstResult = scorer.scoreGame(input);
        System.out.println(String.format("Game 1 : %d", firstResult));
        input = new ArrayList<>(){{
            add(4);
            add(1);
            add(4);
            add(1);
            add(1);
            add(2);
            add(7);
            add(3);
            add(2);
            add(4);
            add(8);
            add(2);
            add(7);
            add(2);
            add(8);
            add(0);
            add(1);
            add(7);
            add(9);
            add(0);
        }};
        
        int secondResult = scorer.scoreGame(input);
        System.out.println(String.format("Game 2 : %d", secondResult));
//        1,7,2,7,1,3,4,0,10,0,0,7,2,10,7,3,7,0
//        5,0,5,4,6,3,7,2,8,2,8,2,1,7,8,2,3,2,1,6
//        7,1,2,5,3,7,6,1,9,0,10,5,0,2,0,9,0,8,1
//        4,4,4,5,0,4,7,0,3,5,4,1,8,1,0,6,2,4,1,6
    }
}
