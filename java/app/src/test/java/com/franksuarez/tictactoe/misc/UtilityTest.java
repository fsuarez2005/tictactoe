/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.franksuarez.tictactoe.misc;

import com.franksuarez.tictactoe.misc.Utility.Cons;
import java.lang.reflect.TypeVariable;
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
        int k = 0;
        int expResult = 0;
        int result = Utility.triangularNumber(k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hopcroftUllmanPairing method, of class Utility.
     */
    @Test
    public void testHopcroftUllmanPairing() {
        System.out.println("hopcroftUllmanPairing");
        int i = 0;
        int j = 0;
        int expResult = 0;
        int result = Utility.hopcroftUllmanPairing(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inverseHopcroftUllmanPairing method, of class Utility.
     */
    @Test
    public void testInverseHopcroftUllmanPairing() {
        System.out.println("inverseHopcroftUllmanPairing");
        double h = 0.0;
        Utility.Coordinates expResult = null;
        Utility.Coordinates result = Utility.inverseHopcroftUllmanPairing(h);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantorFunction method, of class Utility.
     */
    @Test
    public void testCantorFunction() {
        System.out.println("cantorFunction");
        double k1 = 0.0;
        double k2 = 0.0;
        double expResult = 0.0;
        double result = Utility.cantorFunction(k1, k2);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
}
