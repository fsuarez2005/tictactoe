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
    private char player1 = 'x';
    private char player2 = 'o';
    private int fontSize = 72;
    private char currentPlayer = player1;

    public List<WinningMove> winners;
    
    class WinningMove {
        public Coordinates<Integer> xy1;
        public Coordinates<Integer> xy2;
        public Coordinates<Integer> xy3;

        public WinningMove(Coordinates<Integer> xy1, Coordinates<Integer> xy2, Coordinates<Integer> xy3) {
            this.xy1 = xy1;
            this.xy2 = xy2;
            this.xy3 = xy3;
        }
        /*
        public WinningMove(Integer x1, Integer y1, Integer x2, Integer y2, Integer x3, Integer y3) {
            try {
                this.xy1 = new Coordinates<>(x1,y1);
                this.xy2 = new Coordinates<>(x2,y2);
                this.xy3 = new Coordinates<>(x3,y3);
            } catch (InvalidCoordinateValue ex) {
                Logger.getLogger(TicTacToeBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }

    
    /*
    public int[][] winnerArray = new int[][]{
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };*/
    
    public void initializeWinningMoves() {
        this.winners = new ArrayList<>();
        
        
        try {
            this.winners.add(new WinningMove(new Coordinates<>(0,0),new Coordinates<>(0,1),new Coordinates<>(0,2)));
            
        } catch (InvalidCoordinateValue ex) {
            Logger.getLogger(TicTacToeBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Gets first char of String else returns elseChar.
     *
     * Utility function
     * @param src
     * @param elseChar
     * @return
     */
    private char getFirstOrElse(String src, char elseChar) {
        if (src.length() > 0) {
            return src.charAt(0);
        } else {
            return elseChar;
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

    
    /** Checks the board to see if WinningMove is exists
     * 
     * @param w
     * @return 
     */
    public boolean doesWinningMoveExist(WinningMove w) {
        return false;
    }
    
    
    /** TODO: rewrite with winner List
     * Check for cell combinations to determine winner.
     *
     * @return
     */
    public char checkForWinner() {
        char winner = ' ';

        
        
        
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

    /**
     * Switches between player 1 and player 2
     *
     */
    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }

    }


    public TicTacToeBoard() {
        super(3,3);
    }

   

}
