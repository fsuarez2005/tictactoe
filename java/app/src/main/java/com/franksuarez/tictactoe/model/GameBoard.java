/** Generic rectangular game board with cells occupied by tokens.
 *
 * Classes:
 * * Board
 * * Token
 * * Cell
 */
package com.franksuarez.tictactoe.model;

import com.franksuarez.tictactoe.misc.PairingFunction;
import java.util.HashMap;
import java.util.Map;

/**
 * Generic Game board.
 *
 * @author franksuarez
 * @param <T> Game token type
 */
public class GameBoard<T> {
    private int height;
    private int width;

    // maps Hopcroft Ullman Pairing value to Cell
    private Map<Integer, Cell<T>> cells;
    
    public GameBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public GameBoard() {
        
    }
    /**
     * Initialize cells for board.
     *
     * TODO: create Map instance for this.cells.
     *
     */
    public void initialize() {
        this.cells = new HashMap<>();

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                int key = PairingFunction.hopcroftUllmanPairing(h, w);
                this.cells.put(key, new Cell<T>());
            }
        }
    }

    public T token(int h, int w) {
        int key = PairingFunction.hopcroftUllmanPairing(h, w);
        return this.cells.get(key).token();
    }

    public void token(int h, int w, T token) {
        int key = PairingFunction.hopcroftUllmanPairing(h, w);
        this.cells.get(key).token(token);
    }
    
    public class Cell<U> {
        
        private U _token;
        
        public Cell(U _token) {
            this._token = _token;
        }
        
        // _token is not initialized
        // _token could have a default value or null
        public Cell() {
        }
        
        public U token() {
            return _token;
        }
        
        public void token(U _token) {
            this._token = _token;
        }
    }

    
    /** Returns token values of multiple locations, usually in a straight line.
     * 
     * 
     * 
     * TODO: GameBoard.getLine
     * 
     * 
     * 
     * 
     */
    public void getLine() {}
    
    
    
}
