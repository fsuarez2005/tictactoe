/** Generic rectangular game board with cells occupied by tokens.
 *
 * TODO: Generalize this class for any dimension.
 * TODO: remove need for pairing function
 *
 *
 */
package com.franksuarez.tictactoe.model;

import com.franksuarez.tictactoe.misc.Coordinates;

import java.util.ArrayList;
import java.util.List;

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

    // TODO: builder
    public static class Builder<U> {

        private GameBoard<U> instance = new GameBoard<>();

        public GameBoard<U> setHeight(int height) {
            instance.height = height;
            return instance;
        }

        public GameBoard<U> setWidth(int width) {
            instance.width = width;
            return instance;
        }
    }

    protected int height = 0;     // Y-axis
    protected int width = 0;      // X-axis
    protected T defaultValue;

    private List<List<Cell<T>>> cells;

    public GameBoard(int height, int width, T defaultValue) {
        this();
        this.height = height;
        this.width = width;
        this.defaultValue = defaultValue;
    }

    public GameBoard() {
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    protected void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    /**
     * Initialize cells for board.
     * TODO: move to constructor
     *
     * @return
     */
    public GameBoard<T> initialize() {
        this.cells = new ArrayList<>();

        for (int x = 0; x < this.width; x++) {
            List<Cell<T>> yList = new ArrayList<>();
            for (int y = 0; y < this.height; y++) {
                yList.add(new Cell<T>(defaultValue));
            }

            this.cells.add(yList);
        }
        return this;
    }




    public void reset() {
        initialize();
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
        Cell<T> currentCell = this.getCell(x, y);
        if (currentCell == null) {
            throw new NullPointerException();
        }
        currentCell.setToken(token);
    }

    public T getToken(Coordinates<Integer> coords) {
        return getToken(coords.getX(), coords.getY());
    }

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

        Cell<T> cell = null;
        try {
            cell = this.cells.get(x).get(y);
        } catch (Exception ex) {
            throw new IndexOutOfBoundsException(String.format("Tried to access (%d,%d).%n", x, y));
        }

        return cell;
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

        this.cells.get(x).remove(y);
        this.cells.get(x).add(y, c);
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
