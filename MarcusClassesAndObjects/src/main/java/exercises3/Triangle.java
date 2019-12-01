package exercises3;

import Utils.IntUtils;

public class Triangle extends Shape {
    private int[] sides;
    
    private int height;
    private int base;

    public Triangle(int side1, int side2, int side3, int height, int base) {
        this.sides = new int[]{side1, side2, side3};
        this.height = height;
        this.base = base;
        calcHeight();
        calcBase();
        calcArea();
        calcPerimeter();
    }

    @Override
    public int getArea(){
        return (int)area;
    }
    @Override
    public int getPerimeter(){
        return (int)perimeter;
    }

    private void calcArea() {
        area = height * base / 2;
    }

    private void calcPerimeter() {
        perimeter = IntUtils.sum(sides);
    }

    private void calcBase() {
        base = sides[0];
    }

    private void calcHeight() {
        height = sides[0];
    }
}
