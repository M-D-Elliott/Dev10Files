package exercises1;

public class GridHouse {
    private int xCoord;
    private int yCoord;
    private int zCoord;

    public GridHouse(int xCoord, int yCoord, int zCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
    }

    public int[] getLocation(){
        return new int[]{xCoord, yCoord, zCoord};
    }
    
    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getzCoord() {
        return zCoord;
    }

    public void setzCoord(int zCoord) {
        this.zCoord = zCoord;
    }
    
    
}
