package com.sg.challenge.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class challenge {
    private static final Random RAND = new Random();
    
    public void run() {
        List<Integer> list = new ArrayList<>(){{
//            add(-50);
//            add(1);
//            add(2);
//            add(3);
//            add(-2000);
//            add(40);
//            add(10);
//            add(-1);
//            add(100);
        }};
        
        list = addN(new ArrayList<>(), 5);
        
        list.stream().forEach(i -> {
            System.out.println(i);
        });
        System.out.println("");
        System.out.println("min: " + findMin(list, 0, 0));
        System.out.println("");
        System.out.println("total: " + sum(list, 0, 0));
    }
    
    public static ArrayList<Integer> addN(ArrayList<Integer> l, int n) {
        if (l.size() >= n) {
            return l;
        }
        Integer m = RAND.nextInt(5000);
        l.add(m);
        return addN(l, n);
    }
    
    public int findMin(List<Integer> list, int min, int i){
        
        if(i >= list.size()){
            return min;
        }
        
        int currentValue = list.get(i);
        
        if(currentValue < min){
            min = currentValue;
        }
        i++;
        return findMin(list, min, i);
    }
    
    public int sum(List<Integer> list, int total, int i){
        if(i >= list.size()){
            return total;
        }

        total += list.get(i);
        i++;
        return sum(list, total, i);
    }
}
