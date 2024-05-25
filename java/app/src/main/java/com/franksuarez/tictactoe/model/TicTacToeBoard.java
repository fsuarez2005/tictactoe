/**
 * 
 * 
 * 
 * 
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

    public enum Player {
        NOPLAYER,
        PLAYER1,
        PLAYER2
        
    }
    
    
    // TODO: change to enum
//    private int noPlayer = 0;
//    private int player1 = 1;
//    private int player2 = 2;
    
    private Player noPlayer = Player.NOPLAYER;
    private Player player1 = Player.PLAYER1;
    private Player player2 = Player.PLAYER2;
    
    

    private char player1Token = 'X';
    private char player2Token = 'O';
    private char noPlayerToken = ' ';
    private boolean winnerExists = false;
    private Player winningPlayer = noPlayer;
    private Player currentPlayer = player1;
    //private char currentPlayerToken = player1Token;

    private final List<WinningMove> winningMoves = new ArrayList<>();

    /**
     * Coordinates of winning moves.
     *
     * Needs to be converted to Coordinate objects using
     * importWinnerArray(int[][][])
     */
    public final int[][][] winnerData = new int[][][]{
        // horizontal
        {{0, 0}, {1, 0}, {2, 0}},
        {{0, 1}, {1, 1}, {2, 1}},
        {{0, 2}, {1, 2}, {2, 2}},
        // vertical
        {{0, 0}, {0, 1}, {0, 2}},
        {{1, 0}, {1, 1}, {1, 2}},
        {{2, 0}, {2, 1}, {2, 2}},
        // diagonal
        {{0, 0}, {1, 1}, {2, 2}},
        {{2, 0}, {1, 1}, {0, 2}}
    };

    public TicTacToeBoard() {
        super.setHeight(3);
        super.setWidth(3);
        super.setDefaultValue(' ');
        importWinnerArray(winnerData);
    }

    @Override
    public void initialize() {
        super.initialize();
        
        // should only need initialization at beginning
        // these should be correct already
//        this.winnerExists = false;
//        this.winningPlayer = noPlayer;
//        this.currentPlayer = player1;
    }

    @Override
    public void reset() {
        super.reset();
        this.winnerExists = false;
        this.winningPlayer = noPlayer;
        this.currentPlayer = player1;
    }
    
    /**
     *
     * @return
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Validates and sets current player.
     *
     * TODO: throw InvalidPlayer or InvalidParameter
     *
     * @param currentPlayer
     */
    public void setCurrentPlayer(Player currentPlayer) {
        if (currentPlayer != Player.NOPLAYER || currentPlayer != Player.PLAYER1 || currentPlayer != Player.PLAYER2) {
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
    public Player getWinningPlayer() {
        if (!this.winnerExists) {
            // need to tell caller there is no winner
            return Player.NOPLAYER;
        }

        return this.winningPlayer;
    }

    public void setWinningPlayer(Player player) {
        if (player != noPlayer && player != player1 && player != player2) {
            throw new IllegalArgumentException();
        }

        this.winningPlayer = player;
    }

    /**
     * TODO: remove hard-coded values for players
     *
     * @param player
     * @return
     */
    public char getPlayerToken(Player player) {
        char output = noPlayerToken;

        if (player == noPlayer) {
            output = noPlayerToken;
        } else if (player == player1) {
            output = player1Token;
        } else if (player == player2) {
            output = player2Token;
        } else {
            output = noPlayerToken;
            throw new IllegalArgumentException();
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
    private boolean checkLocationForWinner(WinningMove move, Player player) {
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
    public boolean getWinnerExists() {
        return this.winnerExists;
    }

    public void setWinnerExists(boolean winnerExists) {
        this.winnerExists = winnerExists;
    }

    /**
     * TODO: rewrite with winner List Check for cell combinations to determine
     * winner.
     *
     */
    public void checkForWinner() {
        // iterate through each player
        for (Player p : new Player[]{Player.PLAYER1, Player.PLAYER2}) {
            
            // loop through winners
            for (WinningMove wm : winningMoves) {
            

                boolean foundWinner = checkLocationForWinner(wm, p);
                if (foundWinner) {

                    setWinnerExists(true);

                    setWinningPlayer(p);

                    
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
            
            this.setToken(x, y, this.getCurrentPlayerToken());

        } 

    }

    @Override
    public String toString() {
        return String.format(
                "%c | %c | %c%n"
                + "%c | %c | %c%n"
                + "%c | %c | %c%n",
                getToken(0, 2),
                getToken(1, 2),
                getToken(2, 2),
                getToken(0, 1),
                getToken(1, 1),
                getToken(2, 1),
                getToken(0, 0),
                getToken(1, 0),
                getToken(2, 0));
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
