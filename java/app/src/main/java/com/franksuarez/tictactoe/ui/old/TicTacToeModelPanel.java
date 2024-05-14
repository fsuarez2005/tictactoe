/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.ui.old;

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
                b.setActionCommand("button");
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
