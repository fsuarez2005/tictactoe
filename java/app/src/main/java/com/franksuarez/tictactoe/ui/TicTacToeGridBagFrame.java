/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author franksuarez
 */
public class TicTacToeGridBagFrame extends Frame implements WindowListener, ComponentListener {
    private Panel statusPanel;
    private Label statusLabel;
    
    private TicTacToePanel tttPanel;
    
    public void configure() {
        System.out.println("configure()");
        setResizable(false);
        addWindowListener(this);
        addComponentListener(this);
        setLayout(new FlowLayout());
        setLayout(new GridBagLayout());
        
    }
    
    
    public void createComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridy = 0;
        statusLabel = new Label("Tic-Tac-Toe");
        statusLabel.setPreferredSize(new Dimension(200,50));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.gridheight = 50;
        
        statusPanel = new Panel();
        statusPanel.setBackground(Color.red);
        statusPanel.add(statusLabel);
        //statusPanel.setMinimumSize(new Dimension(200,100));
        //statusPanel.setPreferredSize(new Dimension(200, 100));
        add(statusPanel,gbc);
        


        gbc.gridy = 1;
        tttPanel = new TicTacToePanel();
        
        Dimension tttSize = new Dimension(300,300);
        tttPanel.setSize(tttSize);
        tttPanel.setMinimumSize(tttSize);
        tttPanel.setPreferredSize(tttSize);
        tttPanel.setMaximumSize(tttSize);
        
        
        tttPanel.statusLabelRef = statusLabel;
        tttPanel.initialize();
        add(tttPanel,gbc);
        
    }

    public void createComponentsOld() {
        System.out.println("createComponents()");
        statusLabel = new Label("Tic-Tac-Toe");
        statusLabel.setPreferredSize(new Dimension(200,100));
        
        statusPanel = new Panel();
        //statusPanel.setBackground(Color.red);
        statusPanel.add(statusLabel);
        statusPanel.setMinimumSize(new Dimension(200,100));
        statusPanel.setPreferredSize(new Dimension(200, 100));
        add(statusPanel);
        ComponentInfo.generalInfo(statusPanel);
        tttPanel = new TicTacToePanel();
        
        Dimension tttSize = new Dimension(300,300);
        tttPanel.setSize(tttSize);
        tttPanel.setMinimumSize(tttSize);
        tttPanel.setPreferredSize(tttSize);
        tttPanel.setMaximumSize(tttSize);
        
        
        tttPanel.statusLabelRef = statusLabel;
        tttPanel.initialize();
        add(tttPanel);
    }

    public void setWrappedSize() {
        System.out.println("setWrappedSize()");
    }
    
    
    public void start() {
        System.out.println("start()");
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
        System.out.println("windowOpened");
        //System.out.println("WindowEvent");
        ComponentInfo.generalInfo(this);
        
        
        setWrappedSize();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing");        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated");
    }

    @Override
    public void componentResized(ComponentEvent e) {
        System.out.println("componentResized");
        // resize inner components
        
        
        
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        System.out.println("componentMoved");
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void componentShown(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
