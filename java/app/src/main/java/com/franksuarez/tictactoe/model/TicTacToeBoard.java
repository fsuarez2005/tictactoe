/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.model;

import com.franksuarez.tictactoe.exceptions.InvalidCoordinateValue;
import com.franksuarez.tictactoe.misc.Coordinates;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franksuarez
 */
public class TicTacToeBoard extends GameBoard<Character> {
    private char player1Token = 'x';
    private char player2Token = 'o';
    
    private boolean winnerExists = false;
    private int winningPlayerNumber = 0;
    
    
    // TODO: have player tokens rely on the current player number
    private char[] playerTokens = new char[] {
        'x',
        'o'
    };
    
    private int fontSize = 72;
    private int currentPlayer = 1;
    private char currentPlayerToken = player1Token;

    private List<WinningMove> winningMoves = new ArrayList<>();

    public int getCurrentPlayer() {
        return this.currentPlayer;        
    }
    
    public char getCurrentPlayerToken() {
        return this.currentPlayerToken;
    }
    
    class WinningMove {
        public Coordinates<Integer> xy1;
        public Coordinates<Integer> xy2;
        public Coordinates<Integer> xy3;

        public WinningMove(Coordinates<Integer> xy1, Coordinates<Integer> xy2, Coordinates<Integer> xy3) {
            this.xy1 = xy1;
            this.xy2 = xy2;
            this.xy3 = xy3;
        }
        
        @Override
        public String toString() {
            return String.format("(%d,%d),(%d,%d),(%d,%d)",
                    xy1.getX(),
                    xy1.getY(),
                    xy2.getX(),
                    xy2.getY(),
                    xy3.getX(),
                    xy3.getY()
            );
        }
    }

    /**
     *
     */
    public int[][][] winnerData = new int[][][]{
        {{0,0},{0,0},{0,0}},
        {{1,0},{1,1},{1,2}},
        {{2,0},{2,1},{2,2}},
        
        {{0,0},{1,0},{2,0}},
        {{0,1},{1,1},{2,1}},
        {{0,2},{1,2},{2,2}},
        
        {{0,0},{1,1},{2,2}},
        {{2,0},{1,1},{0,2}}
    };
    
    /**
     *
     * @param winnerArray
     */
    public void importWinnerArray(int[][][] winnerArray) {
        // winnerArray is an array of triple of coordinate pairs
        
        
        for (int[][] triple: winnerArray) {
            
            try {
                // triple has three coordinate pairs
                // triple[0][0] -> x
                // triple[0][1] -> y
                
                WinningMove move = new WinningMove(
                        new Coordinates<Integer>(triple[0][0],triple[0][1]),
                        new Coordinates<Integer>(triple[1][0],triple[1][1]),
                        new Coordinates<Integer>(triple[2][0],triple[2][1])
                );
                
                this.winningMoves.add(move);
                
            } catch (InvalidCoordinateValue ex) {
                Logger.getLogger(TicTacToeBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    /** TODO: checkLocationForWinner stub
     * Checks each cell to see if they have matching player indicators.
     *
     * Problem: * If Button label is empty, there is no first char so an index
     * exception will occur.
     *
     * @param a first cell
     * @param b second cell
     * @param c third cell
     * @param player
     * @return
     */
    public boolean checkLocationForWinner(int a, int b, int c, char player) {
        
        return false;

    }
    
    /**
     *
     * @return
     */
    public boolean isThereAWinner() {
        return false;
    }
    
    /** TODO: rewrite with winner List
     * Check for cell combinations to determine winner.
     *
     * @return
     */
    public char checkForWinner() {
        char winner = ' ';

        // loop through winners
        for (WinningMove wm: winningMoves) {
            
        }
        
        /*for (int[] i : winnerArray) {
            boolean player1won = checkLocationForWinner(i[0], i[1], i[2], player1);
            boolean player2won = checkLocationForWinner(i[0], i[1], i[2], player2);
            if (player1won) {
                winner = player1;
                break;
            } else if (player2won) {
                winner = player2;
                break;
            }

        }*/
        return winner;

    }

    /** Switches between player 1 and player 2.
     */
    public void switchPlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
            currentPlayerToken = player2Token;
        } else {
            currentPlayer = 1;
            currentPlayerToken = player1Token;
        }
    }


    public TicTacToeBoard() {
        super.setHeight(3);
        super.setWidth(3);
    }

   

}
