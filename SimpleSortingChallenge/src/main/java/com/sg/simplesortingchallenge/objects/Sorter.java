package com.sg.simplesortingchallenge.objects;

import java.util.Arrays;

public class Sorter {
    
    public void run(){
        int[] unsorted = new int[]{9, 77, 44, 54, 46, 95, 65, 17, 22, 38, 99, 200};
        
        
        int[] m = unsorted.clone();
        cocktailSort(m);
        System.out.println("Unsorted: " + Arrays.toString(unsorted));
        System.out.println("Bubble: " + Arrays.toString(m));
        
        System.out.println("");
        
        int[] mergeSorted = unsorted.clone();
        mergeSort(mergeSorted);
        System.out.println("Unsorted: " + Arrays.toString(unsorted));
        System.out.println("Merge: " + Arrays.toString(mergeSorted));
    }
    
    public int[] bubbleSortAttempt(int... inArray){
        if(inArray.length > 0){
            for (int index = 1; index < inArray.length;index++) {
                int prevValue = inArray[index - 1];
                int currentValue = inArray[index];
                if(prevValue < currentValue){
                    inArray[index] = currentValue;
                } else {
                    inArray[index - 1] = currentValue;
                    inArray[index] = prevValue;
                }
            }
        }
        return inArray;
    }
   
    public int[] bubbleSort(int... args){
        int n = args.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(args[j] > args[j+1]){
                    int temp = args[j];
                    args[j] = args[j+1];
                    args[j+1] = temp;
                }
            }
        }
        return args;
    }
    
    public static boolean swap(int[] numbers, int i, int j) {
    int temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
    return true;
}

    static boolean leftSide(int[] numbers, int i, int j) {
        boolean swapped = false;
        for (int k = i; k < j; k++)
            if (numbers[k] > numbers[k + 1])
                swapped = swap(numbers, k, k + 1);
        return swapped;
    }

    static boolean rightSide(int[] numbers, int i, int j) {
        boolean swapped = false;
        for (int k = j; k > i; k--)
            if (numbers[k] < numbers[k - 1])
                swapped = swap(numbers, k, k - 1);
        return swapped;
    }

    public static void cocktailSort(int[] numbers) {
        boolean swapped = true;
        int i = -1;
        int j = numbers.length - 1;

        while (i++ < j && swapped)
            if (swapped = leftSide(numbers, i, j))
                swapped = rightSide(numbers, i, j--);
    }
    
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 =  r - m; 

        /* create temp arrays */
        int [] L = new int[n1];
        int [] R = new int[n2]; 

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray 
        j = 0; // Initial index of second subarray 
        k = l; // Initial index of merged subarray 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 

        /* Copy the remaining elements of L[], if there 
           are any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 

        /* Copy the remaining elements of R[], if there 
           are any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 

    /* l is for left index and r is right index of the 
       sub-array of arr to be sorted */
    void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Same as (l+r)/2, but avoids overflow for 
            // large l and h 
            int m = l+(r-l)/2; 

            // Sort first and second halves 
            mergeSort(arr, l, m); 
            mergeSort(arr, m+1, r); 

            merge(arr, l, m, r); 
        } 
    } 
    
    void mergeSort(int... arr){
        mergeSort(arr, 0, arr.length - 1);
    }
}
