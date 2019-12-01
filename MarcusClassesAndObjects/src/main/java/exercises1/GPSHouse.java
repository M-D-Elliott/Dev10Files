package exercises1;

public class GPSHouse {
    private int latitude;
    private int longitude;

    public GPSHouse(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int[] getLocation() {
        return new int[]{latitude, longitude};
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
    
    
}
