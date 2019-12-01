package exercises1;

public class CarVG {
    private int x;
    private int y;
    
    private String type;
    
    private int speed;
    
    private int gallonsLeft;
    private int milesPerGallon;
    
    private int hitPoints;
    private int defense;

    public CarVG(int x, int y, String type, int speed, int gallonsLeft, int milesPerGallon, int hitPoints, int defense) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.speed = speed;
        this.gallonsLeft = gallonsLeft;
        this.milesPerGallon = milesPerGallon;
        this.hitPoints = hitPoints;
        this.defense = defense;
    }
    
    public int calcArrivalTime(){
        return (x * y) / speed;
    }
    
    public boolean takeDamage(int damage){
        int reducedDamage = calcReducedDamage(damage);
        
        if(reducedDamage > 0){
            hitPoints -= reducedDamage;
            return true;
        }
        return false;
    }
    
    private int calcReducedDamage(int damage){
        return damage - defense;
    }
    
    public int milesLeftToTravel(){
        return milesPerGallon / gallonsLeft;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGallonsLeft() {
        return gallonsLeft;
    }

    public void setGallonsLeft(int gallonsLeft) {
        this.gallonsLeft = gallonsLeft;
    }

    public int getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(int milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    
}
