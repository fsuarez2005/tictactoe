/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.franksuarez.tictactoe.model;

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
public class TicTacToeBoardTest {
    
    public TicTacToeBoardTest() {
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
     * Test of importWinnerArray method, of class TicTacToeBoard.
     */
    @Test
    public void testImportWinnerArray() {
        System.out.println("importWinnerArray");
        TicTacToeBoard t = new TicTacToeBoard();
        t.importWinnerArray(t.winnerData);
        
        
    }

    /**
     * Test of initializeWinningMoves method, of class TicTacToeBoard.
     */
    @Test
    public void testInitializeWinningMoves() {
        System.out.println("initializeWinningMoves");
        TicTacToeBoard instance = new TicTacToeBoard();
        instance.initializeWinningMoves();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLocationForWinner method, of class TicTacToeBoard.
     */
    @Test
    public void testCheckLocationForWinner() {
        System.out.println("checkLocationForWinner");
        int a = 0;
        int b = 0;
        int c = 0;
        char player = ' ';
        TicTacToeBoard instance = new TicTacToeBoard();
        boolean expResult = false;
        boolean result = instance.checkLocationForWinner(a, b, c, player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doesWinningMoveExist method, of class TicTacToeBoard.
     */
    @Test
    public void testDoesWinningMoveExist() {
        System.out.println("doesWinningMoveExist");
        TicTacToeBoard.WinningMove w = null;
        TicTacToeBoard instance = new TicTacToeBoard();
        boolean expResult = false;
        boolean result = instance.doesWinningMoveExist(w);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkForWinner method, of class TicTacToeBoard.
     */
    @Test
    public void testCheckForWinner() {
        System.out.println("checkForWinner");
        TicTacToeBoard instance = new TicTacToeBoard();
        char expResult = ' ';
        char result = instance.checkForWinner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of switchPlayer method, of class TicTacToeBoard.
     */
    @Test
    public void testSwitchPlayer() {
        System.out.println("switchPlayer");
        TicTacToeBoard instance = new TicTacToeBoard();
        instance.switchPlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
