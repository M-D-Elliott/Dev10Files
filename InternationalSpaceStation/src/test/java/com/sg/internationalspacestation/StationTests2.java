/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.internationalspacestation;

import com.sg.internationalspacestation.dto.VisitorType;
import com.sg.internationalspacestation.dto.SpaceStation2;
import com.sg.internationalspacestation.dto.Visitor;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StationTests2 {
    
    SpaceStation2 station = new SpaceStation2();
    
    public StationTests2() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void addVisitorValidAstronautReturnsTrue(){
        LocalDate now = LocalDate.now();
        Visitor visitor = new Visitor(now, VisitorType.ASTRONAUT);
        visitor.setEnd(now.plusDays(3));
        visitor.setType(VisitorType.ASTRONAUT);
        assertTrue(station.add(visitor));
    }
    @Test
    public void addVisitorValidEndIsNullVisitorReturnsTrue(){
        LocalDate now = LocalDate.now();
        Visitor visitor = new Visitor(now, VisitorType.ASTRONAUT);
        visitor.setStart(now);
        visitor.setEnd(null);
        visitor.setType(VisitorType.ASTRONAUT);
        assertTrue(station.add(visitor));
    }

    @Test
    public void addVisitorGivenNullVisitorReturnFalse(){
        assertFalse(station.add(null));
    }
    @Test
    public void addVisitorGivenVisitorWithStartOnlyReturnTrue(){
        LocalDate now = LocalDate.now();
        Visitor visitor = new Visitor(now, VisitorType.ASTRONAUT);
        visitor.setStart(now);
        visitor.setType(VisitorType.ASTRONAUT);
        assertTrue(station.add(visitor));
    }
    @Test
    public void addVisitorValidAstronautBeyondMaxReturnsTrue(){
        LocalDate now = LocalDate.now();
        Visitor visitor = new Visitor(now, VisitorType.ASTRONAUT);
        visitor.setEnd(now.plusDays(3));
        visitor.setType(VisitorType.ASTRONAUT);
        for (int i = 0; i <= station.getMaxAstronauts(); i++) {
            assertTrue(station.add(visitor));
        }
        assertFalse(station.add(visitor));
    }
    @Test
    public void addVisitorValidAstronautBeyondMaxForTomorrowReturnsFalse(){
        LocalDate now = LocalDate.now();
//        Visitor visitor = new Visitor(now, VisitorType.ASTRONAUT);
//        visitor.setEnd(now.plusDays(3));
//        visitor.setType(VisitorType.ASTRONAUT);
//        for (int i = 0; i < station.getMaxAstronauts(); i++) {
//            assertTrue(station.add(visitor));
//        }
//        assertFalse(station.add(visitor));
        LocalDate tomorrow = now.plusDays(1);
        Visitor visitor = new Visitor(tomorrow, VisitorType.ASTRONAUT);
        visitor.setEnd(tomorrow.plusDays(1));
        visitor.setType(VisitorType.ASTRONAUT);
        for (int i = 0; i <= station.getMaxAstronauts(); i++) {
            assertTrue(station.add(visitor));
        }
        assertFalse(station.add(visitor));
    }
    @Test
    public void addVisitorValidAstronautBeyondMaxForTodayThenTomorrowReturnsFalse(){
        LocalDate now = LocalDate.now();
        Visitor visitor = new Visitor(now, VisitorType.ASTRONAUT);
        visitor.setEnd(now.plusDays(3));
        visitor.setType(VisitorType.ASTRONAUT);
        for (int i = 0; i <= station.getMaxAstronauts(); i++) {
            assertTrue(station.add(visitor));
        }
        LocalDate tomorrow = now.plusDays(1);
        visitor = new Visitor(tomorrow, VisitorType.ASTRONAUT);
        visitor.setEnd(tomorrow.plusDays(3));
        visitor.setType(VisitorType.ASTRONAUT);
        assertFalse(station.add(visitor));
    }
}
