/** Tic-Tac-Toe.
 * In Java AWT.
 *
 *
 * TASKS:
 *
 * - [x] Create basic window.
 * - [x] Decide between AWT, Swing, JavaFX ...
 * - [ ] Add reset button.
 * - [ ] Add AI player.
 * - [ ] Add menu.
 * - [ ] Convert hard-coded strings to resources.
 * - [x] Prevent user from using used cell.
 *
 * PROBLEMS:
 * - [x] Delay when clicking button (switched to ActionListener)
 * - [ ] Components are not the correct sizes.
 *
 */
package com.franksuarez.tictactoe.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/** Tic-Tac-Toe AWT Frame
 *
 * @author franksuarez
 */
public class TicTacToePanel extends Panel implements ActionListener {

    private int height = 300;
    private int width = 300;
    
    private char player1 = 'x';
    private char player2 = 'o';
    private int fontSize = 72;

    public int[][] winnerArray = new int[][]{
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };

    // board grid
    private List<Button> buttons;

    private char currentPlayer = player1;

    
    public TicTacToePanel() {
        setSize(new Dimension(width,height));
        setMaximumSize(new Dimension(width,height));
        setBackground(Color.GREEN);
    }

    /** TODO: move to Utility
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

    /** TODO: move to TicTacToeBoard
     * Checks each cell to see if they have matching player indicators.
     *
     * Problem: * If Button label is empty, there is no first char so an index
     * exception will occur.
     *
     * @param a first cell
     * @param b second cell
     * @param c third cell
     * @param player
     * @return
     */
    public boolean checkLocationForWinner(int a, int b, int c, char player) {
        char aChar = getFirstOrElse(this.buttons.get(a).getLabel(), ' ');
        char bChar = getFirstOrElse(this.buttons.get(b).getLabel(), ' ');
        char cChar = getFirstOrElse(this.buttons.get(c).getLabel(), ' ');

        return (aChar == player && bChar == player && cChar == player);

    }

    /** TODO: move to TicTacToeBoard
     * Check for cell combinations to determine winner.
     *
     * @return
     */
    public char checkForWinner() {
        char winner = ' ';

        for (int[] i : winnerArray) {
            boolean player1won = checkLocationForWinner(i[0], i[1], i[2], player1);
            boolean player2won = checkLocationForWinner(i[0], i[1], i[2], player2);
            if (player1won) {
                winner = player1;
                break;
            } else if (player2won) {
                winner = player2;
                break;
            }

        }
        return winner;

    }

    /** TODO: move to TicTacToeBoard
     * Switches between player 1 and player 2
     *
     */
    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }

    }

    /**
     * Creates Buttons so they can be referenced later.
     *
     */
    public void initializeButtonList() {

        if (this.buttons == null) {
            this.buttons = new ArrayList<>();
        } else {
            // Buttons may be referenced by Frame so they may leak
            this.buttons.clear();
        }

        for (int n = 0; n < 9; n++) {
            Button b = new Button();
            b.addActionListener(this);
            b.setActionCommand("button");
            b.setFont(new Font("SansSerif", Font.PLAIN, fontSize));

            this.buttons.add(b);
        }

    }

    /**
     * Adds widgets to Frame.
     *
     */
    public void addComponents() {

        // clear table
        this.removeAll();

        for (int n = 0; n < 9; n++) {
            this.add(this.buttons.get(n));
        }

    }

    /**
     * Configures Window.
     *
     */
    public void configure() {
        setSize(width, height);

        
        
        setLayout(new GridLayout(3, 3));
    }

    /**
     * Starts the App.
     */
    public void start() {
        configure();

        initializeButtonList();
        addComponents();

        //setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("[EVEN] actionPerformed");
        String actionCommand = e.getActionCommand();
        System.out.printf("actionCommand = %s\n", actionCommand);
        if (actionCommand.equals("button")) {
            Button btn = (Button) e.getSource();
            System.out.printf("Button = %s\n", btn.toString());
            btn.setLabel(String.valueOf(currentPlayer));
            btn.setEnabled(false);

            char winner = checkForWinner();
            if (winner != ' ') {
                System.out.printf("%c has won!\n", winner);
            }

            switchPlayer();
        }
    }

}
