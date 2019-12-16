package com.sg.rogueliketools.tools;

import java.awt.Point;

public class ShapeGenerator {
    
    public ShapeGenerator(){}
    
    public void drawSquare(char character, Point firstVertex, Point secondVertex, char[][] grid){
        if(validate(grid, new Point[]{firstVertex, secondVertex})){
            // top left to bottom left
            drawLine(character, new Point(firstVertex.x, firstVertex.y), new Point(firstVertex.x, secondVertex.y), grid);
            // top left to top right
            drawLine(character, new Point(firstVertex.x + 1, firstVertex.y), new Point(secondVertex.x,firstVertex.y), grid);
            // bottom left to bottom right.    
            drawLine(character, new Point(firstVertex.x + 1, secondVertex.y), new Point(secondVertex.x, secondVertex.y), grid);
            // top right to bottom right.
            drawLine(character, new Point(secondVertex.x, firstVertex.y), new Point(secondVertex.x, secondVertex.y), grid);
        }
    }
    
//    public void drawDiamond(char character, Point firstVertex, int size, char[][] grid){
//        drawDiamond(character, firstVertex, size, size, grid);
//    }
    
//    public void drawDiamond(char character, Point firstVertex, int height, int width, char[][] grid){
//        drawDiamond(character, new Point(), new Point, new Point, new Point(), grid);
//    }
//    
    public void drawDiamond(char character, Point firstVertex, Point secondVertex, Point thirdVertex, Point fourthVertex, char[][] grid){
        if(validate(grid, new Point[]{firstVertex, secondVertex})){
            // 
            drawLine(character, firstVertex, secondVertex, grid);
            // 
            drawLine(character, secondVertex, thirdVertex, grid);
            //   
            drawLine(character, thirdVertex, fourthVertex, grid);
            // 
            drawLine(character, fourthVertex, firstVertex, grid);
        }
    }
    public void drawTriangle(char character, Point firstVertex, Point secondVertex, Point thirdVertex, char[][] grid){
        if(validate(grid, new Point[]{firstVertex, secondVertex})){
            // 
            drawLine(character, firstVertex, secondVertex, grid);
            // 
            drawLine(character, secondVertex, thirdVertex, grid);
            // 
            drawLine(character, thirdVertex, firstVertex, grid);
        }
    }
    public void drawCircle(char character, Point center, int radius, char[][] grid){
    }
    
    public void drawLine(char character, Point start, Point end, char[][] grid){
        int xDiff = Math.abs(start.x - end.x);
        int yDiff = Math.abs(start.y - end.y);
        
        // xDiff = 9, yDiff = 1
        // xGrowth = 9, yGrowth = 1/9
        float xGrowth = (xDiff == 0) ? 0 : (yDiff == 0 || yDiff < xDiff) ? 1 : ((float)xDiff) / yDiff;
        float yGrowth = (yDiff == 0) ? 0 : (xDiff == 0 || xDiff < yDiff) ? 1 : ((float)yDiff) / xDiff;
        
//        int largerDiff = (xDiff > yDiff) ? xDiff : yDiff;
//        int smallerMin = (start.x < start.y) ? start.x : start.y;
        
        int y = start.y;
        int x = start.x;
        
        int index = 0;
        while(x <= end.x && y <= end.y) {
            grid[y][x] = character;
            y = start.y + (int)Math.floor(yGrowth * index);
            x = start.x + (int)Math.floor(xGrowth * index);
            index++;
        }
//        while(x <= end.x && y <= end.y) {
//            grid[y][x] = character;
//            y += (int)Math.floor(yGrowth);
//            x += (int)Math.floor(xGrowth);
//        }
    }

    private boolean validate(char[][]grid, Point... points) {
        int width = grid[0].length;
        int height = grid.length;
        for (Point point : points) {
            if (point.x < 0 || point.y < 0 || point.x > width|| point.y > height){
                return false;
            }
        }
        return true;
    }
}
