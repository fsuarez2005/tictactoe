/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author franksuarez
 */
public class TicTacToeApp extends Frame implements WindowListener, ActionListener {
    private String title = "Tic-Tac-Toe";
    private int height = 500;
    private int width = 500;
    
    private InformationalPanel informationalPanel = new InformationalPanel();
    private TicTacToePanel ttt = new TicTacToePanel();
    
    private void configure() {
        setResizable(false);
        
        
        
        addWindowListener(this);
        
        setSize(height,width);
        setTitle(title);
        
        //setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setLayout(new GridLayout(2, 1));
    }
    
    private void initComponents() {

        //informationalPanel.add(new Label("hello"));
        //add(informationalPanel);
        
        Panel textPanel = new Panel();
        textPanel.setBackground(Color.RED);
        textPanel.setMaximumSize(new Dimension(100,100));
        
        Label textLabel = new Label("hello");
        
        textPanel.add(textLabel);
        textPanel.add(new Label(textPanel.getLayout().toString()));

        add(textPanel);
        
        Panel bluePanel = new Panel();
        bluePanel.setBackground(Color.BLUE);
        Dimension size = new Dimension(100,100);
        bluePanel.setMaximumSize(size);
        
        add(bluePanel);
        
        //ttt.start();
        //add(ttt);
    }
    
    public void start() {
        configure();
        initComponents();
        
        setVisible(true);
    }
    
    
    // =========================================================================
    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
        this.dispose();
        System.exit(0);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
