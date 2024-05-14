/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.ui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/** Tic-Tac-Toe App using TicTacToeBoard class.
 *
 * @author franksuarez
 */
public class TicTacToeApp extends Frame implements WindowListener, ActionListener {
    private int width = 300;
    private int height = 300;
    private String title = "Tic-Tac-Toe";
    
    public static void main(String[] args) {
        TicTacToeApp app = new TicTacToeApp();
        
        app.start();
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void start() {
        configure();
        populateComponents();
        setVisible(true);
        
    }

    private void configure() {
        //setResizable(false);
        addWindowListener(this);
        setSize(width,height);
        setTitle(title);
        setLayout(new GridLayout(2, 1));
        
        
        // setLayout
        
    }

    private void populateComponents() {
        Label status = new Label("Tic-Tac-Toe",Label.CENTER);
        
        add(status);
        
        
        
        TicTacToePanel tttpanel = new TicTacToePanel();
        tttpanel.initialize();
        tttpanel.initializeGame();
        tttpanel.statusLabelRef = status;
        
        
        this.add(tttpanel);
        
    }
}
