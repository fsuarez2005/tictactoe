/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.ui;

import java.awt.Component;

/** Display Information about AWT Components.
 *
 * @author franksuarez
 */
public class ComponentInfo {
    public static void generalInfo(Component c) {
        System.out.printf("Component: %s%n",c.toString());
        System.out.printf("size = %s%n",c.getSize());
        
        System.out.printf("height = %d%n",c.getHeight());
        System.out.printf("width = %d%n",c.getWidth());
        
        System.out.printf("preferredSize = %s%n",c.getPreferredSize());
        
    }
}
