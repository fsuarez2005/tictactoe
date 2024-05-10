/** Pairing Functions.
 * 
 * PREFERRED:
 * szudzikPairingFunction(int,int)
 * 
 * 
 * PROBLEMS:
 * - [ ] hopcroftUllmanPairing returns duplicates, need to verify
 * 
 * 
 * 
 */
package com.franksuarez.tictactoe.misc;

import com.google.errorprone.annotations.DoNotCall;
import exceptions.InvalidCoordinateValue;
import static java.lang.Integer.max;


/**
 *
 * @author franksuarez
 */
public class PairingFunction {

    
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
     * TODO: PROBLEM: duplicate key
     * 
     *
     * @param i First integer
     * @param j Second integer
     * @return Pairing integer
     */
    @DoNotCall
    public static int hopcroftUllmanPairing(int i, int j) {
        return triangularNumber((int) (i + j - 2)) + 1;
    }

    @DoNotCall
    public static Coordinates<Integer> inverseHopcroftUllmanPairing(int h) throws InvalidCoordinateValue {
        double c = Math.floor(Math.sqrt(2.0 * h) - (1.0 / 2.0));
        double i = h - triangularNumber((int) c);
        double j = c - i + 2.0;
        
        return new Coordinates<>((int) i, (int) j);
    }
    
    
    /**
     *
     * Works.
     * 
     * https://www.cantorsparadise.com/cantor-pairing-function-e213a8a89c2b
     * 
     * @param k1
     * @param k2
     * @return
     */
    @DoNotCall
    public static double cantorFunction(double k1, double k2) {
        return ((1.0 / 2.0) * (k1 + k2) * (k1 + k2 + 1) + k2);
    }
    
    /** Szudzik Pairing Function.
     * 
     * http://szudzik.com/ElegantPairing.pdf
     * 
     * @param x
     * @param y
     * @return 
     */
    public static int szudzikPairingFunction(int x, int y) {
        if (x != max(x,y)) { // if x != max(
            return (y*y+x);
        } else {
            return (x*x+x+y);
        }
    }
}
