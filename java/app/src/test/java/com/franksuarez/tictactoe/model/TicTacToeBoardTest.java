/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.franksuarez.tictactoe.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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
