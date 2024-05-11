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
import java.util.function.BiFunction;

/**
 * Generic Game board.
 *
 * @author franksuarez
 * @param <T> Game token type
 */
public class GameBoardXY<T> {
    private int height;
    private int width;
    
    // maps Hopcroft Ullman Pairing value to Cell
    private Map<Integer, Cell<T>> cells;
    
    // need to experiment with other pairing functions
    private BiFunction<Integer,Integer,Integer> pairingFunction;
    
    public GameBoardXY(int height, int width) {
        this();
        this.height = height;
        this.width = width;
    }
    public GameBoardXY() {
        this.pairingFunction = (t, u) -> PairingFunction.szudzikPairingFunction(t, u);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public BiFunction<Integer, Integer, Integer> getPairingFunction() {
        return pairingFunction;
    }

    public void setPairingFunction(BiFunction<Integer, Integer, Integer> pairingFunction) {
        this.pairingFunction = pairingFunction;
    }
    
    public int calculateKey(int h, int w) {
        return this.pairingFunction.apply(h, w);
    }
    
    
    public void listCells() {
        System.out.println("Cell List:");
        for (var c: this.cells.keySet()) {
            System.out.printf("%d: %s\n", c,this.cells.get(c));
        }
    }
    
    
    /** Initialize cells for board.
     *
     * TODO: create Map instance for this.cells.
     *
     * @param defaultValue
     */
    public void initialize(T defaultValue) {
        System.out.println("initialize()");
        this.cells = new HashMap<>();

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                int key = calculateKey(h, w);
                if (this.cells.containsKey(key)) {
                    throw new RuntimeException("Duplicate key!!");
                }
                
                this.cells.put(key, new Cell<T>(defaultValue));
            }
        }
    }

    /**
     * 
     * @param h
     * @param w
     * @return 
     */
    public T getToken(int h, int w) throws NullPointerException {
        int key = calculateKey(h, w);
        
        var currentCell = this.cells.get(key);
        if (currentCell == null) {
            listCells();
            throw new NullPointerException();
        }
        
        var token = currentCell.getToken();
        
        return token;
    }

    public void setToken(int h, int w, T token) throws NullPointerException {
        int key = calculateKey(h,w);
        
        var currentCell = this.cells.get(key);
        if (currentCell == null) {
            listCells();
            throw new NullPointerException();
        }
        
        currentCell.setToken(token);
    }
    
    /**
     *
     * @param h
     * @param w
     * @return
     */
    public Cell<T> getCell(int h, int w) {
        int key = calculateKey(h,w);
        return this.cells.get(key);
    }
    
    /**
     *
     * @param h
     * @param w
     * @param c
     */
    public void setCell(int h, int w, Cell<T> c) {
        int key = calculateKey(h,w);
        this.cells.put(key,c);
    }
    
    /**
     *
     * @param <U>
     */
    public class Cell<U> {
        private U token;
        
        public Cell(U token) {
            this.token = token;
        }
        
        // _token is not initialized
        // _token could have a default value or null
        public Cell() {
        }
        
        public U getToken() {
            return token;
        }
        
        public void setToken(U token) {
            this.token = token;
        }
        
        public String toString() {
            return token.toString();
        }
    }
    
    /** Returns token values of multiple locations, usually in a straight line.
     * 
     * TODO: GameBoard.getLine
     */
    //public void getLine() {}
    
    
    
    
    
    
}
