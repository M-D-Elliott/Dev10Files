package com.sg.rogueliketools;

import com.sg.rogueliketools.map.IncorrectDrawDimensionsException;
import com.sg.rogueliketools.map.Map;
import com.sg.rogueliketools.map.ShapeType;
import java.awt.Point;

public class TestApp {
    public static void main(String[] args) {
        // either of the below initialization techniques work.
        // open opens an existing map or creates a new map.
        // in the case of creating or opening a new map it will need a size
        // setting or it will error.
        
//        Map level1 = Map.OPEN("level1");
//    
//        level1.setSize(10);

        Map level1 = Map.NEW("level1", 10);

        level1.clear();
        
        try {
            // Yo, Dev10! Thought I'd make a mapgen algo for the roguelike!
            // also this will not work (yet) if the second point comes after the first
            // in either dimension. (I believe).
            
            // drawing a square for testing!
            // this is the only shape that I have put in so far,
            // but my first algorithm should work for all angular shapes
            // if used properly.
            //could use more validations, and point swapping).
//            level1.draw(ShapeType.S, new Point[]{new Point(0, 0), new Point(5, 5)});
            // this targets the draw-line, which I will eventually put to private.
//            level1.draw(new Point[]{new Point(0, 0), new Point(9, 5)});
            level1.draw(new Point[]{new Point(5, 3), new Point(9, 5)});
            level1.draw(new Point[]{new Point(2, 2), new Point(4, 9)});
            // made a Q in level1.txt. Check out it before altering!
            
        } catch (IncorrectDrawDimensionsException ex) {
            System.out.println(ex.getMessage());
        }
        
        // if you want to draw with a different character simply use the larger draw overload,
        // or change the Map.Defaults enum.
        level1.save();
    }
}
