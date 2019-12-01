package Utils;

public final class RandomUtils {
    private RandomUtils() {
    }
    
    public static final String getItem(String s) {
        int len = s.length();
        int location = getInt(len);
        return String.valueOf(s.toCharArray()[location]);
    }
    
    public static final Object getItem(Object[] obj){
        int len = obj.length;
        int location = getInt(len);
        return obj[location];
    }
    
    public static final int getInt() {
        return getInt(100);
    }
    
    public static final int getInt(int max) {
        return getInt(1, max);
    }
    
    public static final int getInt(int min, int max) {
       return (int)((Math.random()* (max - min))) + min;
    }
}
