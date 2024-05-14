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
    private int noPlayer = 0;
    private int player1 = 1;
    private int player2 = 2;

    private char player1Token = 'x';
    private char player2Token = 'o';
    private char noPlayerToken = ' ';
    private boolean winnerExists = false;
    private int winningPlayer = 0;
    private int currentPlayer = 1;
    //private char currentPlayerToken = player1Token;
    private List<WinningMove> winningMoves = new ArrayList<>();

    /**
     * Coordinates of winning moves.
     *
     * Needs to be converted to Coordinate objects using
     * importWinnerArray(int[][][])
     */
    public final int[][][] winnerData = new int[][][]{
        {{0, 0}, {0, 0}, {0, 0}},
        {{1, 0}, {1, 1}, {1, 2}},
        {{2, 0}, {2, 1}, {2, 2}},
        {{0, 0}, {1, 0}, {2, 0}},
        {{0, 1}, {1, 1}, {2, 1}},
        {{0, 2}, {1, 2}, {2, 2}},
        {{0, 0}, {1, 1}, {2, 2}},
        {{2, 0}, {1, 1}, {0, 2}}
    };

    public TicTacToeBoard() {
        super.setHeight(3);
        super.setWidth(3);
        
        importWinnerArray(winnerData);
    }

    /**
     *
     * @return
     */
    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Validates and sets current player.
     *
     * TODO: throw InvalidPlayer or InvalidParameter
     *
     * @param currentPlayer
     */
    public void setCurrentPlayer(int currentPlayer) {
        if (currentPlayer != 0 || currentPlayer != 1 || currentPlayer != 2) {
            // should throw InvalidPlayer

            throw new IllegalArgumentException("Player should be 0, 1, or 2.");
        }

        this.currentPlayer = currentPlayer;
    }

    /**
     * Returns the char token for the current player.
     *
     * @return
     */
    public char getCurrentPlayerToken() {
        return getPlayerToken(currentPlayer);
    }

    /**
     * Returns the current winning player.
     *
     * Need to
     *
     * @return
     */
    public int getWinningPlayer() {
        if (!this.winnerExists) {
            // need to tell caller there is no winner
            return 0;
        }

        return this.winningPlayer;
    }

    public void setWinningPlayer(int player) {
        // TODO: guard clause

        this.winningPlayer = player;
    }

    /**
     * TODO: remove hard-coded values for players
     * @param player
     * @return
     */
    public char getPlayerToken(int player) {
        char output = noPlayerToken;

        switch (player) {
            case 0 -> {
                output = noPlayerToken;
            }
            case 1 -> {
                output = player1Token;
            }
            case 2 -> {
                output = player2Token;
            }
            default -> {
                output = noPlayerToken;
            }
        }
        
        return output;
    }

    /**
     * Parses winnerArray and creates List of WinningMove winners.
     *
     * @param winnerArray
     */
    public void importWinnerArray(int[][][] winnerArray) {
        // winnerArray is an array of triple of coordinate pairs

        // TODO: validate format of winnerArray
        for (int[][] triple : winnerArray) {

            try {
                // triple has three coordinate pairs
                // triple[0][0] -> x
                // triple[0][1] -> y

                WinningMove move = new WinningMove(
                        new Coordinates<Integer>(triple[0][0], triple[0][1]),
                        new Coordinates<Integer>(triple[1][0], triple[1][1]),
                        new Coordinates<Integer>(triple[2][0], triple[2][1])
                );

                this.winningMoves.add(move);

            } catch (InvalidCoordinateValue ex) {
                Logger.getLogger(TicTacToeBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Checks each cell to see if they have matching player indicators.
     *
     * @param player
     * @return
     */
    public boolean checkLocationForWinner(WinningMove move, int player) {
        // check each Coordinate of WinningMove for player
        // if all three cells == player, then winner
        // cell1 == player && cell2 == player && cell3 == player

        char playerToken = getPlayerToken(player);

        // TODO: could inline
        return getToken(move.xy1) == playerToken
                && getToken(move.xy2) == playerToken
                && getToken(move.xy3) == playerToken; // winner
    }

    /**
     *
     * @return
     */
    public boolean isThereAWinner() {
        return this.winnerExists;
    }

    /**
     * TODO: rewrite with winner List Check for cell combinations to determine
     * winner.
     *
     * @return
     */
    public void checkForWinner() {
        // iterate through each player
        for (int p : new int[]{1, 2}) {
            System.out.printf("Winner checking for player %d%n",p);
            // loop through winners
            for (WinningMove wm : winningMoves) {
                System.out.printf("Checking move %s%n",wm.toString());
                
                
                boolean foundWinner = checkLocationForWinner(wm, p);
                if (foundWinner) {
                    this.winnerExists = true;
                    this.winningPlayer = p;
                    return;
                }
            }
        }
    }

    /**
     * Switches between player 1 and player 2.
     */
    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public void makeMove(int x, int y) {
        //check Cell for move
        char existingMove = this.getToken(x, y);
        
        
        
        if (existingMove == getPlayerToken(noPlayer)) {
            System.out.printf("Player %d moved at (%d,%d)%n",getCurrentPlayer(),x,y);
            this.setToken(x, y, this.getCurrentPlayerToken());

        } else {
            System.out.println("Move exists.");
            // move exists
            // throw Exception
        }

    }

    @Override
    public String toString() {
        return String.format(
                "%c | %c | %c%n"
                + "%c | %c | %c%n"
                + "%c | %c | %c%n",
                
                getToken(0, 2),
                getToken(1,2),
                getToken(2,2),
                getToken(0,1),
                getToken(1,1),
                getToken(2,1),
                getToken(0,0),
                getToken(1,0),
                getToken(2,0));
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

}
