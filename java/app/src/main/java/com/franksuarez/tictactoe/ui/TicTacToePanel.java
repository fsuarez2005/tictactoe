/** Tic-Tac-Toe Panel.
 * 
 */
package com.franksuarez.tictactoe.ui;

import com.franksuarez.tictactoe.misc.PairingFunction;
import com.franksuarez.tictactoe.model.TicTacToeBoard;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author franksuarez
 */
public class TicTacToePanel extends Panel implements ActionListener{
    public Label statusLabelRef;
    private final String defaultButtonText = "";
    private final Font buttonFont = new Font(Font.SANS_SERIF,Font.PLAIN,32);
    
    private TicTacToeBoard board = new TicTacToeBoard();
    
    private Map<String,Button> buttonNameMap = new HashMap<>();
    
    
    
    private Map<Integer,Button> buttons = new HashMap<>();

    public void configure() {
        setLayout(new GridBagLayout());
        
        
        //setLayout(new GridLayout(3, 3));
    }
    
    // TODO: create identifier for each button so we can refer to it
    public void createButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                // create and configure button
                Button b = new Button();
                b.setLabel(defaultButtonText);
                b.setFont(buttonFont);
                Dimension btnSize = new Dimension(100,100);
                b.setMinimumSize(btnSize);
                b.setPreferredSize(btnSize);
                
                String btnIdentifier = String.format("button(%d,%d)",x,y);
                b.setName(btnIdentifier);
                b.setActionCommand(btnIdentifier);
                b.addActionListener(this);
                
                this.buttonNameMap.put(btnIdentifier, b);
                this.buttons.put(PairingFunction.szudzikPairingFunction(x, y), b);
                gbc.gridx = x;
                gbc.gridy = y;
                gbc.fill = GridBagConstraints.BOTH;
                this.add(b, gbc);
            }
        }
    }

    public void initialize() {
        this.board.initialize();
        configure();
        createButtons();
    }
    
    // TODO: BROKEN verify game is fully reset
    public void reset() {
        this.board.reset();
        //this.board.initialize();
        
        for (Button b: this.buttonNameMap.values()) {
            b.setLabel(defaultButtonText);
            b.setEnabled(true);
        }
        
        
        
        // clear buttons
        // enable buttons
//        for (Integer key: this.buttons.keySet()) {
//            Button b = this.buttons.get(key);
//
//            b.setLabel("");
//            b.setEnabled(true);
//            
//        }
        
        
    }
    
    
    public TicTacToePanel() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        
        int x = 0;
        int y = 0;
        
        Pattern buttonXYpattern = Pattern.compile("button\\((\\d+),(\\d+)\\)");
        
        Matcher m = buttonXYpattern.matcher(actionCommand);
        
        
        if (m.find()) {
            x = Integer.parseInt(m.group(1));
            y = Integer.parseInt(m.group(2));
        } else {
            System.out.println("No Match!");
            // throw exception about button
            return;
        }
        
        this.board.makeMove(x, y);
        
        
        // get current player
        char currentPlayerToken = this.board.getCurrentPlayerToken();
        
        // this panel only consists of Buttons so this should be okay
        Button btn = (Button) e.getSource();
        btn.setLabel(String.valueOf(currentPlayerToken));
        btn.setEnabled(false);
        
        System.out.println(this.board.toString());
        
        
        // check for winner
        this.board.checkForWinner();
        if (this.board.getWinnerExists()) {
            System.out.println("Winner found!");
            int winningPlayer = this.board.getWinningPlayer();
            
            char winningPlayerToken = this.board.getPlayerToken(winningPlayer);
            
            statusLabelRef.setText(String.format("Winner: %c", winningPlayerToken));
            
            
            
            // Disable all buttons
            for (Integer b: this.buttons.keySet()) {
                this.buttons.get(b).setEnabled(false);
            }



            // Offer game reset
            
            
        }
        
        this.board.switchPlayer();

        
    }

    
    @Override
    public String toString() {
        return this.board.toString();
    }

}
