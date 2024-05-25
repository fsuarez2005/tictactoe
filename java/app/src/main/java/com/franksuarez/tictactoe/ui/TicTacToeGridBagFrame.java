/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.ui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author franksuarez
 */
public class TicTacToeGridBagFrame extends Frame implements WindowListener, ComponentListener, ActionListener {

    private Panel statusPanel;
    private Label statusLabel;

    private final String defaultStatusText = "Tic-Tac-Toe";

    private TicTacToePanel tttPanel;

    public void configure() {
        setResizable(false);
        addWindowListener(this);
        addComponentListener(this);
        setLayout(new FlowLayout());
        setLayout(new GridBagLayout());
    }

    public void createMenuBar() {
        // menu
        MenuBar rootMenuBar = new MenuBar();
        Menu gameMenu = new Menu("Game");
        MenuItem newGameItem = new MenuItem("New Game");
        newGameItem.addActionListener((ActionEvent ae) -> {
            
            this.tttPanel.reset();
            
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        });
        
        
        gameMenu.add(newGameItem);
        
        
        Menu helpMenu = new Menu("Help");
        rootMenuBar.add(gameMenu);
        rootMenuBar.add(helpMenu);
        
        
        this.setMenuBar(rootMenuBar);
        
        
        
        // /menu
    }
    
    
    public void createComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        createMenuBar();
        
        
        // status information
        statusLabel = new Label(defaultStatusText);
        statusLabel.setPreferredSize(new Dimension(200, 50));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        statusPanel = new Panel();
        statusPanel.add(statusLabel,gbc);
        add(statusPanel, gbc);
        // /status
        
        // reset button
//        gbc.gridx = 1;
//        Button resetBtn = new Button("Reset");
//        resetBtn.setActionCommand("reset");
//        resetBtn.addActionListener(this);
//        add(resetBtn);
        // /reset button
        
        
        
        
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        //gbc.gridwidth = 2;
        tttPanel = new TicTacToePanel();

        Dimension tttSize = new Dimension(300, 300);
        tttPanel.setSize(tttSize);
        tttPanel.setMinimumSize(tttSize);
        tttPanel.setPreferredSize(tttSize);
        tttPanel.setMaximumSize(tttSize);

        tttPanel.statusLabelRef = statusLabel;
        tttPanel.initialize();
        add(tttPanel, gbc);

    }

    public void start() {
        configure();
        createComponents();

        pack();
        setSize(getPreferredSize());
        setVisible(true);
    }

    public static void main(String[] args) {
        TicTacToeGridBagFrame app = new TicTacToeGridBagFrame();
        app.start();
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    @Override
    public void componentResized(ComponentEvent e) {
        
        

    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "reset" -> {
                this.tttPanel.reset();
                this.statusLabel.setText(defaultStatusText);
            }
            default -> {}
        }
    }
}
