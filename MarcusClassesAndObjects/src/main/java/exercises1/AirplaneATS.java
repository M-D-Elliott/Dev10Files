package exercises1;

public class AirplaneATS {
    private int latitude;
    private int longitude;
    private int speed;
    
    private int direction;
    
    private String type;
    private String pilot;

    public AirplaneATS(int latitude, int longitude, int speed, int direction, String type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.direction = direction;
        this.type = type;
    }
    
    public int getArrivalInSeconds(){
        int velocity = (latitude * longitude) - direction;
        return speed / velocity;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
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

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }
}
