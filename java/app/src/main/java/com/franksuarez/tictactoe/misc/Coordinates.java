/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.misc;

import exceptions.InvalidCoordinateValue;
import java.util.Objects;
import java.util.function.Predicate;

/** 
 *
 * @author franksuarez
 * @param <T>
 */
public class Coordinates<T extends Number> {
    private T x;
    private T y;
    
    // returns true if valid value for coordinate
    private Predicate<T> xGuard;
    
    // returns true if valid value for coordinate
    private Predicate<T> yGuard;

    public Coordinates() {
        initializeGuards();
    }

    public Coordinates(T x, T y) throws InvalidCoordinateValue {
        super();

        setX(x);
        setY(y);
    }

    public T getY() {
        return y;
    }
    
    public void setY(T y) throws InvalidCoordinateValue {
        // only set if passes y guard
        if (yGuard.test(y)) {
            this.y = y;
        } else {
            throw new InvalidCoordinateValue("Invalid Y value");
        }
    }

    public T getX() {
        return this.x;
    }

    public void setX(T x) throws InvalidCoordinateValue {
        if (xGuard.test(x)) {
            this.x = x;
        } else {
            throw new InvalidCoordinateValue("Invalid X value");
        }
    }

    private void initializeGuards() {
        this.xGuard = (x) -> {
            return true;
        };
        this.yGuard = (y) -> {
            return true;
        };
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }

        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }

        // fixes issue with unchecked cast
        Coordinates coord = this.getClass().cast(o);

        // TODO: unchecked cast
        //Coordinates<T> coord = (Coordinates<T>) o;
        return Objects.equals(x, coord.x)
                && Objects.equals(y, coord.y);
    }

    // TODO: verify Coordinates.hashCode works
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.x);
        hash = 83 * hash + Objects.hashCode(this.y);
        return hash;
    }

}
