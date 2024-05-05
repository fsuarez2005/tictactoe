/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.franksuarez.tictactoe;

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
public class UtilityTest {
    
    public UtilityTest() {
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
     * Test of triangularNumber method, of class Utility.
     */
    @Test
    public void testTriangularNumber() {
        System.out.println("triangularNumber");
        double k = 0.0;
        double expResult = 0.0;
        double result = Utility.triangularNumber(k);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hopcroftUllmanPairing method, of class Utility.
     */
    @Test
    public void testHopcroftUllmanPairing() {
        System.out.println("hopcroftUllmanPairing");
        double i = 5;
        double j = 5;
        double expResult = 41;
        double result = Utility.hopcroftUllmanPairing(i, j);
        System.out.printf("result = %f\n",result);
        
        
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of cantorFunction method, of class Utility.
     */
    @Test
    public void testCantorFunction() {
        System.out.println("cantorFunction");
        double k1 = 4.0;
        double k2 = 3.0;
        double expResult = 31.0;
        double result = Utility.cantorFunction(k1, k2);
        System.out.printf("result = %f\n",result);
        assertEquals(expResult, result, 0);
        
    }


    /**
     * Test of inverseHopcroftUllmanPairing method, of class Utility.
     */
    @Test
    public void testInverseHopcroftUllmanPairing() {
        System.out.println("inverseHopcroftUllmanPairing");
        double h = 32.0;
        Utility.Coordinates expResult = new Utility.Coordinates(4.0,5.0);
        Utility.Coordinates result = Utility.inverseHopcroftUllmanPairing(h);
        assert(result.equals(expResult));
    }
    
}
