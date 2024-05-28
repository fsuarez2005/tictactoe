/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.exceptions;

/**
 *
 * @author franksuarez
 */
public class InvalidCoordinateValue extends Exception {

    public InvalidCoordinateValue() {
        super();
    }
    
    public InvalidCoordinateValue(String message) {
        super(message);
    }

    public InvalidCoordinateValue(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCoordinateValue(Throwable cause) {
        super(cause);
    }

    public InvalidCoordinateValue(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
