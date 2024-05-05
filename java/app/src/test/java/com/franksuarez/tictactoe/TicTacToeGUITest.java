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
public class TicTacToeGUITest {

    public TicTacToeGUITest() {
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
    public void testWinnerArray() {
        System.out.println("testWinnerArray");
        TicTacToeGUI t = new TicTacToeGUI();
        System.out.printf("int[0][0] = %d\n", t.winnerArray[0][1]);

    }

    /**
     * Test of checkLocationForWinner method, of class TicTacToeGUI.
     */
    @Test
    public void testCheckLocationForWinner() {
        System.out.println("checkLocationForWinner");
        int a = 0;
        int b = 0;
        int c = 0;
        char player = ' ';
        TicTacToeGUI instance = new TicTacToeGUI();
        boolean expResult = false;
        boolean result = instance.checkLocationForWinner(a, b, c, player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkForWinner method, of class TicTacToeGUI.
     */
    @Test
    public void testCheckForWinner() {
        System.out.println("checkForWinner");
        TicTacToeGUI instance = new TicTacToeGUI();
        char expResult = ' ';
        char result = instance.checkForWinner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of switchPlayer method, of class TicTacToeGUI.
     */
    @Test
    public void testSwitchPlayer() {
        System.out.println("switchPlayer");
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.switchPlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeButtonList method, of class TicTacToeGUI.
     */
    @Test
    public void testInitializeButtonList() {
        System.out.println("initializeButtonList");
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.initializeButtonList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addComponents method, of class TicTacToeGUI.
     */
    @Test
    public void testAddComponents() {
        System.out.println("addComponents");
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.addComponents();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of configureWindow method, of class TicTacToeGUI.
     */
    @Test
    public void testConfigureWindow() {
        System.out.println("configureWindow");
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.configureWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class TicTacToeGUI.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
