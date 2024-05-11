/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.franksuarez.tictactoe.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franksuarez
 */
public class GameBoardTest {
    private GameBoard<Character> board;
    private int height = 3;
    private int width = 3;
    
    public GameBoardTest() {}
    
    @BeforeAll
    public static void setUpClass() {}
    
    @AfterAll
    public static void tearDownClass() {}
    
    @BeforeEach
    public void setUp() {
        this.board = new GameBoard<>(3,3);
        this.board.initialize(' ');
    }
    
    @AfterEach
    public void tearDown() {}

    @Test
    public void testInitialize() {
        System.out.printf("[TEST] %s\n", Thread.currentThread().getStackTrace()[1].getMethodName());
        
        this.board.listCells();
    }
    
    /**
     * Test of getToken method, of class GameBoard.
     */
    @Test
    public void testGetToken() {
        System.out.printf("[TEST] %s\n", Thread.currentThread().getStackTrace()[1].getMethodName());
        
        int h = 0;
        int w = 0;
        
        // expect default value?
        Character expResult = ' ';
        Character result = this.board.getToken(h, w);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setToken method, of class GameBoard.
     */
    @Test
    public void testSetToken() {
        System.out.println("[TEST] setToken");
        int h = 0;
        int w = 0;
        
        Character value = 'x';
        this.board.setToken(h, w, value);
        
        assertEquals(this.board.getToken(h, w), value);
        
    }
    
}
