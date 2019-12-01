package exercises1;

public class AirplaneSimulator {
    private int x;
    private int y;
    private int speed;
    
    private int direction;
    
    private String type;

    public AirplaneSimulator(int x, int y, int speed, int direction, String type) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.type = type;
    }
    
    public int getArrivalInSeconds(){
        int velocity = (x * y) - direction;
        return speed / velocity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
