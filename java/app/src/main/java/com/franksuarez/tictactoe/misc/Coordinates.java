/** Coordinates class.
 * 
 * TODO: Generalize this class for any dimension.
 * 
 */


package com.franksuarez.tictactoe.misc;

import com.franksuarez.tictactoe.exceptions.InvalidCoordinateValue;
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
    private Predicate<T> xGuard = (T x) -> true;
    
    // returns true if valid value for coordinate
    private Predicate<T> yGuard = (T y) -> true;

    public Coordinates() {
        
    }

    public Coordinates(T x, T y) throws InvalidCoordinateValue {
        this();
        

        setX(x);
        setY(y);
    }

    public T getY() {
        return y;
    }
    
    // Build pattern
    public final Coordinates setY(T y) throws InvalidCoordinateValue {
        // only set if passes y guard
        if (yGuard.test(y)) {
            this.y = y;
        } else {
            throw new InvalidCoordinateValue("Invalid Y value");
        }
        return this;
    }

    public T getX() {
        return this.x;
    }

    // Builder pattern
    public final Coordinates setX(T x) throws InvalidCoordinateValue {
        if (xGuard.test(x)) {
            this.x = x;
        } else {
            throw new InvalidCoordinateValue("Invalid X value");
        }
        
        return this;
        
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
    
    /** Calculating the Szudzik Pairing Function number.
     * 
     * 
     * @return 
     */
    public int szudzikPairingFunction() {
        return PairingFunction.szudzikPairingFunction(this.x.intValue(), this.y.intValue());
    }
    
    @Override
    public String toString() {
        return String.format("(%f,%f)", this.x.doubleValue(),this.y.doubleValue());
    }
    
}