package Challenges;

import java.util.Arrays;

public class MergeSortExample {
    public void run() {
        int[] one = {1,44,22,6,7,4,3};
        printArr(one);
        int[] two = {6,45,43,77,22,11,33,0,99,50,100};
        printArr(two);
        
        Arrays.sort(one);Arrays.sort(two);
        
        int[] res = merge(one, two);
        printArr(res);
    }

    // if you know the arrays are sorted.
    private int[] merge(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;
        
        int[] res = new int[lenA + lenB];
        
        int indexA = 0;
        int indexB = 0;
        int indexResult = 0;
        
        while (indexA < lenA && indexB < lenB) {
            // first check if off end of array.
            if(indexA >= lenA) {
                res[indexResult] = b[indexB];
                indexB++;
            } else if(indexB >= lenB) {
                res[indexResult] = a[indexA];
                indexA++;
            } else {
                if(a[indexA] < b[indexB]){
                    res[indexResult] = a[indexA];
                    indexA++;
                } else {
                    res[indexResult] = b[indexB];
                    indexB++;
                }
            }
            indexResult++;
        }
        
        return res;
    }
    
    private void printArr(int[] a){
        for (int n : a) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
