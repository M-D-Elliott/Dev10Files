package exercises3;

public class Rectangle extends Shape {
    
    private double side1;
    private double side2;
    
    public Rectangle(int side){
        this(side, side);
    }
    
    public Rectangle(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
        calcArea(side1, side2);
        calcPerimeter(side1, side2);
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
        area = side1 * side2;
    }

    protected void calcPerimeter(int side1, int side2) {
        perimeter = side1 * 2 + side2 * 2;
    }
}
