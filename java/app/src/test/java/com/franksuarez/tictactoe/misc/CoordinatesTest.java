/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.franksuarez.tictactoe.misc;

import com.franksuarez.tictactoe.exceptions.InvalidCoordinateValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franksuarez
 */
public class CoordinatesTest {
    
    public CoordinatesTest() {
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

    /**
     * Test of getY method, of class Coordinates.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Coordinates instance = new Coordinates();
        Number expResult = null;
        Number result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Coordinates.
     */
    @Test
    public void testSetY() throws Exception {
        System.out.println("setY");
        Number y = null;
        Coordinates instance = new Coordinates();
        Coordinates expResult = null;
        Coordinates result = instance.setY(y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Coordinates.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Coordinates instance = new Coordinates();
        Number expResult = null;
        Number result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Coordinates.
     */
    @Test
    public void testSetX() throws Exception {
        System.out.println("setX");
        Number x = null;
        Coordinates instance = new Coordinates();
        Coordinates expResult = null;
        Coordinates result = instance.setX(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Coordinates.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Coordinates instance = new Coordinates();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of szudzikPairingFunction method, of class Coordinates.
     */
    @Test
    public void testSzudzikPairingFunction() {
        System.out.println("szudzikPairingFunction");
        Coordinates instance = new Coordinates();
        int expResult = 0;
        int result = instance.szudzikPairingFunction();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Coordinates.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Coordinates instance = new Coordinates();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testHashCode() throws InvalidCoordinateValue {
        System.out.println("hashCode");
        Coordinates c1 = new Coordinates<>(1,1);
        Coordinates c2 = new Coordinates<>(1,1);
        
        System.out.printf("c1.hashCode() = %d%n",c1.hashCode());
        System.out.printf("c2.hashCode() = %d%n",c2.hashCode());
        System.out.printf("%s%n", String.valueOf(c1.equals(c2)));
        
        
        
        
    }
    
}
