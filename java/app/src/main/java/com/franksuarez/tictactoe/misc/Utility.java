/**
 * Utility functions.
 *
 * TASKS:
 * - [ ] Fix Cantor Pairing Functions (Need to find a good source.)
 * - [ ] Move to their own classes.
 *
 */
package com.franksuarez.tictactoe.misc;

import java.util.Objects;

/**
 *
 * @author franksuarez
 */
public class Utility {

    public static class Coordinates<T> {

        protected T _x;
        protected T _y;

        public Coordinates() {
        }

        public Coordinates(T x, T y) {
            super();
            this._x = x;
            this._y = y;
        }
        
        public T x(){
            return this._x;
        }
        
        public void x(T _x) {
            this._x = _x;
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

            Coordinates<T> coord = (Coordinates<T>) o;

            return Objects.equals(_x, coord._x)
                    && Objects.equals(_y, coord._y);

        }

        // TODO: verify Coordinates.hashCode works
        @Override
        public int hashCode() {
            int hash = 3;
            hash = 83 * hash + Objects.hashCode(this._x);
            hash = 83 * hash + Objects.hashCode(this._y);
            return hash;
        }

    }

    public static class DoubleCoordinates {

        protected double x;
        protected double y;

        public DoubleCoordinates() {
        }

        public DoubleCoordinates(double x, double y) {
            super();
            this.x = x;
            this.y = y;
        }

        // TODO: Coordinates.toString
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

            DoubleCoordinates coord = (DoubleCoordinates) o;

            return Objects.equals(x, coord.x)
                    && Objects.equals(y, coord.y);

        }

    }

    /**
     * Triangular number.
     *
     * Typecasted to int
     * https://www.cantorsparadise.com/cantor-pairing-function-e213a8a89c2b
     */
    public static int triangularNumber(int k) {
        return (int) ((k * (k + 1.0)) / 2.0);
    }

    /**
     * Hopcroft-Ullman Pairing Function.
     *
     *
     * Typecasted to int.
     *
     * https://mathworld.wolfram.com/PairingFunction.html
     *
     * @param i First integer
     * @param j Second integer
     * @return Pairing integer
     */
    public static int hopcroftUllmanPairing(int i, int j) {
        return triangularNumber((int) (i + j - 2)) + 1;
    }

    public static Coordinates inverseHopcroftUllmanPairing(double h) {

        double c = Math.floor(Math.sqrt(2.0 * h) - (1.0 / 2.0));

        double i = h - triangularNumber((int) c);
        System.out.printf("i = %f\n", i);
        double j = c - i + 2.0;
        System.out.printf("j = %f\n", j);

        return new Coordinates(i, j);

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
        return ((1.0 / 2.0) * (k1 + k2) * (k1 + k2 + 1) + k2);
    }

    /**
     *
     * Broken.
     *
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
    public static class Cons<T, U> {

        private T _first;
        public U _second;

        public Cons(T _first, U _second) {
            this._first = _first;
            this._second = _second;
        }

        public T first() {
            return this._first;
        }

        public void first(T _first) {
            this._first = _first;
        }

        public U second() {
            return this._second;
        }

        public void second(U _second) {
            this._second = _second;
        }

    }

}
