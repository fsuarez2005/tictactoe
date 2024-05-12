/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.misc;

/**
 *
 * @author franksuarez
 */
public class Utility {
        /**
     * Gets first char of String else returns elseChar.
     *
     * @param src
     * @param elseChar
     * @return
     */
    private char getFirstOrElse(String src, char elseChar) {
        if (src.length() > 0) {
            return src.charAt(0);
        } else {
            return elseChar;
        }
    }
}
