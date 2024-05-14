/** Tic-Tac-Toe Panel.
 * 
 */
package com.franksuarez.tictactoe.ui;

import com.franksuarez.tictactoe.misc.PairingFunction;
import com.franksuarez.tictactoe.model.TicTacToeBoard;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
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
    
    
    
    private TicTacToeBoard board = new TicTacToeBoard();
    
    private Map<Integer,Button> buttons = new HashMap<>();

    public void configure() {
        setLayout(new GridLayout(3, 3));
    }
    
    // TODO: create identifier for each button so we can refer to it
    public void createButtons() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                String defaultButtonText = "";
                Button b = new Button(defaultButtonText);
                b.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,32));
                
                String btnActionCommand = String.format("button(%d,%d)",x,y);
                b.setActionCommand(btnActionCommand);
                b.addActionListener(this);
                
                this.buttons.put(PairingFunction.szudzikPairingFunction(x, y), b);
            }
        }
    }

    private void populate() {
        this.add(this.buttons.get(PairingFunction.szudzikPairingFunction(0,2)));
        this.add(this.buttons.get(PairingFunction.szudzikPairingFunction(1,2)));
        this.add(this.buttons.get(PairingFunction.szudzikPairingFunction(2,2)));

        this.add(this.buttons.get(PairingFunction.szudzikPairingFunction(0,1)));
        this.add(this.buttons.get(PairingFunction.szudzikPairingFunction(1,1)));
        this.add(this.buttons.get(PairingFunction.szudzikPairingFunction(2,1)));
        
        this.add(this.buttons.get(PairingFunction.szudzikPairingFunction(0,0)));
        this.add(this.buttons.get(PairingFunction.szudzikPairingFunction(1,0)));
        this.add(this.buttons.get(PairingFunction.szudzikPairingFunction(2,0)));
    }

    

    public void initialize() {
        this.board.initialize(' ');
        configure();
        createButtons();
        populate();
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
        if (this.board.isThereAWinner()) {
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


}
