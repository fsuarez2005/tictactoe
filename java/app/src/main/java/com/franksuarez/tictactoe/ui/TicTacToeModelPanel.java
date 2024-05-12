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
import java.util.List;

/**
 *
 * @author franksuarez
 */
public class TicTacToeModelPanel extends Panel {

    private TicTacToeBoard board;
    private List<Button> buttons;

    public void configure() {
        setLayout(new GridLayout(3, 3));

    }

    public void populate() {

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                Button b = new Button("X");
                b.setActionCommand("button");

                b.addActionListener((ActionEvent e) -> {
                    System.out.printf("[ACTION]: %s\n", e.toString());

                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                });

                this.add(b);
            }
        }
    }

    public void initializeGame() {
        this.board = new TicTacToeBoard();
    }

    public TicTacToeModelPanel() {
        super();
        configure();
        populate();

    }
}
