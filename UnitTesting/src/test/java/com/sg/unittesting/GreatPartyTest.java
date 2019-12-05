package com.sg.unittesting;

import com.sg.unittesting.firstwave.GreatParty;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GreatPartyTest {

    GreatParty party = new GreatParty();
    
    public GreatPartyTest() {
    }

    @Test
    public void test30False() {
        assertFalse(party.greatParty(30, false));
    }

    @Test
    public void test50False() {
        assertTrue(party.greatParty(50, false));
    }
    
    @Test
    public void test50True() {
        assertTrue(party.greatParty(50, false));
    }
    
    @Test
    public void test10True() {
        assertFalse(party.greatParty(10, true));
    }
    @Test
    public void test39True() {
        assertFalse(party.greatParty(39, true));
    }
    
    @Test
    public void test39False() {
        assertFalse(party.greatParty(39, false));
    }
    
    @Test
    public void test40True() {
        assertTrue(party.greatParty(40, true));
    }
    
    @Test
    public void test40False() {
        assertTrue(party.greatParty(40, false));
    }
    
    @Test
    public void test41True() {
        assertTrue(party.greatParty(41, true));
    }
    
    @Test
    public void test41False() {
        assertTrue(party.greatParty(41, false));
    }
    
    @Test
    public void test59True() {
        assertTrue(party.greatParty(59, true));
    }
    
    @Test
    public void test59False() {
        assertTrue(party.greatParty(59, false));
    }
    
    @Test
    public void test60True() {
        assertTrue(party.greatParty(60, true));
    }
    
    @Test
    public void test60False() {
        assertTrue(party.greatParty(60, false));
    }
    @Test
    public void test61True() {
        assertTrue(party.greatParty(61, true));
    }
    
    @Test
    public void test61False() {
        assertFalse(party.greatParty(61, false));
    }
    
    @Test
    public void test80True() {
        assertTrue(party.greatParty(80, true));
    }
    
    @Test
    public void test80False() {
        assertFalse(party.greatParty(80, false));
    }

}