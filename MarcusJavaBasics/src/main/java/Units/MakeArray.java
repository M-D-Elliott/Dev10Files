package Units;

import java.util.Random;

public class MakeArray {
    public void run() {
//        singleDim();
//        doubleDim();
//        tripleDim();
        jaggedDoubleDim();
    }
    
    public static String getRandomName() {
        Random random = new Random();
        String[] names = {
            "Jerry",
            "Winnie",
            "Smith",
            "Mitch",
            "Johnny",
            "Tim",
            "Kim",
            "Dave",
            "Lem",
            "Germ",
            "Ken",
            "Linda",
        };
        return names[random.nextInt(names.length)];
    }
    
    public void jaggedDoubleDim() {
        String[][] names = new String[5][];
        names[0] = new String[]{"Anne", "Jojo", "Dio"};
        names[2] = new String[]{"Erina", "Zepelli", "Avdol"};
        for(String[] row : names) {
            if(row == null) {
                continue;
            }
            for(String name : row) {
                System.out.println(name);
            }
        }
    }
    
    public void tripleDim() {
        String[][][] names = new String[3][3][3];
        for(String[][] plane : names) {
            for(String[] row : plane) {
                for(int i=0;i<row.length;i++) {
                    row[i] = getRandomName();
                    System.out.println(row[i]);
                }
            }
        }
    }
    
    public void doubleDim() {
//        100 slots, all null to start.
//        String[][] names = new String[10][10];
        String[][] names = new String[3][3];
        for(String[] row : names) {
            // with enhanced for cannot assign variable, because it is just the value;
            for(int i=0;i<row.length;i++) {
                row[i] = getRandomName();
                System.out.println(row[i]);
            }
        }
    }
    
    public void singleDim() {
        int[] numbers = {2, 4, 6, 8, 10};
        System.out.println("len: " + numbers.length);
        int res = sum(new int[]{2, 4, 6, 8, 10});
        System.out.println("sum: " + res);
    }
    
    private int[] make(int n) {
        Random random = new Random();
        int[] res = new int[n];
        for(int i=0;i<res.length;i++){
            res[i] = random.nextInt(100000) - 50000;
        }
        return res;
    }
    
    private int sum(int[] nums) {
        int res = 0;
        for(int n : nums) {
            res += n;
        }
        return res;
    }
}
