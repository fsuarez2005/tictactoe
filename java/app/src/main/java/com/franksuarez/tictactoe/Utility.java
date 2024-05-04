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
    public static int triangularNumber(int k) {
        return (k * (k + 1)) / 2;
    }

    // https://www.cantorsparadise.com/cantor-pairing-function-e213a8a89c2b
    public static int cantorFunction(int k1, int k2) {
        int sum = k1 + k2;
        int triangularNumberOfSum = triangularNumber(sum);
        return (triangularNumberOfSum + k2);
    }

    public static Coordinates InvertCantorFunction(int z) {
        double w = Math.floor(
                (Math.sqrt(8 * z + 1) - 1)
                / 2
        );

        double t = (w * (w + 1)) / 2;

        double y = t - z;
        double x = y - w;

        return new Coordinates(x, y);

    }

    // temp
    // z_cantor();
    // t_cantor = (w*(w+1))/2
    // w_cantor(x,y) = x + y;
    // z_cantor = t + y
    // w = floor(  (sqrt(8*z+1) - 1)/2  )
    // y = (w*(w+1))/2 - z
    // x = y - w
}
