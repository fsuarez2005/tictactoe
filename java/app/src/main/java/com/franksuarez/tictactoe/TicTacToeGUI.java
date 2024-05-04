/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


/**
 * TODO:
 * 
 * - [x] Create basic window.
 * - [ ] Decide between AWT, Swing, JavaFX ...
 * - [ ]
 */



/**
 *
 * @author franksuarez
 */
public class TicTacToeGUI extends Frame {
    private java.util.List<Button> buttons;
    
    
    
    public TicTacToeGUI() {
        
    }
    
    
    /**
     * Places <code>char</char> player in 
     * 
     * 
     * 
     * @param x horizontal position (0 <= x <= 2) with 0 at left.
     * @param y vertical position (0 <= y <= 2) with 0 at the top.
     * @param player 
     */
    public void takeTurn(int x, int y, char player) {
        
        
        
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
            this.buttons.add(new Button(""));
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
        setSize(300,300);
        setTitle("Tic-Tac-Toe");
        setLayout(new GridLayout(3,3));
    }
    
    
    public void setupButtonOnclickCallback() {
        for (int n = 0; n < 9; n++) {
            
            this.buttons.get(n).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    Button b = (Button) e.getComponent();
                    b.setLabel("hi");
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
