package com.sg.compression;

import algo.CompressionSort;
import algo.Holder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<List<Character>> outer = new ArrayList<List<Character>>();
        List<Character> inner1 = new ArrayList<Character>();
        inner1.add('#');
        inner1.add('_');
        inner1.add('_');
        inner1.add('_');
        inner1.add('_');
        inner1.add('_');
        inner1.add('#');
        inner1.add('#');
        inner1.add('#');
        inner1.add('#');
        inner1.add('#');
        List<Character> inner2 = new ArrayList<Character>();
        outer.add(inner1);
        inner2.add('#');
        inner2.add('_');
        inner2.add('#');
        inner2.add('#');
        inner2.add('#');
        inner2.add('#');
        inner2.add('#');
        inner2.add('_');
        inner2.add('_');
        inner2.add('_');
        inner2.add('_');
        inner2.add('_');
        inner2.add('_');
        outer.add(inner2);
        List<Character> inner3 = new ArrayList<Character>();
        outer.add(inner1);
        inner3.add('#');
        inner3.add('_');
        inner3.add('#');
        inner3.add('#');
        inner3.add('#');
        inner3.add('#');
        inner3.add('#');
        inner3.add('_');
        inner3.add('#');
        inner3.add('#');
        inner3.add('#');
        inner3.add('_');
        inner3.add('_');
        outer.add(inner3);
        CompressionSort sorter = new CompressionSort();
        
        List<Holder> holderArray = sorter.compress(outer);
        
        for (Holder holder : holderArray) {
            System.out.println(holder);
        }
        
        List<List<Character>> twoDArray = sorter.decompress(holderArray);
        
        for (List<Character> line : twoDArray) {
            System.out.println(line.toString());
        }
    }
}
