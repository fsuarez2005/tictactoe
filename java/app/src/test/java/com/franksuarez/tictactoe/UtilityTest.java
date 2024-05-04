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
        int k = 0;
        int expResult = 0;
        int result = Utility.triangularNumber(k);
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
        int k1 = 2;
        int k2 = 5;
        int expResult = 33;
        int result = Utility.cantorFunction(k1, k2);
        System.out.printf("result = %d\n",result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of InvertCantorFunction method, of class Utility.
     */
    @Test
    public void testInvertCantorFunction() {
        System.out.println("InvertCantorFunction");
        int z = 33;
        Utility.Coordinates expResult = new Utility.Coordinates(2,5);
        Utility.Coordinates result = Utility.InvertCantorFunction(z);
        
        System.out.printf("expected = %s\n",expResult.toString());
        System.out.printf("result = %s\n",result.toString());

        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
