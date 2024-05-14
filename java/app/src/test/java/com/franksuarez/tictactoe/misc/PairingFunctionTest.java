/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.franksuarez.tictactoe.misc;

import com.franksuarez.tictactoe.exceptions.InvalidCoordinateValue;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PairingFunctionTest {
    
    public PairingFunctionTest() {
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
     * Test of triangularNumber method, of class PairingFunction.
     */
    @Test
    public void testTriangularNumber() {
        System.out.println("triangularNumber");
        int k = 0;
        int expResult = 0;
        int result = PairingFunction.triangularNumber(k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hopcroftUllmanPairing method, of class PairingFunction.
     */
    @Test
    public void testHopcroftUllmanPairing() {
        System.out.println("hopcroftUllmanPairing");
        int i = 1;
        int j = 2;
        int expResult = 8;
        int result = PairingFunction.hopcroftUllmanPairing(i, j);
        assertEquals(expResult, result);
        

// TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of inverseHopcroftUllmanPairing method, of class PairingFunction.
     */
    @Test
    public void testInverseHopcroftUllmanPairing() throws Exception {
        System.out.println("inverseHopcroftUllmanPairing");
        int h = 0;
        Coordinates<Integer> expResult = null;
        Coordinates<Integer> result = PairingFunction.inverseHopcroftUllmanPairing(h);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantorFunction method, of class PairingFunction.
     */
    @Test
    public void testCantorFunction() {
        System.out.println("cantorFunction");
        double k1 = 0.0;
        double k2 = 0.0;
        double expResult = 0.0;
        double result = PairingFunction.cantorFunction(k1, k2);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of szudzikPairingFunction method, of class PairingFunction.
     */
    @Test
    public void testSzudzikPairingFunction() {
        System.out.println("szudzikPairingFunction");
        int x = 4;
        int y = 2;
        int expResult = 22;
        int result = PairingFunction.szudzikPairingFunction(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of inverseSzudzikPairingFunction method, of class PairingFunction.
     */
    @Test
    public void testInverseSzudzikPairingFunction() {
        System.out.println("inverseSzudzikPairingFunction");
        int z = 14;
        Coordinates<Integer> expected = null;
        
        try {
            expected = new Coordinates<>(3,2);
        } catch (InvalidCoordinateValue ex) {
            Logger.getLogger(PairingFunctionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Coordinates<Integer> result = PairingFunction.inverseSzudzikPairingFunction(z);

        if (expected != null) {
            assert(expected.equals(result));
            
        } else {
            fail("null");
        }

        
    }
    
}
