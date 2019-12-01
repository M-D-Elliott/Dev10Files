package com.mycompany.studentquizscores.Application;

import Utils.RandomUtils;
import com.mycompany.studentquizscores.Objects.Student;
import com.mycompany.studentquizscores.UserIO.UserIO;
import com.mycompany.studentquizscores.UserIO.UserIOImplementation;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    
    private int addXScores = 5;
    
    private HashMap<Student, ArrayList<Integer>> allStudents;
    private UserIO io;

    public Application() {
        io = new UserIOImplementation();
    }
    
    public void start(){
        allStudents = setUp();
        
        findStudentsWithHighestScores(allStudents);
        findStudentsWithLowestScores(allStudents);
    }
    
    public HashMap<Student, ArrayList<Integer>> setUp(){
        return new HashMap<Student, ArrayList<Integer>>(){{
            put(new Student("Johnny"), new ArrayList<>(){{
                for (int i = 0; i < addXScores; i++) {
                    add(RandomUtils.getInt());
                }
            }});
            put(new Student("Dave"), new ArrayList<>(){{
                for (int i = 0; i < addXScores; i++) {
                    add(RandomUtils.getInt());
                }
            }});
            put(new Student("Bill"), new ArrayList<>(){{
                for (int i = 0; i < addXScores; i++) {
                    add(RandomUtils.getInt());
                }
            }});
            put(new Student("Mary"), new ArrayList<>(){{
                for (int i = 0; i < addXScores; i++) {
                    add(RandomUtils.getInt());
                }
            }});
            put(new Student("Phillis"), new ArrayList<>(){{
                for (int i = 0; i < addXScores; i++) {
                    add(RandomUtils.getInt());
                }
            }});
            put(new Student("Eggs"), new ArrayList<>(){{
                for (int i = 0; i < addXScores; i++) {
                    add(RandomUtils.getInt());
                }
            }});
            put(new Student("Bobby"), new ArrayList<>(){{
                for (int i = 0; i < addXScores; i++) {
                    add(RandomUtils.getInt());
                }
            }});
            put(new Student("Jake"), new ArrayList<>(){{
                for (int i = 0; i < addXScores; i++) {
                    add(RandomUtils.getInt());
                }
            }});
            put(new Student("Plo"), new ArrayList<>(){{
                for (int i = 0; i < addXScores; i++) {
                    add(RandomUtils.getInt());
                }
            }});
        }};
    }

    private void findStudentsWithHighestScores(HashMap<Student, ArrayList<Integer>> allStudents) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void findStudentsWithLowestScores(HashMap<Student, ArrayList<Integer>> allStudents) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
