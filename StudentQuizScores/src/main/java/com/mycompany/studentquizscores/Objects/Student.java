package com.mycompany.studentquizscores.Objects;

public class Student {
    private String name;

    public Student() {
        this.name = "N/A";
    }
    
    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
