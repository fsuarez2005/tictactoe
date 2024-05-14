/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.ui;

import com.franksuarez.tictactoe.misc.PairingFunction;
import com.franksuarez.tictactoe.model.TicTacToeBoard;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franksuarez
 */
public class TicTacToeModelPanel extends Panel implements ActionListener{
    private TicTacToeBoard board = new TicTacToeBoard();
    
    private Map<Integer,Button> buttons = new HashMap<>();

    public void configure() {
        setLayout(new GridLayout(3, 3));
    }
    
    // TODO: create identifier for each button so we can refer to it
    public void createButtons() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button b = new Button(String.format("(%d,%d)",x,y));
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

    
    
    public void initializeGame() {

    }

    public void initialize() {
        configure();
        createButtons();
        populate();
    }
    
    
    
    public TicTacToeModelPanel() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        
        int x = 0;
        int y = 0;
        
        // determine button pressed
        switch (actionCommand) {
            case "button(0,0)" -> {
                System.out.println("Button 0,0 pressed.");
                x = 0;
                y = 0;
            }
            default -> {
                System.out.println("Unknown action command.");
            }
        }
        
        
        // get current player
        char currentPlayerToken = this.board.getCurrentPlayerToken();
        
        // this panel only consists of Buttons so this should be okay
        Button btn = (Button) e.getSource();
        btn.setLabel(String.valueOf(currentPlayerToken));
        btn.setEnabled(false);
        
        
        // check for winner
        
        
        /*
        this.board.checkForWinner();
        if (this.board.isThereAWinner()) {
            char winningPlayerNumber = this.board.getWinningPlayerNumber();
            
            char winningPlayerToken = this.board.getPlayerToken(winningPlayerNumber);
            // update status information about winner
        
            status.setText(String.format("Player %c has won!",winningPlayerToken));
        
        
        }
        
        
        
        
        
        */
        
        
        
        this.board.switchPlayer();
        
        
        
        
    }


}
