/** Generic rectangular game board with cells occupied by tokens.
 *
 * TODO: Generalize this class for any dimension.
 * TODO: remove need for pairing function
 *
 *
 */
package com.franksuarez.tictactoe.model;

import com.franksuarez.tictactoe.misc.Coordinates;
import com.franksuarez.tictactoe.misc.PairingFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Generic Game board.
 *
 * X is horizontal and increases left to right. Y is vertical and increases from
 * bottom to top.
 *
 * @author franksuarez
 * @param <T> Game token type
 */
public class GameBoard<T> {

    
    
    
    private int height = 0;     // Y-axis
    private int width = 0;      // X-axis
    private T defaultValue;

    // TODO: change key to Coordinate
    private Map<Integer, Cell<T>> cells; // maps pairing value to Cell

    // NEW
    private List<List<Cell<T>>> cellsList;

    // TODO: remove
    private BiFunction<Integer, Integer, Integer> pairingFunction = (t, u) -> PairingFunction.szudzikPairingFunction(t, u); // need to experiment with other pairing functions

    public GameBoard(int height, int width, T defaultValue) {
        this();
        this.height = height;
        this.width = width;
        this.defaultValue = defaultValue;
    }

    public GameBoard() {}

    // DONE
    public T getDefaultValue() {
        return defaultValue;
    }

    // DONE
    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    // DONE
    public final int getHeight() {
        return height;
    }

    // DONE
    public final void setHeight(int height) {
        this.height = height;
    }

    // DONE
    public final int getWidth() {
        return width;
    }

    // DONE
    public final void setWidth(int width) {
        this.width = width;
    }

    // TODO: update
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
    // TODO: test
    public void initialize() {
        this.cellsList = new ArrayList<>();

        for (int x = 0; x < this.width; x++) {
            List yList = new ArrayList<T>();
            for (int y = 0; y < this.height; y++) {
                // TODO: unchecked
                yList.add(new Cell<T>());
            }

            this.cellsList.add(new ArrayList<>());
        }

    }

    // DONE
    public void reset() {
        resetCells();
    }

    // DONE
    public void resetCells() {
        this.cells.forEach((i, c) -> {
            c.setToken(defaultValue);
        });
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    // TODO: remove
    public T getToken(int x, int y) {
        return this.getCell(x, y).getToken();
    }

    /**
     *
     * @param x
     * @param y
     * @param token
     * @return
     * @throws NullPointerException
     */
    // TODO: remove
    public void setToken(int x, int y, T token) {
        var currentCell = this.getCell(x, y);
        if (currentCell == null) {
            throw new NullPointerException();
        }
        currentCell.setToken(token);
    }

    // DONE
    public T getToken(Coordinates<Integer> coords) {
        return getToken(coords.getX(), coords.getY());
    }

    // DONE
    public void setToken(Coordinates<Integer> coords, T token) {
        setToken(coords.getX(), coords.getY(), token);
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    // TODO: update
    public Cell<T> getCell(int x, int y) {
        // throw except if index out of bounds

        return this.cellsList.get(x).get(y);
    }

    /**
     *
     * @param coords
     * @return
     */
    // TODO: remove
    public Cell<T> getCell(Coordinates<Integer> coords) {
        return this.getCell(coords.getX(), coords.getY());
    }

    /**
     *
     * @param x
     * @param y
     * @param c
     * @return
     */
    // TODO: remove
    // TODO: test
    public void setCell(int x, int y, Cell<T> c) {
        // guard 

        this.cellsList.get(x).remove(y);
        this.cellsList.get(x).add(y, c);
    }

    /**
     *
     * @param coords
     * @param c
     * @return
     */
    // TODO: update
    public void setCell(Coordinates<Integer> coords, Cell<T> c) {
        this.setCell(coords.getX(), coords.getY(), c);
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
}
