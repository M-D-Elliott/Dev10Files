package com.sg.rogueliketools.tools;

import java.awt.Point;
import storagecom.sg.rogueliketools.storage.TwoDCharacterArraySaver;

public class Map {
    
    private char[][] grid;
    
    private int height;
    private int width;
    
    private String fileName;
    private TwoDCharacterArraySaver fileSaver = new TwoDCharacterArraySaver();
    private ShapeGenerator shapeGen = new ShapeGenerator();
    
    private static final ShapeType DEFAULT_SHAPE = ShapeType.L;
    private static final char DEFAULT_CHAR = MapDefaults.WALL.getValue();
    
    // static ways to open or initialize the map.
    // for nicity!
    public static Map OPEN(String fileName){
        return new Map(fileName);
    }
    public static Map NEW(String fileName, int size){
        return new Map(fileName, size);
    }
    
    public Map(String fileName){
        this.fileName = fileName + ".txt";
        grid = fileSaver.load(fileName);
        if(grid.length > 0){
            this.width = grid[0].length;
            this.height = grid.length;
        } else {
            this.width = this.height = 0;
        }
    }
    
    public Map(String fileName, int size){
        this.fileName = fileName + ".txt";
        grid = new char[size][size];
        width = height = size;
        initializeGrid();
    }
    
    //bunch of overloads to make drawing lines easier,
    // or to allow the assumed character to be the wall.
    public void draw(Point... points) throws IncorrectDrawDimensionsException{
        draw(DEFAULT_SHAPE, points);
    }
    
    public void draw(ShapeType type, Point... points) throws IncorrectDrawDimensionsException{
        draw(type, DEFAULT_CHAR, points);
    }
    
    public void draw(char character, Point... points) throws IncorrectDrawDimensionsException{
        draw(DEFAULT_SHAPE, character, points);
    }
    
    public void draw(ShapeType type, char character, Point... points) throws IncorrectDrawDimensionsException {
        if(null != type)switch (type) {
            case S:
            case SQUARE:
                if(points.length != 2){
                    throw new IncorrectDrawDimensionsException("A square is drawn from two points.");
                }   
                grid = shapeGen.drawSquare(character, points[0], points[1], grid);
                break;
            case T:
            case TRIANGLE:
                if(points.length != 3){
                    throw new IncorrectDrawDimensionsException("A triangle is drawn from three points.");
                }   
                grid = shapeGen.drawTriangle(character, points[0], points[1], points[2], grid);
                break;
            case D:
            case DIAMOND:
                if(points.length != 4){
                    throw new IncorrectDrawDimensionsException("A diamond is drawn from four points.");
                }   
                grid = shapeGen.drawDiamond(character, points[0], points[1], points[2], points[3], grid);
                break;
            case C:
            case CIRCLE:
                if(points.length != 1){
                    throw new IncorrectDrawDimensionsException("A circle is drawn from one point, and a radius sent as a point.");
                }   
                grid = shapeGen.drawCircle(character, points[0], points[1].x, grid);
                break;
            case L:
            case LINE:
                if(points.length != 2){
                    throw new IncorrectDrawDimensionsException("A line is drawn from two points.");
                }   
                grid = shapeGen.drawLine(character, points[0], points[1], grid);
                break;
            default:
                throw new IncorrectDrawDimensionsException("Invalid shape.");
        }
    }
    
    public void save(){
        fileSaver.write(grid, fileName);
    }
    
    public void setSize(int size){
        this.height = size;
        this.width = size;
        graftOntoNewSize();
    }

    public void setHeight(int height) {
        this.height = height;
        graftOntoNewSize();
    }

    public void setWidth(int width) {
        this.width = width;
        graftOntoNewSize();
    }

    private void graftOntoNewSize() {
        char[][] tempGrid = grid.clone();
        grid = new char[height][width];
        
        initializeGrid();
        
        int iteratingHeight = 0;
        int iteratingWidth = 0;
        if(tempGrid.length > 0 && grid.length > 0){
            iteratingHeight = (tempGrid.length > grid.length) ? grid.length : tempGrid.length;
            if(tempGrid[0].length > 0 && grid[0].length > 0){
                iteratingWidth = (tempGrid[0].length > grid[0].length) ? grid[0].length : tempGrid[0].length;
            }
        }
        for (int i = 0; i < iteratingHeight; i++) {
            System.arraycopy(tempGrid[i], 0, grid[i], 0, iteratingWidth);
        }
    }

    public void clear() {
        grid = new char[height][width];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = MapDefaults.NULL.getValue();
            }
        }
    }
}
