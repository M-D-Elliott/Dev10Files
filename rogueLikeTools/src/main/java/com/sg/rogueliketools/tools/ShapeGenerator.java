package com.sg.rogueliketools.tools;

import java.awt.Point;

public class ShapeGenerator {
    
    public ShapeGenerator(){}
    
    public char[][] drawSquare(char character, Point firstVertex, Point secondVertex, char[][] grid){
        if(validate(grid, new Point[]{firstVertex, secondVertex})){
            // top left to bottom left
            grid = drawLine(character, new Point(firstVertex.x, firstVertex.y), new Point(firstVertex.x, secondVertex.y), grid);
            // top left to top right
            grid = drawLine(character, new Point(firstVertex.x + 1, firstVertex.y), new Point(secondVertex.x,firstVertex.y), grid);
            // bottom left to bottom right.    
            grid = drawLine(character, new Point(firstVertex.x + 1, secondVertex.y), new Point(secondVertex.x, secondVertex.y), grid);
            // top right to bottom right.
            grid = drawLine(character, new Point(secondVertex.x, firstVertex.y), new Point(secondVertex.x, secondVertex.y), grid);
        }
        return grid;
    }
    public char[][] drawDiamond(char character, Point firstVertex, Point secondVertex, Point thirdVertex, Point fourthVertex, char[][] grid){
        return grid;
    }
    public char[][] drawTriangle(char character, Point firstVertex, Point secondVertex, Point thirdVertex, char[][] grid){
        return grid;
    }
    public char[][] drawCircle(char character, Point center, int radius, char[][] grid){
        return grid;
    }
    
    public char[][] drawLine(char character, Point start, Point end, char[][] grid){
        int xDiff = Math.abs(start.x - end.x);
        int yDiff = Math.abs(start.y - end.y);
        
        double xGrowth = (xDiff == 0) ? 0 : (yDiff == 0) ? 1 : xDiff / yDiff;
        double yGrowth = (yDiff == 0) ? 0 : (xDiff == 0) ? 1 : yDiff / xDiff;
        
        int largerDiff = (xDiff > yDiff) ? xDiff : yDiff;
        int smallerMin = (start.x < start.y) ? start.x : start.y;
        
        int y = start.y;
        int x = start.x;
        
        while(x <= end.x && y <= end.y) {
            grid[y][x] = character;
            y += (int)Math.floor(yGrowth);
            x += (int)Math.floor(xGrowth);
        }
        return grid;
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
