/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.franksuarez.tictactoe.misc;

import com.franksuarez.tictactoe.exceptions.InvalidCoordinateValue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testSetX() throws InvalidCoordinateValue {
        Coordinates<Integer> c;
        c = new Coordinates<Integer>();
        c.setX(1);
        
        
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
     * Test of hashCode method, of class Coordinates.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Coordinates instance = new Coordinates();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of with method, of class Coordinates.
     */
    @Test
    public void testWith() {
        System.out.println("with");
        Object x = null;
        Object y = null;
        Coordinates expResult = null;
        Coordinates result = Coordinates.with(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
