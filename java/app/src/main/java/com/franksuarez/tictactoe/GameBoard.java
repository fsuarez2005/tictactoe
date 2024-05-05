/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe;

import java.util.HashMap;

/** Tic-Tac-Toe gameboard.
 *
 * @author franksuarez
 */
public class GameBoard {
    private int width = 3;
    private int height = 3;
    
    // Maps 2D location to index
    private HashMap<Integer,Integer> locationIndexMap;
    private HashMap<Integer,Integer> indexLocationMap;
    
    /**
     * Returns a hash of two integers using a pairing function.
     * 
     * 
     * @see https://en.wikipedia.org/wiki/Pairing_function
     */
    private double locationHash(int x,int y) {
        // use Cantor pairing function
        return Utility.hopcroftUllmanPairing(x, y);
    }
    
    
    
    
    
    public void placeToken(int x, int y, char token) {    
    }
    
    public char getToken(int x, int y) {
        return ' ';
    }
    
    
    
    
    
    
    
}
