package exercises3;

import Utils.IntUtils;

public class Circle extends Shape {

    public static final int PI = 314159;
    
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    
    @Override
    public int getArea(){
        return (int)area;
    }
    @Override
    public int getPerimeter(){
        return (int)perimeter;
    }

    protected void calcArea(int side1, int side2) {
        area = getPi() * radius * radius;
    }

    protected void calcPerimeter(int side1, int side2) {
        perimeter = 2 * getPi() * radius;
    }
    
    protected double getPi(){
        return PI / IntUtils.countDigits(PI);
    }
}
