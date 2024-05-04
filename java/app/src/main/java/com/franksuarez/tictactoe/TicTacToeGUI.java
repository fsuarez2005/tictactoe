/** Tic-Tac-Toe.
 * In Java AWT.
 * 
 * 
 * TODO:
 * 
 * - [x] Create basic window.
 * - [x] Decide between AWT, Swing, JavaFX ...
 * - [ ] Add reset button.
 * - [ ] Add AI player.
 * - [ ] Add menu.
 * - [ ] Convert hard-coded strings to resources.
 * - [ ] Prevent user from using used cell.
 * 
 * PROBLEMS:
 * 
 * - [ ] Delay when clicking button
 * 
 */

package com.franksuarez.tictactoe;


import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/** 
 *
 * @author franksuarez
 */
public class TicTacToeGUI extends Frame {
    private int frameHeight = 300;
    private int frameWidth = 300;
    private String frameTitle = "Tic-Tac-Toe";
    private char player1 = 'x';
    private char player2 = 'o';
    private int fontSize = 72;
    
    
    // board grid
    private List<Button> buttons;
    
    private char currentPlayer = player1;
    
    public TicTacToeGUI() {
        
    }
    
    /** Maps cell location to Button index.
     * 
     * @param x
     * @param y
     * @return 
     */
    public int cellLocationToButtonIndex(int x,int y) {
        int output = 0;
        
        if (x == 0 && y == 0) {
            output = 0;
        } else if (x == 0 && y == 1) {
            output = 1;
        } else if (x == 2 && y == 2) {
            output = 2;
        } else if (x == 1 && y == 0) {
            output = 3;
        } else if (x == 1 && y == 1) {
            output = 4;
        } else if (x == 1 && y == 2) {
            output = 5;
        } else if (x == 2 && y == 0) {
            output = 6;
        } else if (x == 2 && y == 1) {
            output = 7;
        } else if (x == 2 && y == 2) {
            output = 8;
        } else {
            output = 0;
        }
        
        
        return output;
    }
    
    /** Checks each cell to see if they have matching player indicators.
     * 
     * @param a first cell
     * @param b second cell
     * @param c third cell
     * @param player
     * @return 
     */
    
    public boolean checkLocationForWinner(int a,int b, int c, char player) {
        char aChar = this.buttons.get(a).getLabel().charAt(0);
        char bChar = this.buttons.get(b).getLabel().charAt(0);
        char cChar = this.buttons.get(c).getLabel().charAt(0);
        
        // winner is false if any conndition is false
        boolean winner = true;
        
        
        if (aChar != player || bChar != player || cChar != player) {
            winner = false;
        }
        
        return winner;
        
    }
    
    
    
    
    
    public char checkLocationForWinnerEachPlayer(int a, int b, int c) {
        char output = ' ';

        // player1
        boolean player1winner = checkLocationForWinner(a, b, c, player1);
        
        // player2
        boolean player2winner = checkLocationForWinner(a, b, c, player2);
        
        if (player1winner) {
            output = player1;
        } else if (player2winner) {
            output = player2;
        }
        
        
        
        return output;
    }
    
    /**
     * Check for cell combinations to determine winner.
     */
    public void checkForWinner() {
        // cell locations
        // 0,1,2
        // 3,4,5
        // 6,7,8
        
        // cell combinations
        
        // horizontal
        // 0,1,2
        // 3,4,5
        // 6,7,8
        
        // vertical
        // 0,3,6
        // 1,4,7
        // 2,5,8
        
        // diagonal
        // 0,4,8
        // 2,4,6
        
        
        checkLocationForWinnerEachPlayer(0, 1, 2);
        checkLocationForWinnerEachPlayer(3, 4, 5);
        checkLocationForWinnerEachPlayer(6, 7, 8);
        
        checkLocationForWinnerEachPlayer(0, 3, 6);
        checkLocationForWinnerEachPlayer(1, 4, 7);
        checkLocationForWinnerEachPlayer(2, 5, 8);
        
        checkLocationForWinnerEachPlayer(0, 4, 8);
        checkLocationForWinnerEachPlayer(2, 4, 6);
    }
    
    
    
    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
        
    }
    
    public void addClosingListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                System.exit(0);
            }
            
        });
    }
    
    public void initializeButtonList() {
        
        if (this.buttons == null) {
            this.buttons = new ArrayList<>();
        } else {
            // Buttons may be referenced by Frame so they may leak
            this.buttons.clear();
        }
        
        for(int n = 0; n < 9;n++) {
            Button b = new Button();
            
            b.setFont(new Font("SansSerif",Font.PLAIN,fontSize));
            
            this.buttons.add(b);
        }
        
        
    }
    
    
    public void addComponents() {
        
        // clear table
        this.removeAll();
        
        for(int n = 0; n < 9;n++) {
            this.add(this.buttons.get(n));
        }
        
        
    }
    
    
    public void configureWindow() {
        setSize(frameWidth, frameHeight);
        setTitle(frameTitle);
        setLayout(new GridLayout(3,3));
    }
    
    
    public void setupButtonOnclickCallback() {
        for (int n = 0; n < 9; n++) {
            
            this.buttons.get(n).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    //System.out.printf("DEBUG: Button %d clicked.",n);
                    
                    Button b = (Button) e.getComponent();
                    b.setLabel(String.valueOf(currentPlayer));
                    b.setEnabled(false);
                    
                    switchPlayer();
                    
                    
                }


            });
        }
    }
    
    
    public void start() {
        addClosingListener();
        configureWindow();
        
        initializeButtonList();
        addComponents();
        
        setupButtonOnclickCallback();
        
        setVisible(true);
        
    }
    
    
}
