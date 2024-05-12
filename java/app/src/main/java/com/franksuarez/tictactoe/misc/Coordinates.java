/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

    public final Coordinates setX(T x) throws InvalidCoordinateValue {
        if (xGuard.test(x)) {
            this.x = x;
        } else {
            throw new InvalidCoordinateValue("Invalid X value");
        }
        
        return this;
        
    }

    private void initializeGuards() {
        this.xGuard = (x) -> {
            return true;
        };
        this.yGuard = (x) -> {
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


// TODO: implement JTS methods in my class
/*


package com.franksuarez.tictactoe.misc;

 // Coordinate class based on JTS implementation.
public class CoordinateJTS {
    // fields
    public static double NULL_ORDINATE = Double.NaN;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }
    
    public double x;
    public static int X = 0;
    
    public double y;
    public static int Y = 1;
    
    public double z;
    public static int Z = 2;
    
    public double m;
    public static int M = 3;
    
    // TODO: stub
    public Object clone() {return null;} 
    
    
    public CoordinateJTS copy() {return null;}
    public CoordinateJTS create() {return null;}
    public double distance(CoordinateJTS c) {
        return 0.0;
    }
    public double distance3D(CoordinateJTS c) {
        return 0.0;
    }
    public boolean equalInZ(CoordinateJTS c, double tolerance) {
        return true;
    }
    public boolean equals(Object other) {
        return true;
    }
    public boolean equals2D(CoordinateJTS other, double tolerance) {
        return true;
    }    
    public boolean equals3D(CoordinateJTS other) {
        return true;
    }
    
    public double getOrdinate(int ordinateIndex) {
        return 0.0;
    }
    
    // TODO: int hashCode()
    // TODO: int hashCode(double x)
    
    public boolean isValid() {
        return true;
    }
    
    public void setCoordinate(CoordinateJTS other) {
        
    }
    
    
    public String toString() {
        return "";
    }
    
}




*/