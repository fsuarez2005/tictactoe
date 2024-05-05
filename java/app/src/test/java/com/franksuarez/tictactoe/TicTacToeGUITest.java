/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.franksuarez.tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
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

    /**
     * Test of testDialog method, of class TicTacToeGUI.
     */
    @Test
    public void testTestDialog() {
        System.out.println("testDialog");
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.testDialog();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of windowOpened method, of class TicTacToeGUI.
     */
    @Test
    public void testWindowOpened() {
        System.out.println("windowOpened");
        WindowEvent e = null;
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.windowOpened(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowClosing method, of class TicTacToeGUI.
     */
    @Test
    public void testWindowClosing() {
        System.out.println("windowClosing");
        WindowEvent e = null;
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.windowClosing(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowClosed method, of class TicTacToeGUI.
     */
    @Test
    public void testWindowClosed() {
        System.out.println("windowClosed");
        WindowEvent e = null;
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.windowClosed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowIconified method, of class TicTacToeGUI.
     */
    @Test
    public void testWindowIconified() {
        System.out.println("windowIconified");
        WindowEvent e = null;
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.windowIconified(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowDeiconified method, of class TicTacToeGUI.
     */
    @Test
    public void testWindowDeiconified() {
        System.out.println("windowDeiconified");
        WindowEvent e = null;
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.windowDeiconified(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowActivated method, of class TicTacToeGUI.
     */
    @Test
    public void testWindowActivated() {
        System.out.println("windowActivated");
        WindowEvent e = null;
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.windowActivated(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowDeactivated method, of class TicTacToeGUI.
     */
    @Test
    public void testWindowDeactivated() {
        System.out.println("windowDeactivated");
        WindowEvent e = null;
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.windowDeactivated(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class TicTacToeGUI.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        TicTacToeGUI instance = new TicTacToeGUI();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
