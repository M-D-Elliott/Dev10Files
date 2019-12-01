package com.mycompany.studentquizscores.Objects;

import java.util.List;
import java.util.Map;

public class StudentMap {
    private Map<Student, List<Integer>> studentMap;

    public StudentMap(Map<Student, List<Integer>> studentMap) {
        this.studentMap = studentMap;
    }

    public Map<Student, List<Integer>> getStudentMap() {
        return studentMap;
    }
}
