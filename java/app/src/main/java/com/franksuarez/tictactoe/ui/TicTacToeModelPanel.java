/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.ui;

import com.franksuarez.tictactoe.model.TicTacToeBoard;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franksuarez
 */
public class TicTacToeModelPanel extends Panel {
    private TicTacToeBoard board = new TicTacToeBoard();
    
    private Map<Integer,Button> buttons = new HashMap<>();

    public void configure() {
        setLayout(new GridLayout(3, 3));
    }
    
    // TODO: create identifier for each button so we can refer to it
    public void populate() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                
                Button b = new Button(String.format("(%d,%d)",x,y));
                b.setActionCommand("button");

                b.addActionListener((ActionEvent e) -> {
                    System.out.printf("[ACTION]: %s\n", e.toString());
                    Button src = (Button) e.getSource();
                    
                    src.setEnabled(false);
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                });

                this.add(b);
            }
        }
    }

    public void initializeGame() {

    }

    public TicTacToeModelPanel() {
        super();
        configure();
        populate();
    }
}
