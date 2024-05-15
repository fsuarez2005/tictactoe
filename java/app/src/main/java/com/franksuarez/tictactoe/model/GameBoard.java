/** Generic rectangular game board with cells occupied by tokens.
 *
 * TODO: Generalize this class for any dimension.
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
 * -------------------------------------------- | | | | | 2 | | | | | | | | | |
 * -------------------------------------------- | | | | | 1 | | | | | | | | | |
 * -------------------------------------------- | | | | | 0 | | | | | | | | | |
 * -------------------------------------------- Y | | | | | X | 0 | 1 | 2 | 3 |
 * | | | | |
 *
 *
 *
 * @author franksuarez
 * @param <T> Game token type
 */
public class GameBoard<T> {
    private int height = 0;     // Y-axis
    private int width = 0;      // X-axis
    private T defaultValue;

    
    
    
    private Map<Integer, Cell<T>> cells; // maps Hopcroft Ullman Pairing value to Cell

    private BiFunction<Integer, Integer, Integer> pairingFunction = (t, u) -> PairingFunction.szudzikPairingFunction(t, u); // need to experiment with other pairing functions

    
    
    public GameBoard(int height, int width, T defaultValue) {
        this();
        this.height = height;
        this.width = width;
        this.defaultValue = defaultValue;
        
    }

    public GameBoard() {}
    public T getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
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
        for (var c : this.cells.keySet()) {
            System.out.printf("%d: %s\n", c, this.cells.get(c));
        }
    }

    /**
     * Initialize cells for board.
     *
     *
     *
     */
    public void initialize() {
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
    
    public void reset() {
        resetCells();
    }
    
    
    public void resetCells() {
        this.cells.forEach((i,c) -> {
            c.setToken(defaultValue);
        });
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

    public final GameBoard<T> setToken(int x, int y, T token) throws NullPointerException {
        int key = calculateKey(x, y);

        var currentCell = this.cells.get(key);
        if (currentCell == null) {
            listCells();
            throw new NullPointerException();
        }

        currentCell.setToken(token);
        return this;
    }

    public T getToken(Coordinates<Integer> coords) {
        return getToken(coords.getX(), coords.getY());
    }
    
    public GameBoard<T> setToken(Coordinates<Integer> coords,T token) {
        return setToken(coords.getX(), coords.getY(), token);
    }
    
    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Cell<T> getCell(int x, int y) {
        int key = calculateKey(x, y);
        return this.cells.get(key);
    }

    
    public Cell<T> getCell(Coordinates<Integer> coords) {
        int key = calculateKey(coords.getX(), coords.getY());

        return this.cells.get(key);
    }

    /**
     *
     * @param x
     * @param y
     * @param c
     * @return 
     */
    public GameBoard<T> setCell(int x, int y, Cell<T> c) {
        int key = calculateKey(x, y);
        this.cells.put(key, c);
        return this;
    }
    
    
    public GameBoard<T> setCell(Coordinates<Integer> coords, Cell<T> c) {
        int key = calculateKey(coords.getX(), coords.getY());
        this.cells.put(key, c);
        return this;
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

    /**
     * Returns token values of multiple locations, usually in a straight line.
     *
     * TODO: GameBoard.getLine
     */
    //public void getLine() {}
}
