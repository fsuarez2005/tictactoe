/**
 * 
 */


package com.franksuarez.tictactoe.misc;

/** Coordinate class based on JTS implementation.
 *
 * @author franksuarez
 */
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
