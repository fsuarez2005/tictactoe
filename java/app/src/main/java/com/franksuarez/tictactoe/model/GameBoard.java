/** Generic rectangular game board with cells occupied by tokens.
 *
 * Classes:
 * * Board
 * * Token
 * * Cell
 */
package com.franksuarez.tictactoe.model;

import com.franksuarez.tictactoe.misc.Coordinates;
import com.franksuarez.tictactoe.misc.PairingFunction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Generic Game board.
 * 
 * --------------------------------------------
 *        |        |       |       |       |
 *    2   |        |       |       |       | 
 *        |        |       |       |       | 
 * --------------------------------------------
 *        |        |       |       |       |
 *    1   |        |       |       |       | 
 *        |        |       |       |       | 
 * --------------------------------------------
 *        |        |       |       |       |
 *    0   |        |       |       |       | 
 *        |        |       |       |       | 
 * --------------------------------------------
 *  Y     |        |       |       |       |
 *      X |    0   |   1   |   2   |   3   |
 *        |        |       |       |       |
 * 
 * 
 * 
 * @author franksuarez
 * @param <T> Game token type
 */
public class GameBoard<T> {
    private int height;     // Y-axis
    private int width;      // X-axis
    
    
    private Map<Integer, Cell<T>> cells; // maps Hopcroft Ullman Pairing value to Cell
    
    
    private BiFunction<Integer,Integer,Integer> pairingFunction; // need to experiment with other pairing functions
    
    public GameBoard(int height, int width) {
        this();
        this.height = height;
        this.width = width;
    }
    public GameBoard() {
        this.pairingFunction = (t, u) -> PairingFunction.szudzikPairingFunction(t, u);
    }

    public final int getHeight() {
        return height;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    public final int getWidth() {
        return width;
    }

    public final void setWidth(int width) {
        this.width = width;
    }

    public final BiFunction<Integer, Integer, Integer> getPairingFunction() {
        return pairingFunction;
    }

    public final void setPairingFunction(BiFunction<Integer, Integer, Integer> pairingFunction) {
        this.pairingFunction = pairingFunction;
    }
    
    
    public final int calculateKey(int x, int y) {
        return this.pairingFunction.apply(x, y);
    }
    
    public final void listCells() {
        System.out.println("Cell List:");
        for (var c: this.cells.keySet()) {
            System.out.printf("%d: %s\n", c,this.cells.get(c));
        }
    }
    
    
    /** Initialize cells for board.
     *
     * 
     *
     * @param defaultValue
     */
    public final void initialize(T defaultValue) {
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
     * @param x
     * @param y
     * @return 
     */
    public final T getToken(int x, int y) throws NullPointerException {
        int key = calculateKey(x, y);
        
        var currentCell = this.cells.get(key);
        if (currentCell == null) {
            listCells();
            throw new NullPointerException();
        }
        
        var token = currentCell.getToken();
        
        return token;
    }
    
    public final void setToken(int x, int y, T token) throws NullPointerException {
        int key = calculateKey(x, y);
        
        var currentCell = this.cells.get(key);
        if (currentCell == null) {
            listCells();
            throw new NullPointerException();
        }
        
        currentCell.setToken(token);
    }
    
    /**
     *
     * @param x
     * @param y
     * @return
     */
    public final Cell<T> getCell(int x, int y) {
        int key = calculateKey(x, y);
        return this.cells.get(key);
    }
    
    // TODO: getCell(Coordinates)
    public Cell<T> getCell(Coordinates<Integer> coords) {
        return null;
    }
    
    
    /**
     *
     * @param x
     * @param y
     * @param c
     */
    public final void setCell(int x, int y, Cell<T> c) {
        int key = calculateKey(x,y);
        this.cells.put(key,c);
    }
    
    /**
     *
     * @param <U>
     */
    public final class Cell<U> {
        private U token;
        
        public Cell(U token) {
            this.token = token;
        }
        
        public Cell() {
            // token is not initialized
            // token could have a default value or null
        }
        
        public U getToken() {
            return token;
        }
        
        public void setToken(U token) {
            this.token = token;
        }
        
        @Override
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
