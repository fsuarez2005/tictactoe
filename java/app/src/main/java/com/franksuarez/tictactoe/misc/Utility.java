
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
