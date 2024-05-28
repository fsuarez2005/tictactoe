/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.beans;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author franksuarez
 */
public class ImageComponent extends Component {

    private boolean ready = false;
    private int offsetX = 0;
    private int offsetY = 0;

    private String filePath = "";
    private BufferedImage bufImg;

    //private int imageWidth = 0;
    public int getImageWidth() {
        int output = 0;
        if (this.bufImg != null) {
            output = this.bufImg.getWidth();
        }
        return output;
    }

    public int getImageHeight() {
        int output = 0;
        if (this.bufImg != null) {
            output = this.bufImg.getHeight();
        }
        return output;
    }

    
    
    
    
    
    public ImageComponent() {
        System.out.printf("%s%n", this);

        addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                String propertyName = pce.getPropertyName();

                switch (propertyName) {
                    case "filePath" -> {
                        ImageComponent.this.loadImage();

                        // 
                    }
                    case "offsetX" -> {
                        ImageComponent.this.repaint();
                    }
                    case "offsetY" -> {
                        ImageComponent.this.repaint();
                    }
                    case "background" -> {
                        ImageComponent.this.repaint();
                    }
                    
                    default -> {
                        System.out.printf("Uncaught property: %s%n", propertyName);
                    }
                }
            }
        });

    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        System.out.println("setOffsetX()");
        int oldOffsetx = this.offsetX;
        this.offsetX = offsetX;
        firePropertyChange("offsetX", oldOffsetx, offsetX);

    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        int oldOffsetY = this.offsetY;
        this.offsetY = offsetY;
        firePropertyChange("offsetY", oldOffsetY, offsetY);
    }

    public boolean isReady() {
        return this.ready;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        String oldFilePath = this.filePath;
        this.filePath = filePath;
        firePropertyChange("filePath", oldFilePath, filePath);

    }

    @Override
    public void setBackground(Color c) {
        Color oldBackground = this.getBackground();
        firePropertyChange("background", oldBackground, c);
        super.setBackground(c); // sets this.background but does listen for property changes
    }

    
    

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("paint()");
        System.out.printf("bounds: %s%n", this.getBounds());

        Rectangle bounds = this.getBounds();
        Graphics2D g2d = (Graphics2D) g;
        
        
        // if background != null
        //g2d.setBackground(this.getBackground());
        //g2d.clearRect(bounds.x, bounds.y, bounds.width, bounds.height);

        if (this.ready) {
            System.out.println("Painting image.");

            //g2d.drawImage(this.bufImg, null, bounds.x + this.offsetX, bounds.y + this.offsetY);
            g2d.drawImage(this.bufImg, null, 0+this.offsetX, 0+this.offsetY);
        }

    }
    
    
    /** Resizes component to size of image.
     * 
     */
    public void wrapContent() {
        if (this.bufImg == null) {
            // image not loaded
            return;
        }
        
        Dimension newSize = new Dimension(this.bufImg.getWidth(),this.bufImg.getHeight());
        
        
        
        
    }
    

    @Override
    public void invalidate() {
        super.invalidate(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Invalidate()");
    }

    @Override
    public void validate() {
        super.validate(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Validate()");
    }

    private void loadImage() {
        // find image

        URL resource = getClass().getClassLoader().getResource(filePath);
        if (resource == null) {
            System.out.printf("Could not find: %s%n", filePath);
            this.ready = false;
            return;
        }

        try {
            this.bufImg = ImageIO.read(resource);
        } catch (IOException ex) {

            this.ready = false;
            Logger.getLogger(ImageComponent.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.ready = true;

    }

}
