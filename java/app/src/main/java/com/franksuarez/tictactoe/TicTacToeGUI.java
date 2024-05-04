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
 */



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
    
    
    public int cellLocationToButtonIndex(int x,int y) {
        return 0;
        
    }
    
    /**
     * Check for cell combinations to determine winner.
     */
    public void checkForWinner() {
        // cell combinations
        
        
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
