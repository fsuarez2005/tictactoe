/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.misc;

import exceptions.InvalidCoordinateValue;


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
     * @param i First integer
     * @param j Second integer
     * @return Pairing integer
     */
    public static int hopcroftUllmanPairing(int i, int j) {
        return triangularNumber((int) (i + j - 2)) + 1;
    }

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
    public static double cantorFunction(double k1, double k2) {
        return ((1.0 / 2.0) * (k1 + k2) * (k1 + k2 + 1) + k2);
    }


}
