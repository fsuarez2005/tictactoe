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

import com.franksuarez.tictactoe.exceptions.InvalidCoordinateValue;
import com.google.errorprone.annotations.DoNotCall;
import static java.lang.Integer.max;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        double output = (1.0/2.0)*(((double) i) + ((double) j) - 2.0)*(((double) i) + ((double) j) - 1.0)+((double) i);
        
        return Double.valueOf(output).intValue();
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

    /**
     * Szudzik Pairing Function.
     *
     * http://szudzik.com/ElegantPairing.pdf
     *
     * @param x
     * @param y
     * @return
     */
    @DoNotCall
    public static int szudzikPairingFunction(int x, int y) {
        if (x != max(x, y)) { // if x != max(
            return (y * y + x);
        } else {
            return (x * x + x + y);
        }
    }

    @DoNotCall
    public static Coordinates<Integer> inverseSzudzikPairingFunction(int z) {
        Coordinates<Integer> coords = new Coordinates<>();

        double zMinusSqFloorRootZ = z - Math.pow(Math.floor(Math.sqrt(z)), 2);
        
        double floorRootZ = Math.floor(Math.sqrt(z));
        
        double sqFloorRootZ = Math.pow(Math.floor(Math.sqrt(z)), 2.0);
        
        
        double x1 = zMinusSqFloorRootZ;
        double y1 = floorRootZ;
        
        double x2 = floorRootZ;
        double y2 = zMinusSqFloorRootZ - floorRootZ;
        
        
        double choiceLeft = zMinusSqFloorRootZ;
        double choiceRight = floorRootZ;
        
        if (choiceLeft < choiceRight) {
            try {
                coords.setX(Double.valueOf(x1).intValue());
                coords.setY(Double.valueOf(y1).intValue());
            } catch (InvalidCoordinateValue ex) {
                Logger.getLogger(PairingFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (choiceLeft >= choiceRight) {
            try {
                coords.setX(Double.valueOf(x2).intValue());
                coords.setY(Double.valueOf(y2).intValue());
            } catch (InvalidCoordinateValue ex) {
                Logger.getLogger(PairingFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return coords;
    }
}
