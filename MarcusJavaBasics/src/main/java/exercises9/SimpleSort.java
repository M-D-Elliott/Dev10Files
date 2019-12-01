package exercises9;

import java.util.Arrays;

public class SimpleSort {
    public void run () {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        System.out.println(Arrays.toString(sortedMerge(firstHalf, secondHalf)));
    }
        public static int[] sortedMerge(int a[], int b[]) {
        int[] res = new int[24];
        int aLen = a.length;
        int bLen = b.length;
        // Concatenate two arrays 
        int i = 0, j = 0, k = 0; 
        while (i < aLen) { 
            res[k] = a[i]; 
            i++; 
            k++; 
        } 
          
        while (j < bLen) { 
            res[k] = b[j]; 
            j++; 
            k++; 
        } 
      
        // sorting the res array
        Arrays.sort(res);
        return res;
    }
}
