/**
 * Utility functions.
 * 
 * TODO:
 * - [ ] Fix Cantor Pairing Functions (Need to find a good source.)
 *
 */


package com.franksuarez.tictactoe;

import java.util.Objects;





/**
 *
 * @author franksuarez
 */
public class Utility {

    public static class Coordinates {

        protected double x;
        protected double y;

        public Coordinates() {
        }

        public Coordinates(double x, double y) {
            super();
            this.x = x;
            this.y = y;
        }

        // TODO: stub
        public String toString() {
            String output = String.format("(%f,%f)", x, y);
            
            
            return output;
        }

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

            Coordinates coord = (Coordinates) o;
            


            return 
                    Objects.equals(x, coord.x) &&
                    Objects.equals(y, coord.y);

        }

    }

    // https://www.cantorsparadise.com/cantor-pairing-function-e213a8a89c2b
    public static double triangularNumber(double k) {
        return (k * (k + 1)) / 2;
    }

    
    // https://mathworld.wolfram.com/PairingFunction.html
    public static double hopcroftUllmanPairing(double i, double j) {
        return triangularNumber(i + j - 2) + i;
    }
    
    public static Coordinates inverseHopcroftUllmanPairing(double h) {
        
        double c = Math.floor(Math.sqrt(2.0 * h) - (1.0/2.0));
        //System.out.printf("c = %f\n",c);
        
        double i = h - triangularNumber(c);
        System.out.printf("i = %f\n",i);
        double j = c - i + 2.0;
        System.out.printf("j = %f\n",j);
        
        
        return new Coordinates(i,j);
        
    }
    
    /**
     * 
     * Works.
     * 
     * @param k1
     * @param k2
     * @return 
     */
    // https://www.cantorsparadise.com/cantor-pairing-function-e213a8a89c2b
    public static double cantorFunction(double k1, double k2) {
        return ((1.0/2.0)*(k1+k2)*(k1+k2+1)+k2);
    }
    

    
    /**
     * 
     * Broken.
     * @param z
     * @return 
     */
    /*
    public static Coordinates invertCantorFunctionOld(double z) {
        double w = Math.floor(
                (Math.sqrt(8.0 * z + 1.0) - 1.0)
                / 2.0
        );

        double t = (w * (w + 1.0)) / 2.0;

        double y = t - z;
        double x = y - w;

        return new Coordinates(x, y);

    }
    
    
    public static Coordinates inverseCantorFunction(double z) {
        
        Coordinates hu = inverseHopcroftUllmanPairing(z);
        return new Coordinates(hu.x - 1,hu.y - 1);
    }
    */

}
